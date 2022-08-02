package com.example.mvvm.data;

import com.example.mvvm.model.PhotoModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {
    @GET("photos")
    Call<List<PhotoModel>> getPhotoList();
}
