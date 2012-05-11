package br.com.adeservice.repository;

import java.util.List;

import br.com.adeservice.model.Project;

/**
 * May 3, 2012
 * @author fabio
 *
 */
public interface ProjectRepository extends BaseRepository {
	
	Project load(Project project);
	List<Project> listAll();

}
