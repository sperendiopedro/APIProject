package com.APIwork.crm.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.APIwork.crm.model.Vagas; 

@Repository
public interface VagasFakeDao extends JpaRepository<Vagas, Long>  {

}
