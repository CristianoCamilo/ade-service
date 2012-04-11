package br.com.adeservice.model;

import br.com.adeservice.infra.ade.AdeEntity;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * Apr 2, 2012
 * @author fabio
 *
 */
@XStreamAlias("project")
public class Project implements AdeEntity {
	
	private static final long serialVersionUID = -3127897483761691510L;
	
	@XStreamAsAttribute
	private Long id;
	
	@XStreamAsAttribute
	private String name;
	
	public Project() {}
	
	public Long getId() {
		return id;
	}
	
	public void setId(final Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(final String name) {
		this.name = name;
	}
	
}