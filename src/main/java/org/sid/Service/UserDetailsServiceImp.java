package org.sid.Service;

import java.util.ArrayList;
import java.util.Collection;

import org.sid.entities.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImp implements UserDetailsService {
	@Autowired
	private AccountService AccountService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AppUser user=AccountService.findUserByUsername(username);
		if (user==null) throw new UsernameNotFoundException(username);
		
		Collection<GrantedAuthority> authorities=new ArrayList<>();
		user.getRoles().forEach(r->{
			authorities.add(new SimpleGrantedAuthority(r.getRolename()));
		});
	
		return new User (user.getUsername(),user.getPassword(),authorities);
	}
	
	

}
