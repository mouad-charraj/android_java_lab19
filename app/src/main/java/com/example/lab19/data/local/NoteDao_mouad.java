package com.example.lab19.data.local;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

/**
 * Interface d'accès aux données - Version Unique de Mouad.
 * Réalisé par CHARRAJ Mouad aka ZERO-XR7
 */
@Dao
public interface NoteDao_mouad {

    @Insert
    void insert_mouad_action(Note_mouad note_obj_mouad);

    @Delete
    void delete_mouad_action(Note_mouad note_obj_mouad);

    @Query("DELETE FROM table_notes_mouad")
    void clear_all_mouad_notes();

    @Query("SELECT * FROM table_notes_mouad ORDER BY id_mouad DESC")
    LiveData<List<Note_mouad>> fetch_mouad_notes_live();
}
