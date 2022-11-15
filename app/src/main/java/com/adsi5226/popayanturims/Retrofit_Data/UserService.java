package com.adsi5226.popayanturims.Retrofit_Data;

import com.adsi5226.popayanturims.Modelo.RegisterRequest;
import com.adsi5226.popayanturims.Modelo.RegisterResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserService {




    @POST("user")
    Call<RegisterResponse>registerUsers(@Body RegisterRequest registerRequest);
}
