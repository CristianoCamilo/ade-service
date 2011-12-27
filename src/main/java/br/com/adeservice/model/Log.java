package br.com.adeservice.model;

import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Nov 30, 2011
 * @author fabio
 *
 */
@Document
public class Log implements DbCollection {
	
	private static final long serialVersionUID = -5435776842445573781L;
	
	@Id
	private String id;
	private String project;
	private Long entityId;
	private String entityName;
	private Boolean isAnyError;
	private String errorMessage;
	private Date createdDate;
	
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

	public Long getEntityId() {
		return entityId;
	}

	public void setEntityId(final Long entityId) {
		this.entityId = entityId;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(final String entityName) {
		this.entityName = entityName;
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

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(final Date createDate) {
		this.createdDate = createDate;
	}
	

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	@Override
	public boolean equals(final Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
}