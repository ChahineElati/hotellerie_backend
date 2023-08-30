package com.chahine_hotellerie_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chahine_hotellerie_backend.model.Admin;

public interface AdminRepo extends JpaRepository<Admin, Integer> {

	public Admin findByEmailContaining(String nom);
}
