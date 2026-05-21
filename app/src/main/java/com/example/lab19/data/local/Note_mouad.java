package com.example.lab19.data.local;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Entité Note - Entièrement personnalisée par Mouad.
 * Réalisé par CHARRAJ Mouad aka ZERO-XR7
 */
@Entity(tableName = "table_notes_mouad")
public class Note_mouad {

    @PrimaryKey(autoGenerate = true)
    private int id_mouad;

    private String titre_mouad;
    private String description_mouad;

    public Note_mouad(String titre_mouad, String description_mouad) {
        this.titre_mouad = titre_mouad;
        this.description_mouad = description_mouad;
    }

    public int getId_mouad() {
        return id_mouad;
    }

    public void setId_mouad(int id_mouad) {
        this.id_mouad = id_mouad;
    }

    public String getTitre_mouad() {
        return titre_mouad;
    }

    public void setTitre_mouad(String titre_mouad) {
        this.titre_mouad = titre_mouad;
    }

    public String getDescription_mouad() {
        return description_mouad;
    }

    public void setDescription_mouad(String description_mouad) {
        this.description_mouad = description_mouad;
    }
}
