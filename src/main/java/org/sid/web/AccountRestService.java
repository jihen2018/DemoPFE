package org.sid.web;

import org.sid.Service.IAccoutService;
import org.sid.entities.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountRestService {
	@Autowired
	private IAccoutService accountService;
	@PostMapping("/register")
	public AppUser register(@RequestBody RegisterForm Formuser) {
		if (!Formuser.getPassword().equals(Formuser.getRepassword()) )
			throw new RuntimeException("you must confirm your password");
		
		AppUser user =accountService.findUserByUsername(Formuser.getUsername());
		if (user!=null)
				throw new RuntimeException("this user is already exist");
		
		
		AppUser appUser= new AppUser();
		appUser.setUsername(Formuser.getUsername());
		appUser.setPassword(Formuser.getPassword());
		
	accountService.saveUser(appUser);
	accountService.addRoleToUser(Formuser.getUsername()	,"USER");
	return appUser;
	}
}
