package com.codenotfound.primefaces.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codenotfound.primefaces.model.Matiere;

@Repository
public interface MatiereRepo  extends JpaRepository<Matiere, String> {

}
