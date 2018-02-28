package org.sid.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
<<<<<<< HEAD
import java.util.Set;
=======
>>>>>>> d383532bdb8df35f8e5c91aaae3d45b8b2b8f04d

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

<<<<<<< HEAD
import org.springframework.web.bind.annotation.PathVariable;

=======
>>>>>>> d383532bdb8df35f8e5c91aaae3d45b8b2b8f04d


@Entity

<<<<<<< HEAD
@Table(name="equipe")
=======
@Table(name = "USER_GROUP")
>>>>>>> d383532bdb8df35f8e5c91aaae3d45b8b2b8f04d
public class Equipe implements Serializable
{
	
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * ID of the UserGroup Entity
	 */
	@Id
<<<<<<< HEAD
	@GeneratedValue
    @Column(name="equipeid")
=======
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EQUIPE_ID")
>>>>>>> d383532bdb8df35f8e5c91aaae3d45b8b2b8f04d
	private Long EquipeID;
	
	
	/**
	 * Attributes
	 */
<<<<<<< HEAD
    @Column(name="equipe_name")
	private String EquipeName;
    @Column(name="equipe_description")
	private String EquipeDescription;
    @Column(name="equipe_creation_date")
	private Date EquipeCreationDate;
	
	@OneToMany(mappedBy = "Equipe" , fetch = FetchType.EAGER)
	private  Set<Employe> employes;

   
=======
	@NotNull
	@Column(name = "EQUIPE_NAME" , unique = true , nullable = false)
	private String EquipeName;

	@Column(name = "EQUIPE_DESCRIPTION")
	private String EquipeDescription;
	
	@Column(name = "EQUIPE_CREATION_DATE" , nullable = false , updatable = false)
	private Date EquipeCreationDate;
	
	@OneToMany(mappedBy = "Equipe" , fetch = FetchType.LAZY)
	private Collection<Employe> employes;
>>>>>>> d383532bdb8df35f8e5c91aaae3d45b8b2b8f04d

	public Long getEquipeID() {
		return EquipeID;
	}

<<<<<<< HEAD


=======
>>>>>>> d383532bdb8df35f8e5c91aaae3d45b8b2b8f04d
	public void setEquipeID(Long equipeID) {
		EquipeID = equipeID;
	}

<<<<<<< HEAD


=======
>>>>>>> d383532bdb8df35f8e5c91aaae3d45b8b2b8f04d
	public String getEquipeName() {
		return EquipeName;
	}

<<<<<<< HEAD


=======
>>>>>>> d383532bdb8df35f8e5c91aaae3d45b8b2b8f04d
	public void setEquipeName(String equipeName) {
		EquipeName = equipeName;
	}

<<<<<<< HEAD


=======
>>>>>>> d383532bdb8df35f8e5c91aaae3d45b8b2b8f04d
	public String getEquipeDescription() {
		return EquipeDescription;
	}

<<<<<<< HEAD


=======
>>>>>>> d383532bdb8df35f8e5c91aaae3d45b8b2b8f04d
	public void setEquipeDescription(String equipeDescription) {
		EquipeDescription = equipeDescription;
	}

<<<<<<< HEAD


=======
>>>>>>> d383532bdb8df35f8e5c91aaae3d45b8b2b8f04d
	public Date getEquipeCreationDate() {
		return EquipeCreationDate;
	}

<<<<<<< HEAD


=======
>>>>>>> d383532bdb8df35f8e5c91aaae3d45b8b2b8f04d
	public void setEquipeCreationDate(Date equipeCreationDate) {
		EquipeCreationDate = equipeCreationDate;
	}

<<<<<<< HEAD


	public Set<Employe> getEmployes() {
		return employes;
	}



	public Equipe(Long equipeID, String equipeName, String equipeDescription, Date equipeCreationDate,
			Set<Employe> employes) {
=======
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
>>>>>>> d383532bdb8df35f8e5c91aaae3d45b8b2b8f04d
		super();
		EquipeID = equipeID;
		EquipeName = equipeName;
		EquipeDescription = equipeDescription;
		EquipeCreationDate = equipeCreationDate;
		this.employes = employes;
	}

<<<<<<< HEAD


	public void setEmployes(Set<Employe> employes) {
		this.employes = employes;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



=======
>>>>>>> d383532bdb8df35f8e5c91aaae3d45b8b2b8f04d
	public Equipe() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
