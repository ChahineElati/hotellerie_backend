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
import com.chahine_hotellerie_backend.model.Service;
import com.chahine_hotellerie_backend.repository.ClientRepo;
import com.chahine_hotellerie_backend.repository.ServiceRepo;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("api/services/")
public class ServiceController {
	
	@Autowired
	private ServiceRepo serviceRepo;
	@Autowired
	private ClientRepo clientRepo;
	
	@GetMapping
	public List<Service> getServices() {
		return serviceRepo.findAll();
	}
	
	@GetMapping("{id}")
	public Service getServiceById(@PathVariable int id) {
		return serviceRepo.findByIdSrv(id);
	}
	
	@PostMapping
	public Service addService(@RequestBody Service service) {
		return serviceRepo.save(service);
	}
	
	@PutMapping("{id}")
	public Service updateService(@RequestBody Service service, @PathVariable int id) {
		serviceRepo.deleteById(id);
		return serviceRepo.save(service);
	}
	
	@PutMapping("{id}/clients")
	public Service effectuerService(@PathVariable int id, @RequestBody Client client) {
		Service service = serviceRepo.findByIdSrv(id);
		service.getClients().add(client);
		Client clt = clientRepo.findByIdClt(client.getId_clt());
		clt.getServices().add(service);
		clientRepo.save(clt);
		return serviceRepo.save(service);
	}
	
	@DeleteMapping("{id}")
	public void deleteService(@PathVariable int id) {
		Service srv = serviceRepo.findByIdSrv(id);
		srv.getClients().forEach(clt -> {
			clt = clientRepo.findByIdClt(clt.getId_clt());
			clt.getServices().remove(srv);
			clientRepo.save(clt);
		});
		srv.getClients().clear();
		serviceRepo.delete(srv);
	}
}