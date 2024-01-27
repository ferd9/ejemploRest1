/**
 * 
 */
package com.ferz.todoapp.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ferz.todoapp.persistence.entity.Task;
import com.ferz.todoapp.persistence.entity.TaskStatus;

/**
 * @author Lynkos
 *
 */
public interface TaskRepository extends JpaRepository<Task, Long> {
	
	public List<Task> findAllByTaskStatus(TaskStatus status);
	
	@Modifying
	@Query(value = "update task set finished = true where id=:id", nativeQuery = true)
	public void markTaskFinished(@Param("id") Long id);

}
