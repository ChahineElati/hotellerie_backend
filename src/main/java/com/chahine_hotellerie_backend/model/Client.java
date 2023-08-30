package com.chahine_hotellerie_backend.model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name="clients")
public class Client {

@Id
@GeneratedValue(strategy= GenerationType.AUTO)
private int idClt;

private String nom_clt;
private String num_tel;
private boolean invt;

@JsonIgnore
@OneToMany(mappedBy = "client")
private Set<Chambre> chambres = new HashSet<>();

@JsonIgnore
@ManyToMany
@JoinTable(
		name = "client_service",
		joinColumns = @JoinColumn(name = "id_clt"),
		inverseJoinColumns = @JoinColumn(name = "id_srv")
		)
private Set<Service> services = new HashSet<>();

@JsonIgnore
@ManyToMany
@JoinTable(
		name = "client_repas",
		joinColumns = @JoinColumn(name = "id_clt"),
		inverseJoinColumns = @JoinColumn(name = "id_rep")
		)
private Set<Repas> repas = new HashSet<>();


@JsonIgnore
@ManyToOne
@JoinColumn(name = "id_evt")
private Evenement evt;

public Evenement getEvt() {
	return evt;
}
public void setEvt(Evenement evt) {
	this.evt = evt;
}
public Client() {
	super();
}
public Client(String nom_clt, String num_tel) {
	super();
	this.nom_clt = nom_clt;
	this.num_tel = num_tel;
}


public Set<Chambre> getChambres() {
	return chambres;
}
public void setChambres(Set<Chambre> chambres) {
	this.chambres = chambres;
}
public Set<Service> getServices() {
	return services;
}
public void setServices(Set<Service> services) {
	this.services = services;
}
public Set<Repas> getRepas() {
	return repas;
}
public void setRepas(Set<Repas> repas) {
	this.repas = repas;
}
public int getId_clt() {
	return idClt;
}
public void setId_clt(int id_clt) {
	this.idClt = id_clt;
}
public String getNom_clt() {
	return nom_clt;
}
public void setNom_clt(String nom_clt) {
	this.nom_clt = nom_clt;
}
public String getNum_tel() {
	return num_tel;
}
public void setNum_tel(String num_tel) {
	this.num_tel = num_tel;
}
public boolean isInvt() {
	return invt;
}
public void setInvt(boolean invt) {
	this.invt = invt;
}


}
