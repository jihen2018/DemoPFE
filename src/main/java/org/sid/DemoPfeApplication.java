package org.sid;

import java.util.stream.Stream;

import org.sid.Service.IAccoutService;
import org.sid.dao.TasksRepository;
import org.sid.entities.AppRole;
import org.sid.entities.AppUser;
import org.sid.entities.Tasks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class DemoPfeApplication implements CommandLineRunner {
	@Autowired
	private TasksRepository tasksRepository;

	@Autowired
	private IAccoutService  accountService;
	public static void main(String[] args) {
		SpringApplication.run(DemoPfeApplication.class, args);
	}
	
	@Bean
	public BCryptPasswordEncoder getBCrPE() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void run(String... arg0) throws Exception {
		accountService.saveUser(new AppUser(null,"admin", "1234", null));
		accountService.saveUser(new AppUser(null,"user", "1234", null));		
		accountService.saveRole(new AppRole(null, "ADMIN"));
		accountService.saveRole(new AppRole(null, "USER"));
		
		accountService.addRoleToUser("admin", "ADMIN");
		accountService.addRoleToUser("admin", "USER");
		accountService.addRoleToUser("user", "USER");
		
		
		
		Stream.of("T1","T2","T3").forEach(t -> {
			tasksRepository.save(new Tasks(null,t));
		}) ;
		
		tasksRepository.findAll().forEach(t->{
			System.out.println(t.getNom());
		});
		
		
	}
}
