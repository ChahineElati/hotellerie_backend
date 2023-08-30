package com.chahine_hotellerie_backend.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name="repas")
public class Repas {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idRep;
	private String nom_rep;
	private float prix;
	private int tmp_prep;
	private String type_plat;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "repas")
	Set<Client> clients;
	
	public Repas() {
		super();
	}
	public Repas(String nom_rep, float prix, int tmp_prep, String type_plat) {
		super();
		this.nom_rep = nom_rep;
		this.prix = prix;
		this.tmp_prep = tmp_prep;
		this.type_plat = type_plat;
	}


	
	public int getId_rep() {
		return idRep;
	}
	public void setId_rep(int id_rep) {
		this.idRep = id_rep;
	}
	public Set<Client> getClients() {
		return clients;
	}
	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}
	public String getNom_rep() {
		return nom_rep;
	}
	public void setNom_rep(String nom_rep) {
		this.nom_rep = nom_rep;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	public int getTmp_prep() {
		return tmp_prep;
	}
	public void setTmp_prep(int tmp_prep) {
		this.tmp_prep = tmp_prep;
	}
	public String getType_plat() {
		return type_plat;
	}
	public void setType_plat(String type_plat) {
		this.type_plat = type_plat;
	}
	
}
