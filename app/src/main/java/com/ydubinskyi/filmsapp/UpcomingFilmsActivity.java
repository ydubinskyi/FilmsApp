package com.ydubinskyi.filmsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.ydubinskyi.filmsapp.adapter.MoviesAdapter;
import com.ydubinskyi.filmsapp.api.ApiService;
import com.ydubinskyi.filmsapp.api.Movie;
import com.ydubinskyi.filmsapp.api.MovieResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpcomingFilmsActivity extends AppCompatActivity {

    private final static String API_KEY = "24887d21d7f4a96154895b95c9723021";

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popular_films);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Call<MovieResponse> topMoviesCall = ApiService.getService().getUpcomingMovies(API_KEY);

        topMoviesCall.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                List<Movie> movies = response.body().getResults();
                recyclerView.setAdapter(new MoviesAdapter(movies, R.layout.list_item_movie, getApplicationContext()));
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Log.d("TAG", t.toString());
            }
        });
    }
}
