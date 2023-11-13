package com.APIwork.crm.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Columns;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity 

public class Vagas {	
	private long id; 
	@Column(nullable = false)
	
	private String name;
	@OneToMany(mappedBy = "parentProject")
	private List<Candidato> c1 = new ArrayList<Candidato>();
	
	public void addCandidato(Candidato newCandidato) {
		this.c1.add(newCandidato);
	}
	
//	public void removeCandidato(Candidato removeCandidato) {
		//for(int i = 0 ; i<c1.size(); i++) {
			//Candidato existingCandidato = c1.get(i);
			//if (removeCandidato.getid() == existingCandidato.getId());
		//}
	//}
}
