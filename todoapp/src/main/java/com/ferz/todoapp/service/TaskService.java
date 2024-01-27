/**
 * 
 */
package com.ferz.todoapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ferz.todoapp.execptions.ToDoExeptions;
import com.ferz.todoapp.mapper.TaskInDTOToTaks;
import com.ferz.todoapp.persistence.entity.Task;
import com.ferz.todoapp.persistence.entity.TaskStatus;
import com.ferz.todoapp.persistence.repository.TaskRepository;
import com.ferz.todoapp.service.dto.TaskInDTO;

/**
 * @author Lynkos
 *
 */
@Service
public class TaskService {

	private final TaskRepository repository;
	private final TaskInDTOToTaks mapper;

	public TaskService(TaskRepository repository, TaskInDTOToTaks mapper) {
		super();
		this.repository = repository;
		this.mapper = mapper;
	}
	
	public Task createTask(TaskInDTO taskInDTO) {
		Task task = mapper.map(taskInDTO);		
		return repository.save(task);
	}
	
	public List<Task> findAll(){
		return this.repository.findAll();
	}	
	
	public List<Task> findAllByTaskStatus(TaskStatus status){
		return this.repository.findAllByTaskStatus(status);
	}
	
	@Transactional
	public void updateTaskAsFinished(Long id){
		Optional<Task> optionalTask = this.repository.findById(id);
		if(optionalTask.isEmpty()) {
			throw new ToDoExeptions("Task not foud", HttpStatus.NOT_FOUND);
		}
		this.repository.markTaskFinished(id);
	}
	
	public void deleteByID(Long id){
		Optional<Task> optionalTask = this.repository.findById(id);
		if(optionalTask.isEmpty()) {
			throw new ToDoExeptions("Task not foud", HttpStatus.NOT_FOUND);
		}
		this.repository.deleteById(id);
	}
	
}
