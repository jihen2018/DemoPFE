package org.sid.web;

import java.util.List;

import org.sid.dao.TasksRepository;
import org.sid.entities.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TasksRestController {
	@Autowired
	TasksRepository tasksRepository;
	
	@GetMapping("/tickets")
	public List<Ticket> listTasks(){
		return tasksRepository.findAll();
	}
	@PostMapping("/saveTasks")
	public Ticket save(@RequestBody Ticket T) {
		return tasksRepository.save(T);
	}
}
