/**
 * 
 */
package com.ferz.todoapp.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ferz.todoapp.persistence.entity.Task;
import com.ferz.todoapp.persistence.entity.TaskStatus;
import com.ferz.todoapp.service.TaskService;
import com.ferz.todoapp.service.dto.TaskInDTO;

/**
 * @author Lynkos
 *
 */
@RestController
@RequestMapping("/tasks")
public class TaskController {

	private final TaskService taskService;

	/**
	 * @param taskService
	 */
	public TaskController(TaskService taskService) {
		super();
		this.taskService = taskService;
	}
	
	@PostMapping
	public Task createTaks(@RequestBody TaskInDTO TaskInDTO) {
		return this.taskService.createTask(TaskInDTO);
	}
	
	@GetMapping
	public List<Task> findAll() {
		return this.taskService.findAll();
	}
	
	@GetMapping("/status/{status}")
	public List<Task> findAllbyStatus(@PathVariable("status")TaskStatus status) {
		return this.taskService.findAllByTaskStatus(status);
	}
	
	@PatchMapping("/mark_as_finished/{id}")
	public ResponseEntity<Void> markAsFinished(@PathVariable("id")Long id){
		this.taskService.updateTaskAsFinished(id);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id")Long id){
		this.taskService.deleteByID(id);
		return ResponseEntity.noContent().build();
	}
}
