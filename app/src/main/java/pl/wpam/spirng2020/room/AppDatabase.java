package pl.wpam.spirng2020.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {TodoEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract TodoDao TodoDao();
}
