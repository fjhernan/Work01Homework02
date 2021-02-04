package edu.csumb.work01homework02;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    public static final String LOGINACTIVITY = "LoginActivity";
    public static final String SUCCESS = "Success?";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(LOGINACTIVITY, "onCreate called");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button create_button = findViewById(R.id.login_button);
        create_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.d(LOGINACTIVITY, "onClick called");
                EditText username = findViewById(R.id.username);
                String name = username.getText().toString();
                Log.d(LOGINACTIVITY, "username is " + name);
                EditText password = findViewById(R.id.password);
                String pword = password.getText().toString();
                Log.d(LOGINACTIVITY, "passworid is " + password);
                AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                builder.setTitle("Welcome to Login Screen");
                builder.setMessage("You enter " + name + " for the name and " + pword + " for the password");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent();
                        Bundle bundle = new Bundle();
                        bundle.putBoolean(SUCCESS, true);
                        intent.putExtras(bundle);
                        getIntent().putExtra(SUCCESS, true);
                        setResult(Activity.RESULT_OK, intent);
                        finish();
                    }
                });
                builder.show();
            }
        });
        /*AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
        builder.setTitle("Welcome to Login Screen");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.show();*/
    }
}
