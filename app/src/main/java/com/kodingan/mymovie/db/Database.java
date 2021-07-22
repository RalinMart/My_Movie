package com.kodingan.mymovie.db;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.kodingan.mymovie.db.typeconverters.CastTypeConverter;
import com.kodingan.mymovie.db.typeconverters.GenreTypeConverter;
import com.kodingan.mymovie.db.typeconverters.ReviewTypeConverter;
import com.kodingan.mymovie.model.tmdb.Movie;

@androidx.room.Database(entities = Movie.class, version = 2)
@TypeConverters({CastTypeConverter.class, ReviewTypeConverter.class, GenreTypeConverter.class})
public abstract class Database extends RoomDatabase {
    public abstract FavouriteMoviesDAO getFDAO();

    private static Database instance;

    public static synchronized Database getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), Database.class, "TMDB").addCallback(callback).allowMainThreadQueries().fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback callback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
        }
    };
}
