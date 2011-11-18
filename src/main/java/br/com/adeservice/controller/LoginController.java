package br.com.adeservice.controller;

import br.com.adeservice.model.LoggedUser;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

/**
 * Controller responsible of the login.
 *  
 * Sep 28, 2011
 * 
 * @author fabio
 * 
 */
@Resource
public class LoginController {

	private Result result;
	
	public LoginController(final Result result) {
		this.result = result;
	}

	@Post("/login/validate")
	public void validate(final LoggedUser loggedUser) {
		// TODO validar login
		this.result.redirectTo(this).login();
		
	}
	
	@Get("/login")
	public void login() {
		// TODO realizar login 
	}

	@Get("/logout")
	public void logout() {
		result.redirectTo(this).login();
	}

}
