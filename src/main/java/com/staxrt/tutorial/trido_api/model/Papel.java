package com.staxrt.tutorial.trido_api.model;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="papel")
public class Papel {
    @Id
    private long id;

    @Column
    private String nome;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
