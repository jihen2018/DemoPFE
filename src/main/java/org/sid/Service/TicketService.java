package org.sid.Service;

import java.util.List;

import org.sid.dao.TicketRepository;
import org.sid.entities.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketService implements ITicketService {
	
	@Autowired
	private TicketRepository ticketRepository;

	@Override
	public Ticket create(Ticket ticket) {
		// TODO Auto-generated method stub
		return ticketRepository.save(ticket);
	}

	@Override
	public List<Ticket> findAll() {
		// TODO Auto-generated method stub
		return ticketRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		ticketRepository.delete(id);
		
	}

	@Override
	public Ticket find(long id) {
		// TODO Auto-generated method stub
		return ticketRepository.findOne(id);
	}
	
	

}
