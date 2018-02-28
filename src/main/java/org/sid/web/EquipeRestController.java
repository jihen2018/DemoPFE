package org.sid.web;

import java.util.List;

import org.sid.Service.IEquipeService;
import org.sid.entities.Employe;
import org.sid.entities.Equipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Equipe")
public class EquipeRestController  {
	
	@Autowired
	IEquipeService    EquipeService;
	
<<<<<<< HEAD
	@RequestMapping(value="/listEquipe",method=RequestMethod.GET)
	public List<Equipe> findAll(){
		return EquipeService.findAll();
	}
	

	
	@RequestMapping(value="/saveEquipe",method=RequestMethod.POST)
    public Equipe create(@RequestBody Equipe E) {
=======
	@GetMapping("/Equipe")
	public List<Equipe> findAll(){
		return EquipeService.findAll();
	}
	/*@PostMapping("/saveEquipe")
	public Equipe create(@RequestBody Equipe E) {
		return EquipeService.create(E);
	}*/
	@RequestMapping(value="/saveEquipe",method=RequestMethod.POST)
    public Equipe saveUser(@RequestBody Equipe E) {
>>>>>>> d383532bdb8df35f8e5c91aaae3d45b8b2b8f04d
    	
		EquipeService.create(E);
    	 return E;
    }
	
<<<<<<< HEAD
	@RequestMapping(value="/findEquipe/{id}",method=RequestMethod.GET)
=======
	@GetMapping("/findEquipe")
>>>>>>> d383532bdb8df35f8e5c91aaae3d45b8b2b8f04d
	public Equipe find(@PathVariable long id ) {
		return EquipeService.find(id);
	}
	
	
<<<<<<< HEAD
	@RequestMapping(value="{id}",method=RequestMethod.DELETE)
=======
	@DeleteMapping("/deleteEquipe")
>>>>>>> d383532bdb8df35f8e5c91aaae3d45b8b2b8f04d
	public void  delete(@PathVariable Long id) {
		EquipeService.delete(id);		
	
	}
	
}

	
	

