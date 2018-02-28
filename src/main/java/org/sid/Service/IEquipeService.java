package org.sid.Service;

import java.util.List;

import org.sid.entities.Equipe;

public interface IEquipeService {
	
    public Equipe create(Equipe equipe);
	
	public List<Equipe> findAll();
	
	public void delete (Long  id);

	public Equipe find(Long id);

}
