package com.example.fragments.Config;

import com.example.fragments.Model.Film.FavFilmRequest;
import com.example.fragments.Model.Film.FavFilmResponse;
import com.example.fragments.Model.List.List;
import com.example.fragments.Model.List.ListResponse;
import com.example.fragments.Model.Film.searchFilmModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiCall {

    @GET("search/movie?")
    Call<searchFilmModel> getData(@Query("api_key") String api_key, @Query("query") String query);

    @GET("account/{account_id}/favorite/movies?")
    Call<searchFilmModel> getFavorites(@Query("api_key") String api_key, @Query("session_id") String session_id);

    @POST("account/{account_id}/favorite?")
    Call<FavFilmResponse> setFavorite(@Query("account_id") String account_id, @Query("api_key") String api_key, @Query("session_id") String session_id, @Body FavFilmRequest request);

    @POST("list?")
    Call<ListResponse> postList(@Query("api_key") String api_key, @Query("query") String session_id, @Body List list);
}
