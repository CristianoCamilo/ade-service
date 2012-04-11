package br.com.adeservice.dao;

import br.com.adeservice.infra.ade.AdeEntity;
import br.com.adeservice.infra.exception.DaoException;
import br.com.adeservice.model.Project;
import br.com.adeservice.model.Projects;
import br.com.adeservice.util.XmlParserUtil;

import com.adesoft.beans.AdeApi;

/**
 * Apr 2, 2012
 * @author fabio
 *
 */
public abstract class AbstractBaseDao<T extends AdeEntity> {
	
	private static final Integer PROJECT_ID_AND_NAME = 2;
	
	private AdeApi api;

	public AbstractBaseDao(final AdeApi api) {
		this.api = api;
	}	

	private Long getProjectId(final String name) {
		Long projectId = null;
		try {
			Projects projects = XmlParserUtil.toEntity(api.getProjects(PROJECT_ID_AND_NAME), Projects.class);
			for (Project project : projects.getProjects()) {
				if(project.getName().equalsIgnoreCase((name))){
					projectId = project.getId();
					break;
				}
			}
		} catch (Exception ex) {
			throw new DaoException(ex);
		}
		return projectId;
	}
}
