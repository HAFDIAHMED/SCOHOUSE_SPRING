package com.codenotfound.primefaces.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codenotfound.primefaces.model.NiveauScolaire;

@Repository
public interface NiveauScolaireRepo  extends JpaRepository<NiveauScolaire, String> {

}
