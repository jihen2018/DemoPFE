package org.sid.Service;

import java.util.List;

import org.sid.dao.EquipeRepository;
import org.sid.entities.Equipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class EquipeService implements IEquipeService{

	
	@Autowired
	EquipeRepository equipeRepository;
	
	@Override
	public Equipe create(Equipe equipe) {
		equipeRepository.save(equipe);
		return equipe;
	}

	@Override
	public List<Equipe> findAll() {
		// TODO Auto-generated method stub
		return equipeRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		equipeRepository.delete(id);		
	}

	@Override
	public Equipe find(Long id) {
		// TODO Auto-generated method stub
		return equipeRepository.findOne(id);
	}
	
	
	

}


