package com.APIwork.crm.model;



import org.hibernate.annotations.Columns;

import jakarta.persistence.Column;
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
    @Column(nullable = false)
    private String ID; 
    @Column(nullable = false)
    private int CPF; 
    @Column(nullable= false)
    
    
    
    
    


    
    
	
	
	
}
