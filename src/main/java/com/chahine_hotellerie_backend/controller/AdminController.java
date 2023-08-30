package com.chahine_hotellerie_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chahine_hotellerie_backend.model.Admin;
import com.chahine_hotellerie_backend.repository.AdminRepo;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("api/admins")
public class AdminController {
	
	@Autowired
	private AdminRepo adminRepo;

	@GetMapping("{email}")
	public Admin getAdminContainingEmail(@PathVariable String email) {
		return adminRepo.findByEmailContaining(email);
	}
}
