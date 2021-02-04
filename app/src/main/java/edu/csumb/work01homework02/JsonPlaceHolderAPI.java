package edu.csumb.work01homework02;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderAPI {

    @GET("posts")
    Call<List<Post>> getPosts();

}
