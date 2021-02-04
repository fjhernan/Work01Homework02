package edu.csumb.work01homework02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    
    public static final String MAINACTIVITY = "MainActivity";
    private Button create_profile_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(MAINACTIVITY, "onCreate called.");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button create_login_button = findViewById(R.id.main_login_button);
        create_login_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivityForResult(intent, 0);

                Toast toast = Toast.makeText(MainActivity.this, "Log in happened", Toast.LENGTH_LONG);
                toast.show();
            }
        });

        create_profile_button = findViewById(R.id.check_profile_button);
        create_profile_button.setVisibility(View.GONE);


        create_profile_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(intent);
                Toast toast = Toast.makeText(MainActivity.this, "CheckProfile happened", Toast.LENGTH_LONG);
                toast.show();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            if(data.getExtras().getBoolean(LoginActivity.SUCCESS) == true){
            Log.d(MAINACTIVITY, "Login Successful");
                create_profile_button.setVisibility(View.VISIBLE);
            }
        }
    }
}