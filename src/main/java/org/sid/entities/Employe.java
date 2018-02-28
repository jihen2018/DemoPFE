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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;


@Entity
@Table(name="employe")
public class Employe implements Serializable {
	

	@Id @GeneratedValue
	private Long id;
	@Column(name="username")
	private String username;
	@Column(name="password")
	private String password;
	@Column(name="nom_employe")
	private String nomEmploye;
	@Column(name="prenom_employe")
	private String PrenomEmploye;
	@Column(name="addresse")
	private String addresse;
	@Column(name="telephone")
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
		return nomEmploye;
	}




	public void setNomEmploye(String nomEmploye) {
		this.nomEmploye = nomEmploye;
	}




	public String getPrenomEmploye() {
		return PrenomEmploye;
	}




	public void setPrenomEmploye(String prenomEmploye) {
		PrenomEmploye = prenomEmploye;
	}




	public String getAddresse() {
		return addresse;
	}




	public void setAddresse(String addresse) {
		this.addresse = addresse;
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
		Equipe = equipe;
	}




	public Collection<AppRole> getRoles() {
		return roles;
	}




	public void setRoles(Collection<AppRole> roles) {
		this.roles = roles;
	}




	public Employe(Long id, String username, String password, String nomEmploye, String prenomEmploye, String addresse,
			String telephone, org.sid.entities.Equipe equipe, Collection<AppRole> roles) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.nomEmploye = nomEmploye;
		PrenomEmploye = prenomEmploye;
		this.addresse = addresse;
		this.telephone = telephone;
		Equipe = equipe;
		this.roles = roles;
	}




	public Employe() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	
	
	
	
	

}
