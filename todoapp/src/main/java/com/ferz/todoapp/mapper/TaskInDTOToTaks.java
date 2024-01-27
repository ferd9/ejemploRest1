package com.ferz.todoapp.mapper;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.ferz.todoapp.persistence.entity.Task;
import com.ferz.todoapp.persistence.entity.TaskStatus;
import com.ferz.todoapp.service.dto.TaskInDTO;

@Component
public class TaskInDTOToTaks  implements IMapper<TaskInDTO, Task>{

	@Override
	public Task map(TaskInDTO in) {
		Task task = new Task();		
		task.setTitle(in.getTitle());
		task.setDescription(in.getDescription());
		task.setEta(in.getEta());
		task.setCreatedDate(LocalDateTime.now());
		task.setFinished(false);
		task.setTaskStatus(TaskStatus.ONTIME);
		return task;
	}

}
