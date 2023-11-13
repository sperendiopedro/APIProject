package com.APIwork.crm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.APIwork.crm.model.Candidato;

@Repository
public interface CandidatoFakeDao extends JpaRepository<Candidato, Long> {
	

}
