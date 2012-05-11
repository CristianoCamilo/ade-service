package br.com.adeservice.dao;

import java.util.ArrayList;
import java.util.List;

import org.jdom.Element;

import br.com.adeservice.infra.exception.DaoException;
import br.com.adeservice.model.Project;
import br.com.adeservice.repository.ProjectRepository;

import com.adesoft.beans.AdeApi;
import com.adesoft.beans.filters.FiltersResources;
import com.adesoft.beans.settings.ResourceSettings;

/**
 * Apr 2, 2012
 * @author fabio
 *
 */
public class ProjectDao extends AbstractBaseDao implements ProjectRepository {
	
	private static final Integer PROJECT_ID_AND_NAME = 2;
	
	public ProjectDao(final AdeApi api, final ResourceSettings resource,
			final FiltersResources filters) {
		super(api, resource, filters);
	}

	public Project load(final Project project) {
		for(Project p : listAll()){
			if(p.getId().equals(project.getId()) || p.getName().equalsIgnoreCase(project.getName()))
				return p;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Project> listAll() {
		List<Project> projects = new ArrayList<Project>();
		try {
			for(Element node: (List<Element>)getApi().getProjects(PROJECT_ID_AND_NAME).getChildren()) {
				projects.add(new Project(node.getInt("id"), node.getString("name")));
			}
		} catch (Exception ex) {
			throw new DaoException(ex);
		}
		return projects;
	}
}