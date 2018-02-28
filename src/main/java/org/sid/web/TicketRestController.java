package org.sid.web;

import java.util.List;

import javax.websocket.server.PathParam;

import org.sid.Service.ITicketService;

import org.sid.entities.Ticket;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/ticket")
public class TicketRestController {
	@Autowired
	private ITicketService TicketService;
	
	
	@RequestMapping(value="",method=RequestMethod.GET)
	public List<Ticket> listTasks(){
		return TicketService.findAll();
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public Ticket save(@RequestBody Ticket T) {
		return TicketService.create(T);
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
		public void delete(@PathVariable Long id) {
		TicketService.delete(id);
		}
	
	@RequestMapping(value="/find/{id}",method=RequestMethod.GET)
	public Ticket find(@PathVariable long id) {
		return TicketService.find(id);
	}
	
}
