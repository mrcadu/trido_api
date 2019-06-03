package com.staxrt.tutorial.trido_api.model;

import javax.persistence.*;

@Entity
@Table(name = "equilibrio")
public class Equilibrio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private boolean mental;

    @Column
    private boolean fisico;

    @Column
    private boolean espiritual;

    @Column
    private boolean emocional;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isMental() {
        return mental;
    }

    public void setMental(boolean mental) {
        this.mental = mental;
    }

    public boolean isFisico() {
        return fisico;
    }

    public void setFisico(boolean fisico) {
        this.fisico = fisico;
    }

    public boolean isEspiritual() {
        return espiritual;
    }

    public void setEspiritual(boolean espiritual) {
        this.espiritual = espiritual;
    }

    public boolean isEmocional() {
        return emocional;
    }

    public void setEmocional(boolean emocional) {
        this.emocional = emocional;
    }

}
