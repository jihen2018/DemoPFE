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
<<<<<<< HEAD
	
=======
>>>>>>> d383532bdb8df35f8e5c91aaae3d45b8b2b8f04d
	@RequestMapping(value="/addEmploye",method=RequestMethod.POST)
    public Employe saveUser(@RequestBody Employe Employe) {
    	
    	 employeService.saveUser(Employe);
    	 return Employe;
    }
<<<<<<< HEAD
	
	@RequestMapping(value="/{username}",method=RequestMethod.GET)
	public Employe findUserByUsername(@PathVariable String username) {
=======
	@RequestMapping(value="/{username}",method=RequestMethod.GET)
	public Employe findUserByUsername(String username) {
>>>>>>> d383532bdb8df35f8e5c91aaae3d45b8b2b8f04d
		
		return employeService.findUserByUsername(username);
	}

<<<<<<< HEAD
/*	@RequestMapping(value="/addEmploye",method=RequestMethod.POST)
	public void addRoleToUser(String username,String rolename) {
			employeService.addRoleToUser(Formuser.getUsername()	,"USER");
;
		
	}*/

=======
>>>>>>> d383532bdb8df35f8e5c91aaae3d45b8b2b8f04d

}