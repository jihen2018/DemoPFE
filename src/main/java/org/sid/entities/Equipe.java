package org.sid.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;



@Entity

@Table(name = "USER_GROUP")
public class Equipe implements Serializable
{
	
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * ID of the UserGroup Entity
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EQUIPE_ID")
	private Long EquipeID;
	
	
	/**
	 * Attributes
	 */
	@NotNull
	@Column(name = "EQUIPE_NAME" , unique = true , nullable = false)
	private String EquipeName;

	@Column(name = "EQUIPE_DESCRIPTION")
	private String EquipeDescription;
	
	@Column(name = "EQUIPE_CREATION_DATE" , nullable = false , updatable = false)
	private Date EquipeCreationDate;
	
	@OneToMany(mappedBy = "Equipe" , fetch = FetchType.LAZY)
	private Collection<Employe> employes;

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

	public Collection<Employe> getEmployes() {
		return employes;
	}

	public void setEmployes(Collection<Employe> employes) {
		this.employes = employes;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Equipe(Long equipeID, String equipeName, String equipeDescription, Date equipeCreationDate,
			Collection<Employe> employes) {
		super();
		EquipeID = equipeID;
		EquipeName = equipeName;
		EquipeDescription = equipeDescription;
		EquipeCreationDate = equipeCreationDate;
		this.employes = employes;
	}

	public Equipe() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
