package com.chahine_hotellerie_backend.model;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name="chambres")
public class Chambre {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idChmb;
	private String type_chmb;
	private float prix_par_jr;
	@Temporal(TemporalType.DATE)
	private Date dt_lct;
	private int nb_jours;
	private String num;
	@ManyToOne()
	@JoinColumn(name = "id_clt")
	private Client client;
	
	public Chambre() {
		super();
	}
	public Chambre(String type_chmb, float prix_par_jr, Date dt_lct, int nb_jours, String num) {
		super();
		this.type_chmb = type_chmb;
		this.prix_par_jr = prix_par_jr;
		this.dt_lct = dt_lct;
		this.nb_jours = nb_jours;
		this.num = num;
	}


	public int getId_chmb() {
		return idChmb;
	}
	public void setId_chmb(int id_chmb) {
		this.idChmb = id_chmb;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public String getType_chmb() {
		return type_chmb;
	}
	public void setType_chmb(String type_chmb) {
		this.type_chmb = type_chmb;
	}
	public float getPrix_par_jr() {
		return prix_par_jr;
	}
	public void setPrix_par_jr(float prix_par_jr) {
		this.prix_par_jr = prix_par_jr;
	}
	public Date getDt_lct() {
		return dt_lct;
	}
	public void setDt_lct(Date dt_lct) {
		this.dt_lct = dt_lct;
	}
	public int getNb_jours() {
		return nb_jours;
	}
	public void setNb_jours(int nb_jours) {
		this.nb_jours = nb_jours;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	
}
