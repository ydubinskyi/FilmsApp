package com.ydubinskyi.filmsapp.api;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.widget.Toast.LENGTH_SHORT;
import static android.widget.Toast.makeText;


public class Details extends AppCompatActivity {

    public static final String TRACK = "track" ;
    public static final String ARTIST = "artist" ;
    public static final String TRACK_ID = "track_id" ;

    String track;
    String artist;
    int trackId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_details);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        track = getIntent().getStringExtra(TRACK);
        artist = getIntent().getStringExtra(ARTIST);
        trackId = getIntent().getIntExtra(TRACK_ID, -1 );

        getSupportActionBar().setTitle(track);
        getSupportActionBar().setSubtitle(artist);
        ApiService. getService ().getTrack(trackId).enqueue(new Callback<Tracks>() {
            @Override
            public void onResponse(@NonNull Call<Tracks> call, @NonNull Response<Tracks>
                    response) {
                Tracks tracks = response.body();
                if (tracks != null && tracks. track .size() > 0 ) {
                    showData(tracks.track .get( 0 ));
                }
            }
            @Override
            public void onFailure( @NonNull Call<Film> call, @NonNull Throwable t) {
                makeText (
                        Details. this ,
                        "Błąd pobierania danych: " + t.getLocalizedMessage(),
                        LENGTH_SHORT
                ).show();
            }
        });

    }


    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();

        return true;
    }


}
