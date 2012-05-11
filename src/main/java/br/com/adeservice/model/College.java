package br.com.adeservice.model;

import br.com.adeservice.dao.ActiveRecord;
import br.com.adeservice.dao.CollegeDao;
import br.com.adeservice.repository.CollegeRepository;

import com.adesoft.beans.settings.ResourceSettings;

/**
 * Apr 26, 2012
 * @author fabio
 *
 */
public class College extends ActiveRecord<CollegeRepository, CollegeDao> implements AdeEntity {

	private static final long serialVersionUID = -33309910874515529L;
	
	private Integer id;
	private String name;
	private String code;
	private Project project;
	
	public College() {}
	
	public College(final Integer id, final String name, final String code) {
		this.id = id;
		this.name = name;
		this.code = code;
	}

	public Integer getId() {
		return this.id;
	}

	public String getCategory() {
		return ResourceSettings.INSTRUCTOR;
	}

	public String getName() {
		return name;
	}

	public String getCode() {
		return code;
	}
	
	public Project getProject() {
		return project.load();
	}
	
	public boolean exist(){
		return getRepository().existCollege(this.name, getProject().getId());
	}
	
	public College save() {
		return getRepository().save(this);
	}
}