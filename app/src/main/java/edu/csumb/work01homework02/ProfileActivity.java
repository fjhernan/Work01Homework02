package edu.csumb.work01homework02;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity {
    
    public static final String PROFILEACTIVITY = "ProfileActivity";

    @SerializedName("body")
    private String text;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(PROFILEACTIVITY, "onCreate called");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ArrayList<String> contents = new ArrayList<>();
        contents = getIntent().getStringArrayListExtra(MainActivity.CONTENTS);
        TextView textView = findViewById(R.id.profile_view);
        textView.append("Welcome " + getIntent().getExtras().getInt(MainActivity.CURRENTUSER) + "\n\n");
        Log.d(PROFILEACTIVITY, "textView appended");
        for(int i = 0; i < contents.size(); i++){
            textView.append("Post: " + contents.get(i));
        }
    }
}