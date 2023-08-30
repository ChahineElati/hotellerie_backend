package com.chahine_hotellerie_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chahine_hotellerie_backend.model.Client;
import com.chahine_hotellerie_backend.model.Repas;
import com.chahine_hotellerie_backend.repository.ClientRepo;
import com.chahine_hotellerie_backend.repository.RepasRepo;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("api/repas/")
public class RepasController {
	
	@Autowired
	private RepasRepo repasRepos;
	@Autowired ClientRepo clientRepo;
	
	@GetMapping
	public List<Repas> getRepas() {
		return repasRepos.findAll();
	}
	
	@GetMapping("{id}")
	public Repas getRepasById(@PathVariable int id) {
		return repasRepos.findByIdRep(id);
	}
	
	@PostMapping
	public Repas addRepas(@RequestBody Repas repas) {
		return repasRepos.save(repas); 
	}
	
	@PutMapping("{id}")
	public Repas updateRepas(@RequestBody Repas repas, @PathVariable int id) {
		repasRepos.deleteById(id);
		return repasRepos.save(repas);
	}
	
	@DeleteMapping("{id}")
	public void deleteRepas(@PathVariable int id) {
		Repas rep = repasRepos.findByIdRep(id);
		rep.getClients().forEach(clt -> {
			clt = clientRepo.findByIdClt(clt.getId_clt());
			clt.getRepas().remove(rep);
			clientRepo.save(clt);
		});
		rep.getClients().clear();
		repasRepos.delete(rep);
	}

	@PutMapping("{id}/clients")
	public Repas effectuerRepas(@PathVariable int id, @RequestBody Client client) {
		Repas repas = repasRepos.findByIdRep(id);
		repas.getClients().add(client);
		Client clt = clientRepo.findByIdClt(client.getId_clt());
		clt.getRepas().add(repas);
		clientRepo.save(clt);
		return repasRepos.save(repas);
	}
}
