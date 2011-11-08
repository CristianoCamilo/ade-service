package br.com.adeservice.model;

import java.io.Serializable;

import org.apache.log4j.Logger;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;

import com.adesoft.beans.AdeApi;

/**
 * Represents the logged user.
 * 
 * Oct 17, 2011
 * 
 * @author fabio
 * 
 */
@Component
@SessionScoped
public class LoggedUser implements Serializable {

	private static final long serialVersionUID = -3369649033974017505L;
	private Logger log = Logger.getLogger(LoggedUser.class);
	private AdeApi adeApi;
	
	private String username;
	private String password;
	private boolean isLogged;

	public LoggedUser(final AdeApi adeApi) {
		this.adeApi = adeApi;
	}
	
	public Boolean login(final String username, final String password){
		try {
			this.adeApi.setLogin(username);
			this.adeApi.setPassword(password);
			this.username = username;
			this.password = password;
			this.isLogged = true;
		} catch (Exception ex) {
			log.error("Nao foi possivel efetuar o login... username: " + username);
			log.error(ex.getMessage(), ex);
		}
		return isLogged;
	}
	
	public void logout(){
		this.isLogged = false;
		this.username = null;
		this.password = null;
	}
	
	public void setUsername(final String username) {
		this.username = username;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public boolean getIsLogged() {
		return isLogged;
	}

}