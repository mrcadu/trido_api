package com.staxrt.tutorial.trido_api.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="tarefa")
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="equilibrio_id")
    private Equilibrio equilibrio;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="triade_id")
    private Triade triade;

    @ManyToOne()
    @JoinColumn(name="status_tarefa_id")
    private StatusTarefa statusTarefa;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name="tarefa_metas",
                joinColumns={ @JoinColumn(name="tarefa_id", referencedColumnName="id") },
                inverseJoinColumns={ @JoinColumn(name="meta_id", referencedColumnName="id") })
    private List<Meta> metas;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name="tarefa_papeis",
            joinColumns={ @JoinColumn(name="tarefa_id", referencedColumnName="id") },
            inverseJoinColumns={ @JoinColumn(name="papel_id", referencedColumnName="id") })
    private List<Papel> papeis;

    @Column
    private String nome;

    @Column
    private Date duracao;

    @Column
    private Date data;

    @Column(name="created_at")
    private Date createdAt;

    @Column(name="updated_at")
    private Date updatedAt;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Equilibrio getEquilibrio() {
        return equilibrio;
    }

    public void setEquilibrio(Equilibrio equilibrio) {
        this.equilibrio = equilibrio;
    }

    public Triade getTriade() {
        return triade;
    }

    public void setTriade(Triade triade) {
        this.triade = triade;
    }

    public StatusTarefa getStatusTarefa() {
        return statusTarefa;
    }

    public void setStatusTarefa(StatusTarefa statusTarefa) {
        this.statusTarefa = statusTarefa;
    }

    public List<Meta> getMetas() {
        return metas;
    }

    public void setMetas(List<Meta> metas) {
        this.metas = metas;
    }

    public List<Papel> getPapeis() {
        return papeis;
    }

    public void setPapeis(List<Papel> papeis) {
        this.papeis = papeis;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDuracao() {
        return duracao;
    }

    public void setDuracao(Date duracao) {
        this.duracao = duracao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

}
