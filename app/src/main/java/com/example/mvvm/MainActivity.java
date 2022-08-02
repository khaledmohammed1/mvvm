package com.example.mvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.mvvm.adapter.PhotoAdapter;
import com.example.mvvm.model.PhotoModel;
import com.example.mvvm.viewmodel.PhotoListViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<PhotoModel> photoModelList;
    private PhotoAdapter adapter;
    private PhotoListViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        final TextView noresult = findViewById(R.id.noResultTv);
        LinearLayoutManager layoutManager = new GridLayoutManager(this,1);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new PhotoAdapter(this,photoModelList);
        recyclerView.setAdapter(adapter);

        viewModel = ViewModelProviders.of(this).get(PhotoListViewModel.class);
        viewModel.getPhotoListObserver().observe(this, new Observer<List<PhotoModel>>() {
            @Override
            public void onChanged(List<PhotoModel> photoModels) {
                if(photoModels != null){
                    photoModelList = photoModels;
                    adapter.setPhotoList(photoModels);
                    noresult.setVisibility(View.GONE);

                }else{
                  noresult.setVisibility(View.VISIBLE);
                }
            }
        });
        viewModel.makeApiCall();
    }
}