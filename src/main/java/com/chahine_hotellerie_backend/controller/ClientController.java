package com.chahine_hotellerie_backend.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chahine_hotellerie_backend.model.Client;
import com.chahine_hotellerie_backend.model.Evenement;
import com.chahine_hotellerie_backend.model.Repas;
import com.chahine_hotellerie_backend.model.Service;
import com.chahine_hotellerie_backend.repository.ClientRepo;
import com.chahine_hotellerie_backend.repository.EvenementRepo;
import com.chahine_hotellerie_backend.repository.RepasRepo;
import com.chahine_hotellerie_backend.repository.ServiceRepo;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("api/clients/")
public class ClientController {
	
	@Autowired
	private ClientRepo clientRepo;
	@Autowired
	private RepasRepo repasRepo;
	@Autowired
	private ServiceRepo serviceRepo;
	@Autowired
	private EvenementRepo evenementRepo;
	
	@GetMapping("{id}")
	public Client getClient(@PathVariable int id) {
		return clientRepo.findByIdClt(id);
	}
	
	@GetMapping
	public List<Client> getClients() {
		return clientRepo.findAll();
	}
	
	@GetMapping("/evenement/{id}")
	public List<Client> getClientsByEvt(@PathVariable int id) {
		return clientRepo.findByEvtIdEvt(id);
	}
	@PostMapping
	public Client addClient(@RequestBody Client client) {
		return clientRepo.save(client);
	}

	@PostMapping("/evenement/{id}")
	public Client addInvite(@RequestBody Client invt, @PathVariable int id) {
		Evenement evt = evenementRepo.findByIdEvt(id);
		evt.getClients().add(invt);
		invt.setInvt(true);
		invt.setEvt(evt);
		evenementRepo.save(evt);
		return clientRepo.save(invt);
	}
	
	@GetMapping("repas/{id}")
	public Set<Client> getClients(@PathVariable int id) {
		Repas repas = repasRepo.findByIdRep(id);
		return repas.getClients();
	}
	
	@GetMapping("services/{id}")
	public Set<Client> getServices(@PathVariable int id) {
		Service srv = serviceRepo.findByIdSrv(id);
		return srv.getClients();
	}
}
