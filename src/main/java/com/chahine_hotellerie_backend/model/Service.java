package com.chahine_hotellerie_backend.model;

import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name="services")
public class Service {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idSrv;
	private String label;
	private float prix;
	private String categorie;
	@ManyToMany(mappedBy = "services")
	Set<Client> clients;
	
	public Service() {
		super();
	}
	public Service(String label, float prix, String categorie) {
		super();
		this.label = label;
		this.prix = prix;
		this.categorie = categorie;
	}


	public int getId_srv() {
		return idSrv;
	}
	public void setId_srv(int id_srv) {
		this.idSrv = id_srv;
	}
	public Set<Client> getClients() {
		return clients;
	}
	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	
}
