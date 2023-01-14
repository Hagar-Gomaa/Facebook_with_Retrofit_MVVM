package com.example.facebook_with_retrofit_mvvm.Ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.facebook_with_retrofit_mvvm.R;
import com.example.facebook_with_retrofit_mvvm.model.Post;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        PostViewModel postViewModel;
        postViewModel = ViewModelProviders.of(this).get(PostViewModel.class);
       postViewModel.getposts();
        RecyclerView recyclerView ;
        recyclerView =findViewById(R.id.postrecycle);
      final   RecycleAdapter recycleAdapter = new RecycleAdapter();
        recyclerView.setAdapter(recycleAdapter);

        postViewModel.listMutableLiveData.observe(this, new Observer<List<Post>>() {
            @Override
            public void onChanged(List<Post> postList) {
                recycleAdapter.setList(postList);
            }
        });

    }
}