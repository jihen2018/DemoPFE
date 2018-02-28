package org.sid;

import java.util.stream.Stream;

import org.sid.Service.IEmployeService;
import org.sid.dao.EquipeRepository;
import org.sid.dao.TicketRepository;
import org.sid.entities.AppRole;
import org.sid.entities.Employe;
import org.sid.entities.Equipe;
import org.sid.entities.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class DemoPfeApplication implements CommandLineRunner {
	@Autowired
	private TicketRepository tasksRepository;

	@Autowired
	private IEmployeService  employeService;

	public static void main(String[] args) {
		SpringApplication.run(DemoPfeApplication.class, args);
	}
	
	@Bean
	public BCryptPasswordEncoder getBCrPE() {
		return new BCryptPasswordEncoder();
	}
	@Bean
    public WebMvcConfigurerAdapter corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
    			.allowedOrigins("http://localhost:4200")
    			.allowedMethods("POST", "GET","DELETE")
    			.allowCredentials(false);
            }
        };
	}

	@Override
	public void run(String... arg0) throws Exception {
		employeService.saveUser(new Employe(null,"superadmin", "superadmin","jihen","bn","mourouj","1111", null,null));
		employeService.saveUser(new Employe(null,"superviseur", "superviseur","malek","bn","mourouj","111",null,null));
		employeService.saveUser(new Employe(null,"agent", "agent","admin","bn","mourouj","111",null,null));
		
		
		employeService.saveRole(new AppRole(null, "SUPERADMIN"));
		employeService.saveRole(new AppRole(null, "SPERVISEUR"));
		employeService.saveRole(new AppRole(null, "USER"));
		
		employeService.addRoleToUser("superadmin", "SUPERADMIN");
		employeService.addRoleToUser("superviseur", "SPERVISEUR");
		employeService.addRoleToUser("agent", "USER");
		
	/*
		Stream.of("T1","T2","T3").forEach(t -> {
			tasksRepository.save(new Ticket(null,t));
		}) ;
		
		tasksRepository.findAll().forEach(t->{
			System.out.println(t.getNom());
		});
*/
	
		
	}
}
