package com.example.facebook_with_retrofit_mvvm.Ui.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

import com.example.facebook_with_retrofit_mvvm.R;
import com.example.facebook_with_retrofit_mvvm.model.Post;

import java.util.ArrayList;
import java.util.List;

public class RecycleAdapter  extends RecyclerView.Adapter<RecycleAdapter.PostViewHolder> {


    List<Post> postArrayList=new ArrayList<>();

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate( R.layout.postitem,parent,false);

        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {

        holder.title.setText(postArrayList.get(position).getTitle());
        holder.uerid.setText(postArrayList.get(position).getUserId()+"");
        holder.body.setText(postArrayList.get(position).getBody());


    }

    @Override
    public int getItemCount() {
        return postArrayList.size() ;
    }
    public void  setList(List<Post> list){
        this.postArrayList =list;
        notifyDataSetChanged();
    }

    class PostViewHolder extends RecyclerView.ViewHolder{
        TextView title ,uerid ,body ;
        public PostViewHolder(@NonNull View itemView) {
            super(itemView);

        title =itemView.findViewById(R.id.posttitle);
        uerid = itemView.findViewById(R.id.userid);
        body =itemView.findViewById(R.id.body);
        }
    }
}
