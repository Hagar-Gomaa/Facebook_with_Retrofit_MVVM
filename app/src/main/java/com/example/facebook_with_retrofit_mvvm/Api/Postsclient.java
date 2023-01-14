package com.example.facebook_with_retrofit_mvvm.Api;

import com.example.facebook_with_retrofit_mvvm.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Postsclient {

    private PostsInterface postsInterface;
    private static final String BaseUrl ="https://jsonplaceholder.typicode.com/";
    private static Postsclient INstance ;

    public Postsclient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
       postsInterface=  retrofit.create(PostsInterface.class);
    }
    public static Postsclient getInstance (){
        if (INstance==null){
            INstance = new Postsclient();
            return INstance;

        }else {return INstance ;}

    }
    public Call<List<Post>>getPosts (){
        return postsInterface.getPosts();
    }
}
