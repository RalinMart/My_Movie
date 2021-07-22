package com.kodingan.mymovie.repository;

import android.os.AsyncTask;

import com.kodingan.mymovie.db.FavouriteMoviesDAO;
import com.kodingan.mymovie.model.tmdb.Movie;

public class AddFavouriteMovie extends AsyncTask<Movie, Void, Void> {
    private FavouriteMoviesDAO favouriteMoviesDAO;

    public AddFavouriteMovie(FavouriteMoviesDAO favouriteMoviesDAO) {
        this.favouriteMoviesDAO = favouriteMoviesDAO;
    }

    @Override
    protected Void doInBackground(Movie... movies) {
        favouriteMoviesDAO.insertFMovie(movies[0]);
        return null;
    }
}
