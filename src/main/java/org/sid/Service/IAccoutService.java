package org.sid.Service;

import org.sid.entities.AppRole;
import org.sid.entities.AppUser;

public interface IAccoutService {
	
	public AppUser saveUser(AppUser user);
	public AppRole saveRole(AppRole role);
	public void addRoleToUser(String username,String rolename);
	public AppUser findUserByUsername(String username);

}
