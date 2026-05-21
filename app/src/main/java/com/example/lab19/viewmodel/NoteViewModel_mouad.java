package com.example.lab19.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.example.lab19.data.NoteRepository_mouad;
import com.example.lab19.data.local.Note_mouad;
import java.util.List;

/**
 * ViewModel pour la gestion de l'état de l'interface.
 * Réalisé par CHARRAJ Mouad aka ZERO-XR7
 */
public class NoteViewModel_mouad extends AndroidViewModel {

    private final NoteRepository_mouad repository_mouad;
    private final LiveData<List<Note_mouad>> toutes_les_notes_mouad;

    public NoteViewModel_mouad(@NonNull Application application_mouad) {
        super(application_mouad);
        repository_mouad = new NoteRepository_mouad(application_mouad);
        toutes_les_notes_mouad = repository_mouad.obtenir_notes_mouad();
    }

    public void ajouter_mouad(Note_mouad note_mouad) {
        repository_mouad.ajouter_mouad(note_mouad);
    }

    public void supprimer_mouad(Note_mouad note_mouad) {
        repository_mouad.supprimer_mouad(note_mouad);
    }

    public void vider_tout_mouad() {
        repository_mouad.vider_tout_mouad();
    }

    public LiveData<List<Note_mouad>> getToutes_les_notes_mouad() {
        return toutes_les_notes_mouad;
    }
}
