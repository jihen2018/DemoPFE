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
<<<<<<< HEAD
import javax.persistence.Table;
=======
>>>>>>> d383532bdb8df35f8e5c91aaae3d45b8b2b8f04d

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
	
	@ManyToOne
	@JoinColumn(name="Employe_Equipe_id")
	private Equipe   Equipe;
	
	@ManyToMany(fetch=FetchType.EAGER)
	private Collection<AppRole> roles= new ArrayList<>();

<<<<<<< HEAD



=======
	
	
>>>>>>> d383532bdb8df35f8e5c91aaae3d45b8b2b8f04d
	public Long getId() {
		return id;
	}



<<<<<<< HEAD

=======
>>>>>>> d383532bdb8df35f8e5c91aaae3d45b8b2b8f04d
	public void setId(Long id) {
		this.id = id;
	}



<<<<<<< HEAD

=======
>>>>>>> d383532bdb8df35f8e5c91aaae3d45b8b2b8f04d
	public String getUsername() {
		return username;
	}



<<<<<<< HEAD

=======
>>>>>>> d383532bdb8df35f8e5c91aaae3d45b8b2b8f04d
	public void setUsername(String username) {
		this.username = username;
	}



<<<<<<< HEAD

=======
>>>>>>> d383532bdb8df35f8e5c91aaae3d45b8b2b8f04d
	public String getPassword() {
		return password;
	}



<<<<<<< HEAD

=======
>>>>>>> d383532bdb8df35f8e5c91aaae3d45b8b2b8f04d
	public void setPassword(String password) {
		this.password = password;
	}



<<<<<<< HEAD

=======
>>>>>>> d383532bdb8df35f8e5c91aaae3d45b8b2b8f04d
	public String getNomEmploye() {
		return nomEmploye;
	}



<<<<<<< HEAD

=======
>>>>>>> d383532bdb8df35f8e5c91aaae3d45b8b2b8f04d
	public void setNomEmploye(String nomEmploye) {
		this.nomEmploye = nomEmploye;
	}



<<<<<<< HEAD

=======
>>>>>>> d383532bdb8df35f8e5c91aaae3d45b8b2b8f04d
	public String getPrenomEmploye() {
		return PrenomEmploye;
	}



<<<<<<< HEAD

=======
>>>>>>> d383532bdb8df35f8e5c91aaae3d45b8b2b8f04d
	public void setPrenomEmploye(String prenomEmploye) {
		PrenomEmploye = prenomEmploye;
	}



<<<<<<< HEAD

=======
>>>>>>> d383532bdb8df35f8e5c91aaae3d45b8b2b8f04d
	public String getAddresse() {
		return addresse;
	}



<<<<<<< HEAD

=======
>>>>>>> d383532bdb8df35f8e5c91aaae3d45b8b2b8f04d
	public void setAddresse(String addresse) {
		this.addresse = addresse;
	}



<<<<<<< HEAD

=======
>>>>>>> d383532bdb8df35f8e5c91aaae3d45b8b2b8f04d
	public String getTelephone() {
		return telephone;
	}



<<<<<<< HEAD

=======
>>>>>>> d383532bdb8df35f8e5c91aaae3d45b8b2b8f04d
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}



<<<<<<< HEAD

=======
>>>>>>> d383532bdb8df35f8e5c91aaae3d45b8b2b8f04d
	public Equipe getEquipe() {
		return Equipe;
	}



<<<<<<< HEAD

	public void setEquipe(Equipe equipe) {
		Equipe = equipe;
=======
	public void setEquipe(Equipe equipe) {
		this.Equipe = equipe;
>>>>>>> d383532bdb8df35f8e5c91aaae3d45b8b2b8f04d
	}



<<<<<<< HEAD

=======
>>>>>>> d383532bdb8df35f8e5c91aaae3d45b8b2b8f04d
	public Collection<AppRole> getRoles() {
		return roles;
	}



<<<<<<< HEAD

=======
>>>>>>> d383532bdb8df35f8e5c91aaae3d45b8b2b8f04d
	public void setRoles(Collection<AppRole> roles) {
		this.roles = roles;
	}



<<<<<<< HEAD

	public Employe(Long id, String username, String password, String nomEmploye, String prenomEmploye, String addresse,
			String telephone, org.sid.entities.Equipe equipe, Collection<AppRole> roles) {
=======
	public Employe(Long id, String username, String password, String nomEmploye, String prenomEmploye, String addresse,
			String telephone,Equipe Equipe,  Collection<AppRole> roles) {
>>>>>>> d383532bdb8df35f8e5c91aaae3d45b8b2b8f04d
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.nomEmploye = nomEmploye;
		PrenomEmploye = prenomEmploye;
		this.addresse = addresse;
		this.telephone = telephone;
<<<<<<< HEAD
		Equipe = equipe;
=======
		this.Equipe = Equipe;
>>>>>>> d383532bdb8df35f8e5c91aaae3d45b8b2b8f04d
		this.roles = roles;
	}



<<<<<<< HEAD

=======
>>>>>>> d383532bdb8df35f8e5c91aaae3d45b8b2b8f04d
	public Employe() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	
	
	
	
	

}
