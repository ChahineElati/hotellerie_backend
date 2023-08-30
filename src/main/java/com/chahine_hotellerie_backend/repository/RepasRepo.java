package com.chahine_hotellerie_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chahine_hotellerie_backend.model.Repas;

public interface RepasRepo extends JpaRepository<Repas, Integer> {
	
	public Repas findByIdRep(int id);

}
