package com.chahine_hotellerie_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chahine_hotellerie_backend.model.Client;
import com.chahine_hotellerie_backend.model.Evenement;
import com.chahine_hotellerie_backend.repository.ClientRepo;
import com.chahine_hotellerie_backend.repository.EvenementRepo;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("api/evenements/")
public class EvenementController {
	
	@Autowired
	private EvenementRepo evenementRepo;
	@Autowired
	private ClientRepo clientRepo;
	
	@GetMapping
	public List<Evenement> getEvenements() {
		return evenementRepo.findAll();
	}
	
	@GetMapping("{id}")
	public Evenement getEvenement(@PathVariable int id) {
		return evenementRepo.findByIdEvt(id);
	}

	@PostMapping
	public Evenement addEvenement(@RequestBody Evenement evenement) {
		return evenementRepo.save(evenement);
	}
	
	@PutMapping("{id}")
	public Evenement updateEvenement(@RequestBody Evenement evenement, @PathVariable int id) {
		Evenement evt = evenementRepo.findByIdEvt(id);
		evt.setEtat(evenement.isEtat());
		return evenementRepo.save(evt);
	}
	
	@PutMapping("{id}/clients")
	public Evenement updateEvenementClt(@RequestBody List<Client> lst_clt, @PathVariable int id) {
		Evenement evt = evenementRepo.findByIdEvt(id);
		evt.getClients().addAll(lst_clt);
		evt.setEtat(evt.isEtat());
		lst_clt.forEach(clt -> {
			Client aux_clt = clientRepo.findByIdClt(clt.getId_clt());
			aux_clt.setEvt(evt);
		});
		return evenementRepo.save(evt);
	}
}
