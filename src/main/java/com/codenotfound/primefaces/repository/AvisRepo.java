package com.codenotfound.primefaces.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codenotfound.primefaces.model.Avis;

@Repository
public interface AvisRepo  extends JpaRepository<Avis, String> {

}
