package com.example.fragments.Config;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DefaultConstants {

    public static final String API_KEY = "4e1080967ee9a36d94e4cd323d6c8de5";
    public static final String SESSION_ID = "9024e4309a762527c542e21e178811e1a227adab";
    public static final String ACCOUNT_ID = "miquelmasso19";

    public static final String BASE_IMG_URL = "https://image.tmdb.org/t/p/w500/";

    public static final Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl("https://api.themoviedb.org/3/")
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();

}
