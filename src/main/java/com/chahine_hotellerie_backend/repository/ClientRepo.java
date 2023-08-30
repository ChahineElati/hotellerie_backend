package com.chahine_hotellerie_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chahine_hotellerie_backend.model.Client;

public interface ClientRepo extends JpaRepository<Client, Integer> {
	
	public Client findTopByOrderByIdCltDesc();
	public Client findByIdClt(int id);
	public List<Client> findByEvtIdEvt(int id);

}
