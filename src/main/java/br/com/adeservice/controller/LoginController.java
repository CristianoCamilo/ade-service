package br.com.adeservice.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

/**
 * Sep 28, 2011
 * 
 * @author fabio Controller responsible of the login.
 * 
 */
@Resource
public class LoginController {

	private Result result;

	public LoginController(final Result result) {
		this.result = result;
	}
	
	@Post("/validate")
	public void validate() {

	}
	
	@Get("/login")
	public void login() {

	}

	@Get("/logout")
	public void logout() {
		result.redirectTo(this).login();
	}

}
