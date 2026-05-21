package com.example.lab19.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab19.R;
import com.example.lab19.data.local.Note_mouad;

import java.util.ArrayList;
import java.util.List;

/**
 * Adapter unique pour l'affichage des notes.
 * Signé : CHARRAJ Mouad aka ZERO-XR7
 */
public class NoteAdapter_mouad extends RecyclerView.Adapter<NoteAdapter_mouad.NoteHolder_mouad> {

    private List<Note_mouad> notes_mouad_liste = new ArrayList<>();
    private OnLongClickListener_mouad long_click_mouad;

    public interface OnLongClickListener_mouad {
        void onNoteLongClick(Note_mouad note_mouad);
    }

    public void setNotes_mouad(List<Note_mouad> nouvelles_notes_mouad) {
        this.notes_mouad_liste = nouvelles_notes_mouad;
        notifyDataSetChanged();
    }

    public void setOnLongClickListener_mouad(OnLongClickListener_mouad listener_mouad) {
        this.long_click_mouad = listener_mouad;
    }

    @NonNull
    @Override
    public NoteHolder_mouad onCreateViewHolder(@NonNull ViewGroup parent_mouad, int type_mouad) {
        View v_mouad = LayoutInflater.from(parent_mouad.getContext())
                .inflate(R.layout.note_item_mouad, parent_mouad, false);
        return new NoteHolder_mouad(v_mouad);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteHolder_mouad holder_mouad, int pos_mouad) {
        Note_mouad note_actuelle_mouad = notes_mouad_liste.get(pos_mouad);
        holder_mouad.tvTitre_mouad.setText(note_actuelle_mouad.getTitre_mouad());
        holder_mouad.tvDesc_mouad.setText(note_actuelle_mouad.getDescription_mouad());
    }

    @Override
    public int getItemCount() {
        return notes_mouad_liste.size();
    }

    class NoteHolder_mouad extends RecyclerView.ViewHolder {
        private final TextView tvTitre_mouad;
        private final TextView tvDesc_mouad;

        public NoteHolder_mouad(@NonNull View item_mouad) {
            super(item_mouad);
            tvTitre_mouad = item_mouad.findViewById(R.id.tvTitle_mouad);
            tvDesc_mouad = item_mouad.findViewById(R.id.tvDescription_mouad);

            item_mouad.setOnLongClickListener(v -> {
                int p_mouad = getAdapterPosition();
                if (long_click_mouad != null && p_mouad != RecyclerView.NO_POSITION) {
                    long_click_mouad.onNoteLongClick(notes_mouad_liste.get(p_mouad));
                    return true;
                }
                return false;
            });
        }
    }
}
