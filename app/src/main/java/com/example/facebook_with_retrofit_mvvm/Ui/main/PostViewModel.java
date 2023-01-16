package com.example.facebook_with_retrofit_mvvm.Ui.main;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.facebook_with_retrofit_mvvm.Api.Postsclient;
import com.example.facebook_with_retrofit_mvvm.model.Post;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostViewModel extends ViewModel {
    MutableLiveData<List<Post>> listMutableLiveData = new MutableLiveData<>();
    private static final String TAG = "PostViewModel";

    public void getposts(){

        Observable observable = Postsclient.getInstance().getPosts()
                .subscribeOn(Schedulers.io())
;

        Observer observer = new Observer() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(Object value) {
                listMutableLiveData. postValue( ((List<Post>) value));
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: " + e);

            }

            @Override
            public void onComplete() {

            }};
        observable.subscribe(observer);


            //with CallBacks

//        Postsclient.getInstance().getPosts().enqueue(new Callback<List<Post>>() {
//            @Override
//            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
//                listMutableLiveData.setValue(response.body());
//            }
//
//            @Override
//            public void onFailure(Call<List<Post>> call, Throwable t) {
//            //  listMutableLiveData.setValue(t.getMessage() +" ");
//            }
//        });
        }
}
