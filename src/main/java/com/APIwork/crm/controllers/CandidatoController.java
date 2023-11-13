package com.APIwork.crm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/candidato")

public class CandidatoController {
	
	@Autowired
	//private CandidatoService candidatoService; 
	
	@GetMapping("/teste")
	public String getAllCandidatos() {
		return ""; 
	}
	
	
	
}
