package com.staxrt.tutorial.trido_api.repository;

import com.staxrt.tutorial.trido_api.model.Triade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TriadeRepository extends JpaRepository<Triade, Long> {}
