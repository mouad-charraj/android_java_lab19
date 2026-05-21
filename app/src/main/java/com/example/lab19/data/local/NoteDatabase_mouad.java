package com.example.lab19.data.local;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

/**
 * Base de données Room unique.
 * Réalisé par CHARRAJ Mouad aka ZERO-XR7
 */
@Database(entities = {Note_mouad.class}, version = 1, exportSchema = false)
public abstract class NoteDatabase_mouad extends RoomDatabase {

    public abstract NoteDao_mouad dao_mouad();

    private static volatile NoteDatabase_mouad instance_mouad;

    public static NoteDatabase_mouad get_instance_mouad(Context contexte_mouad) {
        if (instance_mouad == null) {
            synchronized (NoteDatabase_mouad.class) {
                if (instance_mouad == null) {
                    instance_mouad = Room.databaseBuilder(
                                    contexte_mouad.getApplicationContext(),
                                    NoteDatabase_mouad.class,
                                    "mouad_secure_notes_db"
                            )
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return instance_mouad;
    }
}
