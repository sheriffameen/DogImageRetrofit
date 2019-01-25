package com.example.dogimages;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Sheriff Activity";
    private DogImageService dogImageService;
    public static final String BASE_DOGIMAGE_URL = "https://dog.ceo/";
    private RecyclerView dogImage_recyclerView;
    private DogImageAdapter dogImageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dogImage_recyclerView = findViewById(R.id.dogImage_recyclerview);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_DOGIMAGE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        dogImageService = retrofit.create(DogImageService.class);
        Call<DogImageList> dogImageListCall = dogImageService.getDogImage();
        dogImageListCall.enqueue(new Callback<DogImageList>() {
            @Override
            public void onResponse(Call<DogImageList> call, Response<DogImageList> response) {
                if (response.body() == null){
                    //d Do some error handling
                    Log.d(TAG,"BODY IS NULL");

                } else {
                    //show planets

                    List<String> dogImageList = response.body().getMessage();
                    Log.d(TAG, "onCreate: " + response.body());
                    dogImageAdapter = new DogImageAdapter(dogImageList);
                    dogImage_recyclerView.setAdapter(dogImageAdapter);
                    GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),3);
                    dogImage_recyclerView.setLayoutManager(gridLayoutManager);

                }

            }

            @Override
            public void onFailure(Call<DogImageList> call, Throwable t) {

            }
        });


    }
}
