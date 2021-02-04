package edu.csumb.work01homework02;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
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

        if(getIntent().getExtras() == null){
            Toast toast = Toast.makeText(ProfileActivity.this, "Intent is empty", Toast.LENGTH_LONG);
            toast.show();
        }
        //Bundle bundle = getIntent().getExtras();

        //ArrayList<String> contents = bundle.getStringArrayList(MainActivity.CONTENTS);
        //int currentUser = bundle.getInt(MainActivity.INT);

        //AlertDialog.Builder builder = new AlertDialog.Builder(ProfileActivity.this);
        //builder.setTitle(0);
/*        builder.setMessage(contents.size());
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
*/
    }
}