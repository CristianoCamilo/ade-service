package br.com.adeservice.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Nov 30, 2011
 * @author fabio
 *
 */
@Document
public class Log implements Serializable {
	
	private static final long serialVersionUID = -5435776842445573781L;
	
	@Id
	private String id;
	private String project;
	private String entityCode;
	private String entityType;
	private Boolean isAnyError;
	private String errorMessage;
	private Date createDate;
	
	public Log() {}

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public String getProject() {
		return project;
	}

	public void setProject(final String project) {
		this.project = project;
	}

	public String getEntityCode() {
		return entityCode;
	}

	public void setEntityCode(final String entityCode) {
		this.entityCode = entityCode;
	}

	public String getEntityType() {
		return entityType;
	}

	public void setEntityType(final String entityType) {
		this.entityType = entityType;
	}

	public Boolean getIsAnyError() {
		return isAnyError;
	}

	public void setIsAnyError(final Boolean isAnyError) {
		this.isAnyError = isAnyError;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(final String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(final Date createDate) {
		this.createDate = createDate;
	}
	
}
