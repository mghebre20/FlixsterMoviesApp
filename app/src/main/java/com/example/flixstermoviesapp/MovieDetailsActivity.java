package com.example.flixstermoviesapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.flixstermoviesapp.R;
import com.example.flixstermoviesapp.models.Movie;

import org.parceler.Parcels;

public class MovieDetailsActivity extends AppCompatActivity {

    Movie movie;

    TextView tvTitle;
    TextView tvOverview;
    RatingBar rbVoteAverage;
    TextView tvPopularity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);


        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvOverview = (TextView) findViewById(R.id.tvOverview);
        rbVoteAverage = (RatingBar) findViewById(R.id.rbVoteAverage);
        tvPopularity = (TextView) findViewById(R.id.tvPopularity);


        movie = (Movie) Parcels.unwrap(getIntent().getParcelableExtra(Movie.class.getSimpleName()));
        Log.d("MovieDetailsActivity", String.format("Showing details for '%s'", movie.getTitle()));

        tvTitle.setText(movie.getTitle());
        tvOverview.setText(movie.getOverview());
        tvPopularity.setText(movie.getPopularity());

        float voteAverage = movie.getVoteAverage().floatValue();
        rbVoteAverage.setRating(voteAverage = voteAverage > 0 ? voteAverage / 2.0f : voteAverage);

    }
}