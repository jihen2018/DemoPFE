package org.sid.web;

import java.util.List;

import org.sid.Service.IEmployeService;
import org.sid.entities.Employe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employes")
public class EmployeRestService {
	@Autowired
	private IEmployeService employeService;
	@PostMapping("/register")
	public Employe register(@RequestBody RegisterForm Formuser) {
		if (!Formuser.getPassword().equals(Formuser.getRepassword()) )
			throw new RuntimeException("you must confirm your password");
		
		Employe user =employeService.findUserByUsername(Formuser.getUsername());
		if (user!=null)
				throw new RuntimeException("this user is already exist");
		
		
		Employe appUser= new Employe();
		appUser.setUsername(Formuser.getUsername());
		appUser.setPassword(Formuser.getPassword());
		
		employeService.saveUser(appUser);
		employeService.addRoleToUser(Formuser.getUsername()	,"USER");
	return appUser;
	}
	
	@RequestMapping(value="",method=RequestMethod.GET)
	public List<Employe> findAll() {
		return employeService.findAll();
	}
	@RequestMapping(value="{id}",method=RequestMethod.DELETE)
	public void delete(@PathVariable long id) {
		employeService.delete(id);	
}
}