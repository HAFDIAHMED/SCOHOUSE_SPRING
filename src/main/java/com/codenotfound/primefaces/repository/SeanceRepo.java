package com.codenotfound.primefaces.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codenotfound.primefaces.model.Seance;

@Repository
public interface SeanceRepo  extends JpaRepository<Seance, String> {

}
