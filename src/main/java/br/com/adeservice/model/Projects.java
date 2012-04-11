package br.com.adeservice.model;

import java.util.List;

import br.com.adeservice.infra.ade.AdeRootEntity;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

/**
 * Apr 10, 2012
 * @author fabio
 *
 */
@XStreamAlias("projects")
public class Projects implements AdeRootEntity {
	
	private static final long serialVersionUID = -8961487148129445430L;
	
	@XStreamImplicit(itemFieldName="project")
	private List<Project> projects;
	
	public Projects(final List<Project> projects) {
		this.projects = projects;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(final List<Project> projects) {
		this.projects = projects;
	}
}
