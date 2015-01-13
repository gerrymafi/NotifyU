package zw.co.noityu.notifyu.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import org.json.JSONObject;

import zw.co.noityu.notifyu.R;
import zw.co.noityu.notifyu.entities.User;
import zw.co.noityu.notifyu.utilities.WebServiceAdapter;


public class SetupActivity extends Activity {
    Context context  = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);

        String[] test=new String[]{"test1","test2"};
        Spinner spinner = (Spinner)findViewById(R.id.school);
        ArrayAdapter<String> arrayAdapter= new ArrayAdapter<String>(SetupActivity.this,android.R.layout.simple_spinner_item, test);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);

        String url = "192.168.173.1/notifyu/getSchools.php";
        String message = "Fetching Schools...";
        JSONObject arguments = new JSONObject();
        WebServiceAdapter webServiceAdapter = new WebServiceAdapter();
        webServiceAdapter.call(url, message, arguments, context);
        Log.d("Schools", "");

    }

    public void temporaryClickHandler(View view){
        Intent intent = new Intent(getBaseContext(), MainActivity.class);
        startActivity(intent);
    }

    public void setupClickHandler(View view) {
        String userName = ((EditText) findViewById(R.id.userName)).getText()
                .toString();
        String password1 = ((EditText) findViewById(R.id.password1)).getText()
                .toString();
        String password2 = ((EditText) findViewById(R.id.password2)).getText()
                .toString();
        String firstName = ((EditText) findViewById(R.id.firstName)).getText()
                .toString();
        String surname = ((EditText) findViewById(R.id.surname)).getText()
                .toString();
        String gender = ((Spinner) findViewById(R.id.gender)).getSelectedItem()
                .toString();
        String school = ((Spinner) findViewById(R.id.school)).getSelectedItem()
                .toString();

        if (userName == null || userName.equals("")) {
            showAlert("You did not provide a user name",
                    R.id.userName);
        } else if (password1 == null || password1.equals("")) {
            showAlert("You did not provide a password",
                    R.id.password1);
        } else if (!password1.equals(password2)) {
            showAlert("Passwords do not match",
                    R.id.password2);
        } else if (firstName == null || firstName.equals("")) {
            showAlert("You did not provide a first name",
                    R.id.firstName);
        }  else if (surname == null || surname.equals("")) {
            showAlert("You did not provide a surname",
                    R.id.surname);
        }  else {
            User user = new User();
            user.setUserName(userName);
            user.setPassword(password1);
            user.setFirstName(firstName);
            user.setLastName(surname);
            user.setGender(gender);
            user.setSchoolName(school);

        }
    }

    public void showAlert(String message, final int id) {
        new AlertDialog.Builder(this)
                .setTitle("Missing Information")
                .setMessage(message)
                .setPositiveButton(android.R.string.yes,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                ((EditText) findViewById(id)).requestFocus();
                            }
                        }).setIcon(android.R.drawable.ic_dialog_alert).show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_setup, menu);
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
