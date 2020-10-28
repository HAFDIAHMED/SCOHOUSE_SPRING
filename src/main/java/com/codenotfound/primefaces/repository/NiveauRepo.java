package com.codenotfound.primefaces.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codenotfound.primefaces.model.Niveau;

@Repository
public interface NiveauRepo  extends JpaRepository<Niveau, String> {

}
