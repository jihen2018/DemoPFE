package org.sid.Service;
import java.util.List;

import org.sid.dao.RoleRepository;
import org.sid.dao.EmployeRepository;
import org.sid.entities.AppRole;
import org.sid.entities.Employe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class EmployeService implements IEmployeService{
	
	@Autowired
	BCryptPasswordEncoder BCryptPasswordEncoder;
	
	@Autowired
	RoleRepository RoleRepository;
	@Autowired
	EmployeRepository UserRepository;
	
	@Override
	public Employe saveUser(Employe user) {
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
		Employe user = UserRepository.findByUsername(username);
		
		user.getRoles().add(role);
		
	}
	@Override
	public Employe findUserByUsername(String username) {
		// TODO Auto-generated method stub
		return UserRepository.findByUsername(username);
	}
	
	@Override
	public List<Employe> findAll() {
		return UserRepository.findAll();
	}
	
	public void delete(Long id) {
		// TODO Auto-generated method stub
		UserRepository.delete(id);
		
	}

}
