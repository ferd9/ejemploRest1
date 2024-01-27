/**
 * 
 */
package com.ferz.todoapp.service.dto;

import java.time.LocalDateTime;

import lombok.Data;
/**
 * @author Lynkos
 *
 */
@Data
public class TaskInDTO {

	private String title;
	private String description;	
	private LocalDateTime eta;
}
