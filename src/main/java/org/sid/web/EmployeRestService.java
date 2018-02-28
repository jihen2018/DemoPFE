package org.sid.web;

import java.util.List;

import org.sid.Service.IEmployeService;
import org.sid.entities.AppRole;
import org.sid.entities.Employe;
import org.sid.entities.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Employe")
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
		System.out.println(user);
		employeService.saveUser(appUser);
		employeService.addRoleToUser(Formuser.getUsername()	,"USER");
	return appUser;
	}
	
	@RequestMapping(value="/listEmploye",method=RequestMethod.GET)
	public List<Employe> FindAll(){
		return employeService.findAll();
	}
	
	@RequestMapping(value="{id}",method=RequestMethod.DELETE)
	public void delete(@PathVariable long id) {
		employeService.delete(id);	
}
	
	@RequestMapping(value="/addEmploye",method=RequestMethod.POST)
    public Employe saveUser(@RequestBody Employe Employe) {
    	
    	 employeService.saveUser(Employe);
    	 return Employe;
    }
	
	@RequestMapping(value="/{username}",method=RequestMethod.GET)
	public Employe findUserByUsername(@PathVariable String username) {
		
		return employeService.findUserByUsername(username);
	}

/*	@RequestMapping(value="/addEmploye",method=RequestMethod.POST)
	public void addRoleToUser(String username,String rolename) {
			employeService.addRoleToUser(Formuser.getUsername()	,"USER");
;
		
	}*/


}