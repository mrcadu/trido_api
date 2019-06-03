package com.staxrt.tutorial.trido_api.model;

import javax.persistence.*;

@Entity
@Table(name = "triade")
public class Triade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private boolean importante;

    @Column
    private boolean urgente;

    @Column
    private boolean circunstancial;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isImportante() {
        return importante;
    }

    public void setImportante(boolean importante) {
        this.importante = importante;
    }

    public boolean isUrgente() {
        return urgente;
    }

    public void setUrgente(boolean urgente) {
        this.urgente = urgente;
    }

    public boolean isCircunstancial() {
        return circunstancial;
    }

    public void setCircunstancial(boolean circunstancial) {
        this.circunstancial = circunstancial;
    }
}
