package zw.co.noityu.notifyu.utilities;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.PopupWindow;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Munyradzi on 08/01/2015.
 */
public class WebServiceAdapter {

    private PopupWindow pwindo;
    private static final String TAG_SUCCESS = "success";
    private static final String RESULT_TAG_NAME = "message";

    private ProgressDialog pDialog;
    JSONParser jsonParser = new JSONParser();
    URI uri;

    private static String url;
    private static String message;
    private static String result = "";
    private static JSONObject jsonResult;
    private static JSONObject arguments;
    private Context context;

    public void call(String url, String message, JSONObject arguments, Context context){
        this.url = url;
        this.message = message;
        this.arguments = arguments;
        this.context = context;

        new makeTheCall().execute();
    }

    class makeTheCall extends AsyncTask<String, String, String> {

        /**
         * Before starting background thread Show Progress Dialog
         */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            if (pDialog != null)
                pDialog.dismiss();
            pDialog = new ProgressDialog(context);
            pDialog.setMessage(message);
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }

        /**
         * Creating product
         */
        protected String doInBackground(String... args) {
            try {
                URL url = new URL(WebServiceAdapter.url);
                URLConnection connection = url.openConnection();
                connection.setDoOutput(true);
                connection.setRequestProperty("Content-Type", "application/json");
                connection.setConnectTimeout(5000);
                connection.setReadTimeout(5000);
                OutputStreamWriter out = new
                        OutputStreamWriter(connection.getOutputStream());
                out.write(WebServiceAdapter.arguments.toString());
                out.close();

                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String str;
                String result = "";
                while ((str = in.readLine()) != null) {
                    result += str;
                }
                Log.d("Actual result", result);
                WebServiceAdapter.result = result;
                WebServiceAdapter.jsonResult = new JSONObject(result);
                Log.d("Result###########", "\nREST Service Invoked Successfully..");
                in.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }

        /**
         * After completing background task Dismiss the progress dialog
         * *
         */
        protected void onPostExecute(String file_url) {
            Log.d("Web Service Response", WebServiceAdapter.result);
        }
    }
}
