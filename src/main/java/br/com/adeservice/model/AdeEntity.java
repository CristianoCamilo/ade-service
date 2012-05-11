package br.com.adeservice.model;

import java.io.Serializable;

/**
 * Apr 2, 2012
 * @author fabio
 *
 */
public interface AdeEntity extends Serializable {
	
	Integer getId();
	String getCategory();
}
