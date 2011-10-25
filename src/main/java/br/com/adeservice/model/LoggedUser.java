package br.com.adeservice.model;

import java.io.Serializable;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;

/**
 * Represents the logged user.
 * 
 * Oct 17, 2011
 * @author fabio
 *
 */
@Component
@SessionScoped
public class LoggedUser implements Serializable {
	
	private static final long serialVersionUID = -3369649033974017505L;
	private String username;
	private String password;
	
	public LoggedUser() {}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(final String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(final String password) {
		this.password = password;
	}

}