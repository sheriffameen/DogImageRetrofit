package com.example.dogimages;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DogImageService {

    @GET("api/breed/hound/images")
    Call<DogImageList> getDogImage();


}
