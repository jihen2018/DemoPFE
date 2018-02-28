package org.sid.dao;

import org.sid.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TasksRepository extends JpaRepository<Ticket, Long> {
	

}
