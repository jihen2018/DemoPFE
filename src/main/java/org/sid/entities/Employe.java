package org.sid.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;


@Entity
public class Employe implements Serializable {
	

	@Id @GeneratedValue
	private Long id;
	@Column(unique=true)
	private String username;
	private String password;
	private String NomEmploye;
	private String PrenomEmploye;
	private String Addresse;
	private String telephone;
	
	@ManyToOne
	@JoinColumn(name="Employe_Equipe_id")
	private Equipe   Equipe;
	
	@ManyToMany(fetch=FetchType.EAGER)
	private Collection<AppRole> roles= new ArrayList<>();

	
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getNomEmploye() {
		return NomEmploye;
	}



	public void setNomEmploye(String nomEmploye) {
		NomEmploye = nomEmploye;
	}



	public String getPrenomEmploye() {
		return PrenomEmploye;
	}



	public void setPrenomEmploye(String prenomEmploye) {
		PrenomEmploye = prenomEmploye;
	}



	public String getAddresse() {
		return Addresse;
	}



	public void setAddresse(String addresse) {
		Addresse = addresse;
	}



	public String getTelephone() {
		return telephone;
	}



	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}



	public Equipe getEquipe() {
		return Equipe;
	}



	public void setEquipe(Equipe equipe) {
		this.Equipe = equipe;
	}



	public Collection<AppRole> getRoles() {
		return roles;
	}



	public void setRoles(Collection<AppRole> roles) {
		this.roles = roles;
	}



	public Employe(Long id, String username, String password, String nomEmploye, String prenomEmploye, String addresse,
			String telephone,Equipe Equipe,  Collection<AppRole> roles) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		NomEmploye = nomEmploye;
		PrenomEmploye = prenomEmploye;
		Addresse = addresse;
		this.telephone = telephone;
		this.Equipe = Equipe;
		this.roles = roles;
	}



	public Employe() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	
	
	
	
	

}
