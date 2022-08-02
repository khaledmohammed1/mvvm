package com.example.mvvm.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvm.data.APIService;
import com.example.mvvm.data.RetrofitInstance;
import com.example.mvvm.model.PhotoModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotoListViewModel extends ViewModel {
    private MutableLiveData<List<PhotoModel>> photoList;
    public PhotoListViewModel() {
        photoList = new MutableLiveData<>();
    }
    public MutableLiveData<List<PhotoModel>> getPhotoListObserver(){
        return photoList;
    }
    public void makeApiCall(){
        APIService apiService = RetrofitInstance.getRetrofitClient().create(APIService.class);
        Call<List<PhotoModel>> call = apiService.getPhotoList();
        call.enqueue(new Callback<List<PhotoModel>>() {
            @Override
            public void onResponse(Call<List<PhotoModel>> call, Response<List<PhotoModel>> response) {
                photoList.postValue(response.body());
                System.out.println(response.body());
            }

            @Override
            public void onFailure(Call<List<PhotoModel>> call, Throwable t) {
                photoList.postValue(null);
            }
        });
    }
}
