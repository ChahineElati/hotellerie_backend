package com.chahine_hotellerie_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chahine_hotellerie_backend.model.Service;

public interface ServiceRepo extends JpaRepository<Service, Integer> {
	
	public Service findByIdSrv(int id);

}
