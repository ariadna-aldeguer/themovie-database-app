package com.example.fragments.Recyclers;

import static com.example.fragments.Config.DefaultConstants.BASE_IMG_URL;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

import com.example.fragments.Model.Film.Film;

import java.util.ArrayList;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fragments.Config.GlideApp;
import com.example.fragments.DetailFragment;
import com.example.fragments.Model.Film.Film;
import com.example.fragments.R;


public class ListFavoritesRecylerViewAdapter extends RecyclerView.Adapter<ListFavoritesRecylerViewAdapter.ViewHolder>{
    private ArrayList<Film> arrayMovies;
    private Context context;

    public ListFavoritesRecylerViewAdapter(ArrayList<Film> arrayMovies, Context context) {
        this.arrayMovies = arrayMovies;
        this.context = context;
    }

    @NonNull
    @Override
    public ListFavoritesRecylerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        ListFavoritesRecylerViewAdapter.ViewHolder holder = new ListFavoritesRecylerViewAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ListFavoritesRecylerViewAdapter.ViewHolder holder, int i) {
        holder.listTitle.setText(arrayMovies.get(i).getOriginal_title().toString());
        holder.itemCount.setText(String.valueOf(i));
    }

    @Override
    public int getItemCount() {
        return arrayMovies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView listTitle, itemCount;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            listTitle = itemView.findViewById(R.id.listTitle);
            itemCount = itemView.findViewById(R.id.itemCount);
        }
    }
}
