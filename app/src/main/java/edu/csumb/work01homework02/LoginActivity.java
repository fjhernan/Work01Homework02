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

import java.util.ArrayList;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {
    public static final String LOGINACTIVITY = "LoginActivity";
    public static final String SUCCESS = "Success?";
    public static final String ID = "Id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(LOGINACTIVITY, "onCreate called");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ArrayList<String> lazyPasswords = new ArrayList<>();
        for(int i = 0; i < 11; i++){
            lazyPasswords.add(Integer.toString(i));
        }

        Button create_button = findViewById(R.id.login_button);
        create_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(LOGINACTIVITY, "onClick called");
                EditText username = findViewById(R.id.username);
                String str_name = username.getText().toString();
                String acceptableValues[] = new String[] {"1","2","3","4","5","6","7","8","9","10"};
                boolean goodInput = false;
                for(int i = 0; i < 10; i++){
                    if(acceptableValues[i].equals(str_name)){
                        goodInput = true;
                    }
                }
                if(goodInput == true) {
                    int name = Integer.parseInt(str_name);
                    Log.d(LOGINACTIVITY, "username is " + name);
                    ArrayList<Integer> userIds =
                            getIntent().getIntegerArrayListExtra(MainActivity.USERS);
                    if (userIds.contains(name)) {
                        EditText password = findViewById(R.id.password);
                        String pword = password.getText().toString();
                        Log.d(LOGINACTIVITY, "password is " + password);
                        if(lazyPasswords.get(name).equals(pword)) {
                            Log.d(LOGINACTIVITY, "password was correct");
                            AlertDialog.Builder builder = new
                                    AlertDialog.Builder(LoginActivity.this);
                            builder.setTitle("Welcome!");
                            builder.setMessage("Press Ok to continue");
                            builder.setPositiveButton("OK", new
                                    DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Log.d(LOGINACTIVITY, "onClick on dialog called");
                                    Intent intent = new Intent();
                                    Bundle bundle = new Bundle();
                                    bundle.putInt(ID, name);
                                    bundle.putBoolean(SUCCESS, true);
                                    intent.putExtras(bundle);
                                    getIntent().putExtra(SUCCESS, true);
                                    setResult(Activity.RESULT_OK, intent);
                                    finish();
                                }
                            });
                            builder.show();
                        }else{
                            Log.d(LOGINACTIVITY, "Password was incorret");
                            Toast toast = Toast.makeText(LoginActivity.this,
                                    "Error. Password is incorrect.", Toast.LENGTH_LONG);
                            toast.show();
                        }

                    }
                } else{
                    Log.d(LOGINACTIVITY, "Username was incorrect");
                    Toast toast = Toast.makeText(LoginActivity.this,
                           "Error. User doesn't exist.", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
    }
}
