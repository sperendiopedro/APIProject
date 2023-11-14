package com.APIwork.crm.model;



import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Columns;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;




@Data
@Entity
@Table(name="vagas")
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
    
    @Column
    @OneToMany(mappedBy = "parentCandidato")
    private List<Vagas> v1 = new ArrayList<Vagas>(); 
    
    
    public void addCand(Vagas newCand) {
    	this.v1.add(newCand); 
    }
    
    public void removeCand(Candidato candToRemove) {
        for(int i = 0; i < v1.size(); i++) {
           
        	Vagas existentv1 = v1.get(i); 

            if(candToRemove.getId() == existentv1.getId()) {    
                v1.remove(i);
            }
        }
    }

	public Long getId() {
		return id; 
	}

	public Vagas[] getVagas() {
		// TODO Auto-generated method stub
		return null;
	}
}
