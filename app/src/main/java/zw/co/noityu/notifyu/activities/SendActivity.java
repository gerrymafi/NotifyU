package zw.co.noityu.notifyu.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;

import zw.co.noityu.notifyu.R;


public class SendActivity extends Activity {
    private Button btnClosePopup;
    private Button btnCancelPopup;

    private PopupWindow pwindo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);

        initiatePopupWindow();
    }

    private void initiatePopupWindow() {
        try {
            // We need to get the instance of the LayoutInflater
            LayoutInflater inflater = (LayoutInflater) SendActivity.this
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final View layout = inflater.inflate(R.layout.custom_login,
                    (ViewGroup) findViewById(R.id.popup_element));
            pwindo = new PopupWindow(layout, 600, 600, true);

            layout.post(new Runnable() {
                public void run() {
                    pwindo.showAtLocation(layout, Gravity.CENTER, 0, 0);
                }
            });

            btnClosePopup = (Button) layout.findViewById(R.id.btn_close_popup);
            btnClosePopup.setOnClickListener(login_button_click_listener);
            btnCancelPopup = (Button) layout.findViewById(R.id.btn_cancel_popup);
            btnCancelPopup.setOnClickListener(cancel_button_click_listener);
            View contentView = pwindo.getContentView();
            EditText username = (EditText)contentView.findViewById(R.id.username);
            EditText password = (EditText)contentView.findViewById(R.id.password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private View.OnClickListener login_button_click_listener = new View.OnClickListener() {
        public void onClick(View v) {
            pwindo.dismiss();
            Intent intent = new Intent(getBaseContext(), MainActivity.class);
            startActivity(intent);
        }
    };


    private View.OnClickListener cancel_button_click_listener = new View.OnClickListener() {
        public void onClick(View v) {
            pwindo.dismiss();
            Intent intent = new Intent(getBaseContext(), MainActivity.class);
            startActivity(intent);
        }
    };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_send, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
