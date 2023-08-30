package com.chahine_hotellerie_backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "admins")
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_adm;
	private String nom;
	private String email;
	private String motDePasse;
	
	Admin() {
		
	}

	public Admin(String nom, String email, String motDePasse) {
		super();
		this.nom = nom;
		this.email = email;
		this.motDePasse = motDePasse;
	}

	public int getId() {
		return id_adm;
	}

	public void setId(int id) {
		this.id_adm = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	
}
