package br.com.adeservice.model;

import br.com.adeservice.dao.ActiveRecord;
import br.com.adeservice.dao.ProjectDao;
import br.com.adeservice.repository.ProjectRepository;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Apr 2, 2012
 * @author fabio
 *
 */
@XStreamAlias("project")
public class Project extends ActiveRecord<ProjectRepository, ProjectDao> implements AdeEntity {
	
	private static final long serialVersionUID = -3127897483761691510L;
	
	private Integer id;
	private String name;
	
	public Project() {}
	
	public Project(final Integer id, final String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}	
	
	public Project load(){
		return getRepository().load(this);
	}
	
	public String getCategory() {
		return null;
	}
}