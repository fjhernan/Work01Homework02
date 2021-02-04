package edu.csumb.work01homework02;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {
    public static final String PROFILEACTIVITY = "ProfileActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(PROFILEACTIVITY, "onCreate called");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }
}
