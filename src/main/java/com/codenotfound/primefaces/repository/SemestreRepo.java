package com.codenotfound.primefaces.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codenotfound.primefaces.model.Semestre;

@Repository
public interface SemestreRepo  extends JpaRepository<Semestre, String> {

}
