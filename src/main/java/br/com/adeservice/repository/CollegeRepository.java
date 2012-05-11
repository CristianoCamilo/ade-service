package br.com.adeservice.repository;

import br.com.adeservice.model.College;

/**
 * May 3, 2012
 * @author fabio
 *
 */
public interface CollegeRepository extends BaseRepository {
	
	College save(College college);
	College getById(Integer id);
	boolean existCollege(String name, Integer idProject);
}
