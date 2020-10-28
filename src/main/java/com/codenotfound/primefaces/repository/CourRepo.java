package com.codenotfound.primefaces.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codenotfound.primefaces.model.Cour;

@Repository
public interface CourRepo  extends JpaRepository<Cour, String> {

}
