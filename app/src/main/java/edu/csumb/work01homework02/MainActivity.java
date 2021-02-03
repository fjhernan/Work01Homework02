package edu.csumb.work01homework02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    
    public static final String MAINACTIVITY = "MainActivity";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(MAINACTIVITY, "onCreate called.");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}