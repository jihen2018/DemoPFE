package org.sid.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.web.bind.annotation.PathVariable;



@Entity

@Table(name="equipe")
public class Equipe implements Serializable
{
	
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * ID of the UserGroup Entity
	 */
	@Id
	@GeneratedValue
    @Column(name="equipeid")
	private Long EquipeID;
	
	
	/**
	 * Attributes
	 */
    @Column(name="equipe_name")
	private String EquipeName;
    @Column(name="equipe_description")
	private String EquipeDescription;
    @Column(name="equipe_creation_date")
	private Date EquipeCreationDate;
	
	@OneToMany(mappedBy = "Equipe" , fetch = FetchType.EAGER)
	private  Set<Employe> employes;

   

	public Long getEquipeID() {
		return EquipeID;
	}



	public void setEquipeID(Long equipeID) {
		EquipeID = equipeID;
	}



	public String getEquipeName() {
		return EquipeName;
	}



	public void setEquipeName(String equipeName) {
		EquipeName = equipeName;
	}



	public String getEquipeDescription() {
		return EquipeDescription;
	}



	public void setEquipeDescription(String equipeDescription) {
		EquipeDescription = equipeDescription;
	}



	public Date getEquipeCreationDate() {
		return EquipeCreationDate;
	}



	public void setEquipeCreationDate(Date equipeCreationDate) {
		EquipeCreationDate = equipeCreationDate;
	}



	public Set<Employe> getEmployes() {
		return employes;
	}



	public Equipe(Long equipeID, String equipeName, String equipeDescription, Date equipeCreationDate,
			Set<Employe> employes) {
		super();
		EquipeID = equipeID;
		EquipeName = equipeName;
		EquipeDescription = equipeDescription;
		EquipeCreationDate = equipeCreationDate;
		this.employes = employes;
	}



	public void setEmployes(Set<Employe> employes) {
		this.employes = employes;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public Equipe() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
