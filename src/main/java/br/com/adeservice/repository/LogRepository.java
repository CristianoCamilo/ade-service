package br.com.adeservice.repository;

import java.util.List;

import br.com.adeservice.model.Log;


/**
 * 
 * Nov 30, 2011
 * @author fabio
 */
public interface LogRepository {
	
	void save(final Log log);
	List<Log> getAll();

}
