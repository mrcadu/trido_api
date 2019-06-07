package com.staxrt.tutorial.trido_api.repository;

import com.staxrt.tutorial.trido_api.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    @Query(value = "SELECT t FROM Tarefa t " +
            "join t.statusTarefa st" +
            " WHERE st.codigo = 'ATV' order by t.data desc ")
    Collection<Tarefa> findAllTarefasAtivas();
}
