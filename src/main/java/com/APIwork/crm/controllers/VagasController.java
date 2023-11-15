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

import com.APIwork.crm.dao.VagasFakeDao;
import com.APIwork.crm.dao.CandidatoFakeDao;
import com.APIwork.crm.model.Candidato;
import com.APIwork.crm.model.Vagas;

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
	
	@PostMapping("/create")
	public ResponseEntity create(@RequestBody Vagas newVagas) 
	{
		Map returnData = new HashMap<String, Object>();
        returnData.put("data", vagasFakeDao.save(newVagas));
        return new ResponseEntity(returnData, HttpStatus.CREATED);
	}
	
	@PatchMapping("/update")
	public ResponseEntity update(@RequestBody Vagas newVagas)
	{
		Map returnData = new HashMap<String, Object>(); 
		
		if(!hasId(newVagas))
        {
            returnData.put("message", "Id cannot be null");
            return new ResponseEntity(returnData, HttpStatus.PRECONDITION_FAILED);
        }
        returnData.put("data", vagasFakeDao.save(newVagas));
        return new ResponseEntity(returnData, HttpStatus.OK);
    }
	
	@DeleteMapping("/delete")
	public ResponseEntity<Map<String, Object>> delete(@RequestBody Vagas deleteVaga) {
        Map<String, Object> returnData = new HashMap<>();
        if (!hasId(deleteVaga)) {
            returnData.put("message", "Id cannot be null");
            return new ResponseEntity<>(returnData, HttpStatus.PRECONDITION_FAILED);
        }
        Optional<Vagas> vagasOptional = vagasFakeDao.findById((Long) deleteVaga.getVagasId());
        if (!vagasOptional.isPresent()) {
            returnData.put("message", "Candidato not found");
            return new ResponseEntity<>(returnData, HttpStatus.NOT_FOUND);
        }
        Vagas vagasToDelete = vagasOptional.get();
        vagasFakeDao.delete(vagasToDelete);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
	
	public static Boolean hasId(Vagas vagasToVerify)	
    {
        if(vagasToVerify.getVagasId() != null) {
            return true;
        }
        return false;
    }
}
