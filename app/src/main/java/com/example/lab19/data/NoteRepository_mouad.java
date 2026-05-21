package com.example.lab19.data;

import android.app.Application;
import androidx.lifecycle.LiveData;
import com.example.lab19.data.local.NoteDao_mouad;
import com.example.lab19.data.local.NoteDatabase_mouad;
import com.example.lab19.data.local.Note_mouad;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Repository gérant l'accès aux données.
 * Réalisé par CHARRAJ Mouad aka ZERO-XR7
 */
public class NoteRepository_mouad {

    private final NoteDao_mouad dao_mouad;
    private final LiveData<List<Note_mouad>> liste_notes_mouad;
    private final ExecutorService executeur_mouad;

    public NoteRepository_mouad(Application application_mouad) {
        NoteDatabase_mouad db_mouad = NoteDatabase_mouad.get_instance_mouad(application_mouad);
        dao_mouad = db_mouad.dao_mouad();
        liste_notes_mouad = dao_mouad.fetch_mouad_notes_live();
        executeur_mouad = Executors.newSingleThreadExecutor();
    }

    public void ajouter_mouad(Note_mouad n_mouad) {
        executeur_mouad.execute(() -> dao_mouad.insert_mouad_action(n_mouad));
    }

    public void supprimer_mouad(Note_mouad n_mouad) {
        executeur_mouad.execute(() -> dao_mouad.delete_mouad_action(n_mouad));
    }

    public void vider_tout_mouad() {
        executeur_mouad.execute(dao_mouad::clear_all_mouad_notes);
    }

    public LiveData<List<Note_mouad>> obtenir_notes_mouad() {
        return liste_notes_mouad;
    }
}
