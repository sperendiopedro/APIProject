package com.APIwork.crm.model;



import org.hibernate.annotations.Columns;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;




@Data
@Entity
public class Candidato {
	
	 
	
	private int idade; 
	private int cpf;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private long id;
	@Columns(nullable=false)
	private String name; 
	
	
	
}
