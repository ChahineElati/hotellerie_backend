package com.chahine_hotellerie_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chahine_hotellerie_backend.model.Chambre;

public interface ChambreRepo extends JpaRepository<Chambre, Integer> {
	
	public Chambre findByIdChmb(int id);
	public List<Chambre> findByNumContaining(String nom);
}
