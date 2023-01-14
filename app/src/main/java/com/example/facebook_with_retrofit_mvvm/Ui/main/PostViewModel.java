package com.example.facebook_with_retrofit_mvvm.Ui.main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.facebook_with_retrofit_mvvm.Api.Postsclient;
import com.example.facebook_with_retrofit_mvvm.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostViewModel extends ViewModel {
    MutableLiveData<List<Post>> listMutableLiveData = new MutableLiveData<>();

    public void getposts(){
        Postsclient.getInstance().getPosts().enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                listMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
            //  listMutableLiveData.setValue(t.getMessage() +" ");
            }
        });
    }
}
