package com.staxrt.tutorial.trido_api.repository;

import com.staxrt.tutorial.trido_api.model.StatusTarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StatusTarefaRepository extends JpaRepository<StatusTarefa, Long> {}
