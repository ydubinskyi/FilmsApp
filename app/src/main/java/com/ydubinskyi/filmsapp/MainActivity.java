package com.ydubinskyi.filmsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.ydubinskyi.filmsapp.adapter.MoviesAdapter;
import com.ydubinskyi.filmsapp.api.ApiService;
import com.ydubinskyi.filmsapp.api.Movie;
import com.ydubinskyi.filmsapp.api.MovieResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private final static String API_KEY = "24887d21d7f4a96154895b95c9723021";

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button bTopRated = findViewById(R.id.bTopRated);
        Button bPopular = findViewById(R.id.bPopular);
        Button bUpcoming = findViewById(R.id.bUpcoming);


        bTopRated.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TopRatedFilmsActivity.class);
                startActivity(intent);
            }
        });

        bPopular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PopularFilmsActivity.class);
                startActivity(intent);
            }
        });

        bUpcoming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, UpcomingFilmsActivity.class);
                startActivity(intent);
            }
        });

        

    }



}
