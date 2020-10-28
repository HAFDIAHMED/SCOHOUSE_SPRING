package com.codenotfound.primefaces.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codenotfound.primefaces.model.Participation;

@Repository
public interface ParticipationRepo  extends JpaRepository<Participation, String> {

}
