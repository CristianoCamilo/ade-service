package br.com.adeservice.controller;

import br.com.adeservice.model.LoggedUser;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.Validations;

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
	private Validator validator;
	private LoggedUser loggedUser;
	
	public LoginController(final Result result, final Validator validator, final LoggedUser loggedUser) {
		this.result = result;
		this.validator = validator;
		this.loggedUser = loggedUser;
	}

	@Post("/login/validate")
	public void validate(final String login, final String password) {		
		validator.checking(new Validations() {
			{
				if (that(login != null && password != null, "", "msg.login.empty") &&
					that(!login.isEmpty() && !password.isEmpty(), "", "msg.login.empty")) {
					that(loggedUser.login(login, password), "", "msg.login.invalid");
				}
			}
		});

		validator.onErrorUsePageOf(LoginController.class).login();
		result.include("login", login).redirectTo(IndexController.class).index();
	}
	
	@Get("/login")
	public void login() {
		
	}

	@Get("/logout")
	public void logout() {
		this.loggedUser.logout();
		result.redirectTo(this).login();
	}

}
