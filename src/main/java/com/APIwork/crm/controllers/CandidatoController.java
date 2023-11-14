package com.APIwork.crm.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.APIwork.crm.dao.CandidatoFakeDao;
import com.APIwork.crm.dao.VagasFakeDao;
import com.APIwork.crm.model.Candidato;
import com.APIwork.crm.model.Vagas;

@Controller
@RequestMapping("/candidato")
public class CandidatoController {
	
	@Autowired
	private VagasFakeDao vagasFakeDao;
	
	@Autowired 
	private CandidatoFakeDao candidatoFakeDao; 
	
	
	@GetMapping("/listar")
	public ResponseEntity listAll() 
	{
		Map returnData = new HashMap<String, Object>();
		returnData.put("data", candidatoFakeDao.findAll());
		return new ResponseEntity(returnData, HttpStatus.OK); 
	}
	
	@PostMapping("/create")
	public ResponseEntity create(@RequestBody Candidato newCandidato) 
	{
		Map returnData = new HashMap<String, Object>();
        returnData.put("data", candidatoFakeDao.save(newCandidato));
        return new ResponseEntity(returnData, HttpStatus.CREATED);
	}
	
	@PatchMapping("/update")
	public ResponseEntity update(@RequestBody Candidato newCandidato) 
	{
		Map returnData = new HashMap<String, Object>(); 
		
		if(!hasId(newCandidato))
        {
            returnData.put("message", "Id cannot be null");
            return new ResponseEntity(returnData, HttpStatus.PRECONDITION_FAILED);
        }
        returnData.put("data", candidatoFakeDao.save(newCandidato));
        return new ResponseEntity(returnData, HttpStatus.OK);
    }
	
	@DeleteMapping("/delete")
	public ResponseEntity<Map<String, Object>> delete(@RequestBody Candidato deleteCand) {
        Map<String, Object> returnData = new HashMap<>();
        if (!hasId(deleteCand)) {
            returnData.put("message", "Id cannot be null");
            return new ResponseEntity<>(returnData, HttpStatus.PRECONDITION_FAILED);
        }
        Optional<Candidato> candidatoOptional = candidatoFakeDao.findById(deleteCand.getId());
        if (!candidatoOptional.isPresent()) {
            returnData.put("message", "Candidato not found");
            return new ResponseEntity<>(returnData, HttpStatus.NOT_FOUND);
        }
        Candidato candidatoToDelete = candidatoOptional.get();
        for (Vagas vagasToDelete : candidatoToDelete.getVagas()) {
            vagasFakeDao.delete(vagasToDelete);
        }
        candidatoFakeDao.delete(candidatoToDelete);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
	
	public static Boolean hasId(Candidato taskToVerify)
    	
    {
        if(taskToVerify.getId() != null) {
            return true;
        }
        return false;
    }


}
