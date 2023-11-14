package com.APIwork.crm.model;

import org.hibernate.annotations.Columns;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity 
@Table(name="vagas")
public class Vagas {	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nmVaga;
	
	@Column(nullable = false)
	private String desc; 
	
	@Column
	private String assignTo; 
	
	@Column
	private long candID;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "parentCandidato_id", referencedColumnName = "id")
	private Candidato parentCandidato; 
		
	public Long getId() {
		return id; 
	}
}
	

