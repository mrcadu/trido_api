package com.staxrt.tutorial.trido_api.repository;

import com.staxrt.tutorial.trido_api.model.Papel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PapelRepository extends JpaRepository<Papel, Long> {}
