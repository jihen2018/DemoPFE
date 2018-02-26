package org.sid.dao;

import org.sid.entities.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeRepository extends JpaRepository<Employe, Long> {
	
	public Employe findByUsername(String username);

}
