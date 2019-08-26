package com.swahyu.moviecatalogue_s1.Adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.swahyu.moviecatalogue_s1.MainActivity;
import com.swahyu.moviecatalogue_s1.Model.Movie;
import com.swahyu.moviecatalogue_s1.R;

import java.util.ArrayList;

public class MovieAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Movie> movies;

    public MovieAdapter(Context context) {
        this.context = context;
        movies = new ArrayList<>();
    }

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int position) {
        return movies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_view_item_movie, parent, false);
        }

        ViewHolder viewHolder = new ViewHolder(convertView);
        Movie m = (Movie) getItem(position);
        viewHolder.bind(m);
        return convertView;
    }

    private class ViewHolder {
        private ImageView poster;
        private TextView title, showdate;

        ViewHolder(View view) {
            this.poster = view.findViewById(R.id.imageView);
            this.title = view.findViewById(R.id.textViewTitle);
            this.showdate = view.findViewById(R.id.textViewShowDate);
        }

        void bind(Movie m) {
            poster.setImageResource(m.getPhoto());
            title.setText(m.getTitle());
            showdate.setText(m.getShowDate());
        }
    }
}
