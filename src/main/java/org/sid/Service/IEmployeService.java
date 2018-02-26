package org.sid.Service;

import java.util.List;

import org.sid.entities.AppRole;
import org.sid.entities.Employe;

public interface IEmployeService {
	
	public Employe saveUser(Employe user);
	public AppRole saveRole(AppRole role);
	public void addRoleToUser(String username,String rolename);
	public Employe findUserByUsername(String username);
	public void delete (Long  id);
	public List<Employe> findAll();

}
