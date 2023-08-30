package com.chahine_hotellerie_backend.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name="evenements")
public class Evenement {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idEvt;
	
	private String nom_evt;
	@Temporal(TemporalType.DATE)
	private Date dt_debut;
	@Temporal(TemporalType.DATE)
	private Date dt_fin;
	private String type_evt;
	private boolean etat;
	@JsonIgnore
	@OneToMany(mappedBy = "evt")
	Set<Client> clients = new HashSet<Client>();
	
	public Set<Client> getClients() {
		return clients;
	}
	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}
	public Evenement() {
		super();
	}
	public Evenement(String nom_evt, Date dt_debut, Date dt_fin, String type_evt, boolean etat) {
		super();
		this.nom_evt = nom_evt;
		this.dt_debut = dt_debut;
		this.dt_fin = dt_fin;
		this.type_evt = type_evt;
		this.etat = etat;
	}


	public int getId_evt() {
		return idEvt;
	}
	public void setId_evt(int id_evt) {
		this.idEvt = id_evt;
	}
	public String getNom_evt() {
		return nom_evt;
	}
	public void setNom_evt(String nom_evt) {
		this.nom_evt = nom_evt;
	}
	public Date getDt_debut() {
		return dt_debut;
	}
	public void setDt_debut(Date dt_debut) {
		this.dt_debut = dt_debut;
	}
	public Date getDt_fin() {
		return dt_fin;
	}
	public void setDt_fin(Date dt_fin) {
		this.dt_fin = dt_fin;
	}
	public String getType_evt() {
		return type_evt;
	}
	public void setType_evt(String type_evt) {
		this.type_evt = type_evt;
	}
	public boolean isEtat() {
		return etat;
	}
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
}
