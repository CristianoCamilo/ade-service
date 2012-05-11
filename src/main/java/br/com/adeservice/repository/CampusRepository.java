package br.com.adeservice.repository;

import br.com.adeservice.model.Campus;

/**
 * May 8, 2012
 * @author fabio
 *
 */
public interface CampusRepository extends BaseRepository {
	
	Campus save(Campus campus);
	Campus getById(Integer id);
	boolean existCampus(String name, Integer idProject);

}
