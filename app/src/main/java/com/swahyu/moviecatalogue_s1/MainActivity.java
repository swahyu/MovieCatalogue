package com.swahyu.moviecatalogue_s1;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.swahyu.moviecatalogue_s1.Adapter.MovieAdapter;
import com.swahyu.moviecatalogue_s1.Model.Movie;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String[] movieName;
    private String[] movieDescription;
    private String[] movieRelease;
    private TypedArray moviewPoster;
    private MovieAdapter adapter;
    private ArrayList<Movie> movies;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        adapter = new MovieAdapter(this);
        ListView listView = findViewById(R.id.listViewMovie);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, MovieDetailActivity.class);
                intent.putExtra("movie", movies.get(position));
                startActivity(intent);
            }
        });
    }

    private void prepare() {
        movieName = getResources().getStringArray(R.array.movie_name);
        movieDescription = getResources().getStringArray(R.array.movie_description);
        movieRelease = getResources().getStringArray(R.array.movie_release);
        moviewPoster = getResources().obtainTypedArray(R.array.moview_poster);
    }

    private void addItem() {
        movies = new ArrayList<>();
        for (int i = 0; i < movieName.length; i++) {
            Movie m = new Movie();
            m.setTitle(movieName[i]);
            m.setDescription(movieDescription[i]);
            m.setShowDate(movieRelease[i]);
            m.setPhoto(moviewPoster.getResourceId(i, -1));
            movies.add(m);
        }
        adapter.setMovies(movies);
    }

}
