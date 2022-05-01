package com.example.fragments.Config;

import com.example.fragments.Model.Film.FavFilmRequest;
import com.example.fragments.Model.Film.FavFilmResponse;
import com.example.fragments.Model.List.AddListResponse;
import com.example.fragments.Model.List.List;
import com.example.fragments.Model.List.ListAddItemRequest;
import com.example.fragments.Model.List.ListDetails;
import com.example.fragments.Model.List.ListModel;
import com.example.fragments.Model.List.ListRequest;
import com.example.fragments.Model.List.ListResponse;
import com.example.fragments.Model.Film.searchFilmModel;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiCall {

    @GET("search/movie?")
    Call<searchFilmModel> getData(@Query("api_key") String api_key, @Query("query") String query);

    @GET("account/{account_id}/favorite/movies?")
    Call<searchFilmModel> getFavorites(@Query("api_key") String api_key, @Query("session_id") String session_id);

    @GET("account/{account_id}/lists?")
    Call<ListModel> getLists(@Query("api_key") String api_key, @Query("session_id") String session_id);

    @GET("list/{list_id}?")
    Call<ListDetails> getMoviesOfList(@Query("list_id") String list_id, @Query("api_key") String api_key);

    /*@GET("list/8195345?api_key=4e1080967ee9a36d94e4cd323d6c8de5")
    Call<ListDetails> getMoviesOfList();*/

    @POST("account/{account_id}/favorite?")
    Call<FavFilmResponse> setFavorite(@Query("account_id") String account_id, @Query("api_key") String api_key, @Query("session_id") String session_id, @Body FavFilmRequest request);

    @POST("list?")
    Call<ListResponse> postList(@Query("api_key") String api_key, @Query("session_id") String session_id, @Body ListRequest request);

    @POST("list/{list_id}/add_item?")
    Call<AddListResponse> addItem(@Path("list_id") int list_id, @Query("api_key") String api_key, @Query("session_id") String session_id, @Body ListAddItemRequest request);
}
