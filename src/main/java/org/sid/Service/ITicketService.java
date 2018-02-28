package org.sid.Service;

import java.util.List;

import org.sid.entities.Ticket;

		public interface ITicketService {
	
		public Ticket create(Ticket ticket);
		
		public List<Ticket> findAll();
		
		public void delete (Long  id);

		public Ticket find(long id);


}
