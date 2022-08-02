package com.example.mvvm.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.mvvm.R;
import com.example.mvvm.model.PhotoModel;

import java.util.List;

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.MyViewHolder> {
    private Context context;
    private List<PhotoModel> photoList;
    public PhotoAdapter(Context context,List<PhotoModel> photoList){
     this.context = context;
     this.photoList = photoList;
    }

    public void setPhotoList(List<PhotoModel> photoList){
        this.photoList = photoList;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public PhotoAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View view =  LayoutInflater.from(context).inflate(R.layout.recyler_row,parent,false);
      return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull PhotoAdapter.MyViewHolder holder, int position) {
     holder.tvTitle.setText(this.photoList.get(position).getTitle().toString());
        Glide.with(context).
        load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSH_-NHSEJsZbaTAL6tllFCfx3V88pKylmZkAMa8Fjd&s").
//                load(this.photoList.get(position).getThumbnailUrl()).
                apply(RequestOptions.centerCropTransform()).
                into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        if(this.photoList != null){
            return this.photoList.size();
        }
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        ImageView imageView;
        public MyViewHolder(View itemView){
            super(itemView);
            tvTitle = (TextView)itemView.findViewById(R.id.titleView);
            imageView = (ImageView)itemView.findViewById(R.id.imageView);

        }
    }
}
