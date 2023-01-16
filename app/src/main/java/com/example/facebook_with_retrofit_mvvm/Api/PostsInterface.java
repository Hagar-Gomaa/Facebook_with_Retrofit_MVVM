package com.example.facebook_with_retrofit_mvvm.Api;

import com.example.facebook_with_retrofit_mvvm.model.Post;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

public interface PostsInterface {
    @GET("posts")
    public Observable<List<Post>> getPosts();
}
