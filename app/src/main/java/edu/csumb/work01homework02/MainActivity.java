package edu.csumb.work01homework02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    
    public static final String MAINACTIVITY = "MainActivity";
    public static final String CURRENTUSER = "CurrentUser";
    public static final String CONTENTS = "contents";
    public static final String USERS = "AllUsers";
    public ArrayList<String> contents = new ArrayList<>();
    public List<Post> posts;
    private Button create_profile_button;
    private Button create_login_button;
    private int currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(MAINACTIVITY, "onCreate called.");
        super.onCreate(savedInstanceState);
        ArrayList<Integer> userIds = new ArrayList<>();
        setContentView(R.layout.activity_main);
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        JsonPlaceHolderAPI jsonPlaceHolderAPI = retrofit.create(JsonPlaceHolderAPI.class);
        Call<List<Post>> call = jsonPlaceHolderAPI.getPosts();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if(!response.isSuccessful()){
                    Toast toast = Toast.makeText(MainActivity.this,
                            "Error " + response.code(), Toast.LENGTH_LONG);
                    toast.show();
                    return;
                } else{
                    posts = response.body();
                    userIds.add(0);
                    for(Post post : posts){
                        if(!(userIds.contains(post.getUserId()))){
                            userIds.add(post.getUserId());
                        }
                    }
                }
            }
            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Toast toast = Toast.makeText(MainActivity.this,
                        "Failed to reach api", Toast.LENGTH_LONG);
                toast.show();
            }
        });
        Log.d(MAINACTIVITY, "Login button created");
        create_login_button = findViewById(R.id.main_login_button);
        create_login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(MAINACTIVITY, "LoginActivity started");
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                Bundle bundle = new Bundle();
                bundle.putIntegerArrayList(USERS, userIds);
                intent.putExtras(bundle);
                startActivityForResult(intent, 0);
            }
        });
        create_profile_button = findViewById(R.id.check_profile_button);
        create_profile_button.setVisibility(View.GONE);
        create_profile_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(MAINACTIVITY, "ProfileActivity called");
                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                Bundle bundle = new Bundle();
                bundle.putStringArrayList(CONTENTS, contents);
                bundle.putInt(CURRENTUSER, currentUser);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            if(data.getExtras().getBoolean(LoginActivity.SUCCESS) == true){
                Log.d(MAINACTIVITY, "Login Successful");
                currentUser = data.getExtras().getInt(LoginActivity.ID);
                create_profile_button.setVisibility(View.VISIBLE);
                create_login_button.setVisibility(View.GONE);
                for(Post post : posts){
                    if(post.getUserId() == currentUser) {
                        String content = "";
                        content += post.getId() + "\n";
                        content += post.getTitle() + "\n";
                        content += post.getText() + "\n\n";
                        contents.add(content);
                    }
                }
            }
        }
    }
}