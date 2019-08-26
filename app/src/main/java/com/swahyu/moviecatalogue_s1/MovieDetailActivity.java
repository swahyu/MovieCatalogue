package com.swahyu.moviecatalogue_s1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.swahyu.moviecatalogue_s1.Model.Movie;

public class MovieDetailActivity extends AppCompatActivity {
    private Movie movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        TextView textViewTitle = findViewById(R.id.textViewTitle);
        TextView textViewRelease = findViewById(R.id.textViewShowDate);
        TextView textViewDescription = findViewById(R.id.textViewDescription);
        ImageView imageViewPoster = findViewById(R.id.dImageViewMovie);

        movie = new Movie();
        movie = getIntent().getParcelableExtra("movie");

        textViewTitle.setText(movie.getTitle());
        textViewRelease.setText(movie.getShowDate());
        textViewDescription.setText(movie.getDescription());
        imageViewPoster.setImageResource(movie.getPhoto());

    }
}
