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
@Table(name="Vagas")
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

    @Column
    @OneToMany(mappedBy = "parentVagas")
    private List<Candidato> c1 = new ArrayList<Candidato>(); 
    
    
    public void addCand(Candidato newCand) {
    	this.c1.add(newCand); 
    }
    
    public void removeCand(Candidato candToRemove) {
        for(int i = 0; i < c1.size(); i++) {
           
        	Candidato existentC1 = c1.get(i); 

            if(candToRemove.getCandId() == existentC1.getCandId()) {    
                c1.remove(i);
            }
        }
    }

	public Object getVagasId() {
		return id;
	}

	public void setVagasId(Long id) {
		this.id = id;
	}
 
}
	

