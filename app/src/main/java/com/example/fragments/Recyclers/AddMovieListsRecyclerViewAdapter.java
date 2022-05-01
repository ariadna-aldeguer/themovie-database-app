package com.example.fragments.Recyclers;


import static com.example.fragments.Config.DefaultConstants.API_KEY;
import static com.example.fragments.Config.DefaultConstants.SESSION_ID;
import static com.example.fragments.Config.DefaultConstants.retrofit;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fragments.Config.ApiCall;
import com.example.fragments.Model.List.AddListResponse;
import com.example.fragments.Model.List.List;
import com.example.fragments.Model.List.ListAddItemRequest;
import com.example.fragments.Model.List.ListDetails;
import com.example.fragments.Model.List.ListMovies;
import com.example.fragments.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddMovieListsRecyclerViewAdapter extends RecyclerView.Adapter<AddMovieListsRecyclerViewAdapter.ViewHolder> {
    private ArrayList<List> arrayList;
    private ArrayList<ListMovies> arrayMovies;
    private Context context;
    int media_id;
    RecyclerView recyclerView;
    AlertDialog dialogList;

    public AddMovieListsRecyclerViewAdapter(ArrayList<List> arrN, Context c, int media_id, final AlertDialog dialogList ){
        this.arrayList = arrN;
        this.context = c;
        this.media_id = media_id;
        this.dialogList = dialogList;
    }
    public AddMovieListsRecyclerViewAdapter(ArrayList<List> arrN, Context c){
        this.arrayList = arrN;
        this.context = c;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {
        holder.listTitle.setText(arrayList.get(i).getName());
        holder.itemCount.setText(String.valueOf(arrayList.get(i).getCount()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //#region ApiCall getLists
                ApiCall apiCall = retrofit.create(ApiCall.class);
                Log.i("id", "" + arrayList.get(i).getId());
                Log.i("id", "" + media_id);
                /*Call<ListDetails> call = apiCall.getMoviesOfList();*/
                ListAddItemRequest request = new ListAddItemRequest(media_id);
                Call<AddListResponse> call = apiCall.addItem(arrayList.get(i).getId(), API_KEY, SESSION_ID,request);

                call.enqueue(new Callback<AddListResponse>(){
                    @Override
                    public void onResponse(Call<AddListResponse> call, Response<AddListResponse> response) {
                        if(response.code()!=201){
                            Log.i("AddMovieToList", "error");
                            Log.i("AddMovieToList", response.message());
                            Log.i("AddMovieToList", response.errorBody().toString());
                            return;
                        }else {
                            Log.i("AddMovieToList", "bien");
                            Toast.makeText(view.getContext(), "Save correctly", Toast.LENGTH_LONG).show();
                            dialogList.dismiss();
                        }
                    }

                    @Override
                    public void onFailure(Call<AddListResponse> call, Throwable t) {
                        Log.i("MoviesListFragment", "error" + t.getMessage());
                    }
                });
            }
        });


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView listTitle;
        TextView itemCount;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            listTitle = itemView.findViewById(R.id.listTitle);
            itemCount= itemView.findViewById(R.id.itemCount);
        }
    }

    public void callRecyclerMovies(ArrayList<ListMovies> arrayMovies){
        MoviesOfListRecyclerViewAdapter adapter = new MoviesOfListRecyclerViewAdapter(arrayMovies, context);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
    }
}

