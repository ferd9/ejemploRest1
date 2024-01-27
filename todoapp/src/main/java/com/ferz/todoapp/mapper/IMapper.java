/**
 * 
 */
package com.ferz.todoapp.mapper;

/**
 * @author Lynkos
 *
 */
public interface IMapper<I, O> {

	public O map(I in);
}
