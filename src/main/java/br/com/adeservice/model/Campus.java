package br.com.adeservice.model;

import com.adesoft.beans.settings.ResourceSettings;

/**
 * May 8, 2012
 * @author fabio
 *
 */
public class Campus implements AdeEntity {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private String code;
	private Project project;
	
	public Campus() {}
	
	public Campus(final Integer id, final String name, final String code) {
		this.id = id;
		this.name = name;
		this.code = code;
	}
	
	public Project getProject() {
		return project.load();
	}
	
	public Integer getId() {
		return this.id;
	}
	
	public String getCategory() {
		return ResourceSettings.ROOM;
	}

	public String getName() {
		return name;
	}

	public String getCode() {
		return code;
	}
}
