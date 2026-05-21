package com.example.lab19;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab19.data.local.Note_mouad;
import com.example.lab19.ui.NoteAdapter_mouad;
import com.example.lab19.viewmodel.NoteViewModel_mouad;
import com.google.android.material.textfield.TextInputEditText;

/**
 * Activité principale personnalisée pour Mouad.
 * Réalisé par CHARRAJ Mouad aka ZERO-XR7.
 */
public class MainActivity extends AppCompatActivity {

    private NoteViewModel_mouad viewModel_mouad;
    private TextInputEditText etTitre_mouad;
    private TextInputEditText etDesc_mouad;
    private Button btnAjouter_mouad;
    private Button btnVider_mouad;
    private NoteAdapter_mouad adapter_mouad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTitre_mouad = findViewById(R.id.etTitle_mouad);
        etDesc_mouad = findViewById(R.id.etDescription_mouad);
        btnAjouter_mouad = findViewById(R.id.btnAdd_mouad);
        btnVider_mouad = findViewById(R.id.btnDeleteAll_mouad);

        RecyclerView rv_mouad = findViewById(R.id.recyclerView_mouad);
        rv_mouad.setLayoutManager(new LinearLayoutManager(this));
        rv_mouad.setHasFixedSize(true);

        adapter_mouad = new NoteAdapter_mouad();
        rv_mouad.setAdapter(adapter_mouad);

        viewModel_mouad = new ViewModelProvider(this).get(NoteViewModel_mouad.class);

        viewModel_mouad.getToutes_les_notes_mouad().observe(this, liste_mouad -> {
            adapter_mouad.setNotes_mouad(liste_mouad);
        });

        btnAjouter_mouad.setOnClickListener(v_mouad -> {
            sauvegarder_mouad();
        });

        btnVider_mouad.setOnClickListener(v_mouad -> {
            viewModel_mouad.vider_tout_mouad();
            Toast.makeText(this, "Base de données vidée par Mouad", Toast.LENGTH_SHORT).show();
        });

        adapter_mouad.setOnLongClickListener_mouad(note_mouad -> {
            viewModel_mouad.supprimer_mouad(note_mouad);
            Toast.makeText(this, "Note supprimée", Toast.LENGTH_SHORT).show();
        });
    }

    private void sauvegarder_mouad() {
        String t_mouad = etTitre_mouad.getText().toString().trim();
        String d_mouad = etDesc_mouad.getText().toString().trim();

        if (t_mouad.isEmpty() || d_mouad.isEmpty()) {
            Toast.makeText(this, "Veuillez remplir les champs - Mouad", Toast.LENGTH_SHORT).show();
            return;
        }

        Note_mouad n_mouad = new Note_mouad(t_mouad, d_mouad);
        viewModel_mouad.ajouter_mouad(n_mouad);

        etTitre_mouad.setText("");
        etDesc_mouad.setText("");
        Toast.makeText(this, "Note sauvegardée avec succès", Toast.LENGTH_SHORT).show();
    }
}
