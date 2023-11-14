package com.APIwork.crm.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.APIwork.crm.dao.VagasFakeDao;
import com.APIwork.crm.dao.CandidatoFakeDao;



@Controller
@RequestMapping("/vagas")

public class VagasController {

	@Autowired
	private CandidatoFakeDao candidatoFakeDao;
	
	@Autowired
	private VagasFakeDao vagasFakeDao;
	
	
	
	@GetMapping("/listar")
	public ResponseEntity listAll() 
	{
		Map returnData = new HashMap<String, Object >(); 
		returnData.put("Data", vagasFakeDao.findAll());
		return new ResponseEntity(returnData, HttpStatus.OK); 
	}
	
	
}
