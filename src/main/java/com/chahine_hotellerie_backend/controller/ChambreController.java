package com.chahine_hotellerie_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chahine_hotellerie_backend.model.Chambre;
import com.chahine_hotellerie_backend.model.Client;
import com.chahine_hotellerie_backend.repository.ChambreRepo;
import com.chahine_hotellerie_backend.repository.ClientRepo;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("api/chambres/")
public class ChambreController {

	@Autowired
	private ChambreRepo chambreRepo;
	@Autowired
	private ClientRepo clientRepo;
	
	@GetMapping
	public List<Chambre> getChambres() {
		return chambreRepo.findAll();
	}
	
	@GetMapping("{nom}")
	public List<Chambre> getChambresContainingNom(@PathVariable String nom) {
		return chambreRepo.findByNumContaining(nom);
	}
	
	@PutMapping("date/{id}")
	public Chambre updateDateLct(@RequestBody Chambre chambre, @PathVariable int id) {
		Chambre aux_cmb = chambreRepo.findByIdChmb(id);
		aux_cmb.setDt_lct(chambre.getDt_lct());
		aux_cmb.setNb_jours(chambre.getNb_jours());
		Client clt = clientRepo.findTopByOrderByIdCltDesc();
		aux_cmb.setClient(clt);
		return chambreRepo.save(aux_cmb);
	}
	
	@PutMapping("{id}")
	public Chambre updatePrixParJr(@RequestBody Chambre chambre, @PathVariable int id) {
		Chambre aux_cmb = chambreRepo.findByIdChmb(id);
		aux_cmb.setNum(chambre.getNum());
		aux_cmb.setType_chmb(chambre.getType_chmb());
		aux_cmb.setPrix_par_jr(chambre.getPrix_par_jr());
		return chambreRepo.save(aux_cmb);
	}
}
