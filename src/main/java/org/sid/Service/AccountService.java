package org.sid.Service;
import org.sid.dao.RoleRepository;
import org.sid.dao.UserRepository;
import org.sid.entities.AppRole;
import org.sid.entities.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class AccountService implements IAccoutService{
	
	@Autowired
	BCryptPasswordEncoder BCryptPasswordEncoder;
	
	@Autowired
	RoleRepository RoleRepository;
	@Autowired
	UserRepository UserRepository;
	
	@Override
	public AppUser saveUser(AppUser user) {
		String hassPW = BCryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(hassPW);
		
		return UserRepository.save(user);
	}
	@Override
	public AppRole saveRole(AppRole role) {
		// TODO Auto-generated method stub
		return RoleRepository.save(role);
	}
	@Override
	public void addRoleToUser(String username, String rolename) {
		AppRole role=RoleRepository.findByRolename(rolename);
		AppUser user = UserRepository.findByUsername(username);
		
		user.getRoles().add(role);
		
	}
	@Override
	public AppUser findUserByUsername(String username) {
		// TODO Auto-generated method stub
		return UserRepository.findByUsername(username);
	}

	
}
