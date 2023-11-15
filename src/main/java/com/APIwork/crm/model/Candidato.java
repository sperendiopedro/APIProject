package com.APIwork.crm.model;



import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Columns;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;




@Data
@Entity
@Table(name="Candidatos")
public class Candidato {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private long id;
    
	@Column(nullable = false)
    public String nmCand; 
    
	@Column(nullable = false)
    private int CPF; 
    
    @Column(nullable= false)
    private String resCand; 
    
    @JsonIgnore
	@ManyToOne
	@JoinColumn(name = "parentVagas_id", referencedColumnName = "id")
	private Vagas parentVagas;

	
    public Object getCandId() {
		return id;
	}

	public void setCandId(long id) {
		this.id = id;
	}

	public String getNmCand() {
		return nmCand;
	}

	public void setNmCand(String nmCand) {
		this.nmCand = nmCand;
	}

	public int getCPF() {
		return CPF;
	}

	public void setCPF(int cPF) {
		CPF = cPF;
	}

	public String getResCand() {
		return resCand;
	}

	public void setResCand(String resCand) {
		this.resCand = resCand;
	}

	public Vagas getParentVagas() {
		return parentVagas;
	}

	public void setParentVagas(Vagas parentVagas) {
		this.parentVagas = parentVagas;
	} 


}
