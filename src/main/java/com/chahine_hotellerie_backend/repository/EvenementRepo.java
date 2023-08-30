package com.chahine_hotellerie_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chahine_hotellerie_backend.model.Evenement;

public interface EvenementRepo extends JpaRepository<Evenement, Integer> {
	
	public Evenement findByIdEvt(int id);

}
