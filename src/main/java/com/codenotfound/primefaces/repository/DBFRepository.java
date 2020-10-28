package com.codenotfound.primefaces.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codenotfound.primefaces.model.DBF;

@Repository
public interface DBFRepository extends JpaRepository<DBF, String> {

}
