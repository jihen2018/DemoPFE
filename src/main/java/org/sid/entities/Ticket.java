package org.sid.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 
@Table(name="ticket")
public class Ticket {
	
	@Id @GeneratedValue
	private Long id;
	
	@Column(name="nom_ticket")
	private String nomTicket;
	
	@Column(name="description_ticket")
	private String descriptionTicket;
	
	@Column(name="statut_ticket")
	private String statutTicket ;
	
	@Column(name="priority_ticket")
	private String PriorityTicket;
	
	@CreationTimestamp
	@JsonFormat(pattern="dd-MM-yyyy hh:mm:ss")
	@Column(name="opeing_date_ticket")
	private Date opeingDateTicket;
	
	@Temporal(TemporalType.TIME)
	@Column(name="closing_date_ticket")
	private Date closingDateTicket;
	
	@JsonFormat(pattern="dd-MM-yyyy hh:mm:ss")
	@UpdateTimestamp
	@Column(name="last_update")
	private Date lastUpdate;
	
	
	
	public String getNomTicket() {
		return nomTicket;
	}
	public void setNomTicket(String nomTicket) {
		this.nomTicket = nomTicket;
	}
	public String getDescriptionTicket() {
		return descriptionTicket;
	}
	public void setDescriptionTicket(String descriptionTicket) {
		this.descriptionTicket = descriptionTicket;
	}
	public String getStatutTicket() {
		return statutTicket;
	}
	public void setStatutTicket(String statutTicket) {
		this.statutTicket = statutTicket;
	}
	public String getPriorityTicket() {
		return PriorityTicket;
	}
	public void setPriorityTicket(String priorityTicket) {
		PriorityTicket = priorityTicket;
	}
	public Date getOpeingDateTicket() {
		return opeingDateTicket;
	}
	public void setOpeingDateTicket(Date opeingDateTicket) {
		this.opeingDateTicket = opeingDateTicket;
	}
	public Date getClosingDateTicket() {
		return closingDateTicket;
	}
	public void setClosingDateTicket(Date closingDateTicket) {
		this.closingDateTicket = closingDateTicket;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Ticket(Long id, String nomTicket, String descriptionTicket, String statutTicket, String priorityTicket,
			Date opeingDateTicket, Date closingDateTicket) {
		super();
		this.id = id;
		this.nomTicket = nomTicket;
		this.descriptionTicket = descriptionTicket;
		this.statutTicket = statutTicket;
		PriorityTicket = priorityTicket;
		this.opeingDateTicket = opeingDateTicket;
		this.closingDateTicket = closingDateTicket;
	}
	
	public Ticket() {
		super();
	}
	
	
	

}
