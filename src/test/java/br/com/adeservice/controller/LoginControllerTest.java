package br.com.adeservice.controller;

import static org.junit.Assert.assertNotNull;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.com.adeservice.model.LoggedUser;
import br.com.caelum.vraptor.util.test.MockResult;
import br.com.caelum.vraptor.util.test.MockValidator;
import br.com.caelum.vraptor.validator.ValidationException;

/**
 * Nov 23, 2011
 * @author fabio
 *
 */
@RunWith(JMock.class)
public class LoginControllerTest {

	private MockResult result;
	private MockValidator validator;
	private LoginController controller;
	private LoggedUser loggedUser;
	
	private Mockery context = new JUnit4Mockery(){{
		setImposteriser(ClassImposteriser.INSTANCE);
	}};
	
	@Before
	public void setup(){
		this.result = new MockResult();
		this.validator = new MockValidator();
		this.loggedUser = context.mock(LoggedUser.class);
		this.controller = new LoginController(result, validator, loggedUser);
	}
	
	@Test
	public void loginWithValidUserAndPassword(){
		String validUser = givenValidUser();
		String validPassword = givenValidPassword();
		
		shouldLogin(validUser, validPassword);
		
		whenILoginWith(validUser, validPassword);
		String loggedUser = result.included("login");
		
		assertNotNull(loggedUser);
	}

	@Test(expected = ValidationException.class)
	public void loginWithInvalidUserAndPassword() {
		String invalidUser = givenAnInvalidUser();
		String invalidPassword = givenAnInvalidPassword();
		
		shouldNotLogin(invalidUser, invalidPassword);
		
		whenILoginWith(invalidUser, invalidPassword);
	}


	@Test(expected = ValidationException.class)
	public void validatingUserAndPasswordOnLogin() {
		String emptyUser = givenAnEmptyUser();
		String emptyPassword = givenAnEmptyPassword();
		
		shouldNeverCallsLogin(emptyUser, emptyPassword);

		whenILoginWith(emptyUser, emptyPassword);
	}

	private void whenILoginWith(final String user, final String password) {
		controller.validate(user, password);
	}


	private void shouldNeverCallsLogin(final String user, final String password) {
		context.checking(new Expectations() {
			{
				never(loggedUser).login(user, password);
			}
		});
	}
	
	private void shouldNotLogin(final String user, final String password) {
		context.checking(new Expectations() {
			{
				one(loggedUser).login(user, password);
				will(returnValue(false));
			}
		});
	}
	
	private void shouldLogin(final String user, final String password) {
		context.checking(new Expectations() {
			{
				one(loggedUser).login(user, password);
				will(returnValue(true));
			}
		});
	}
	
	private String givenValidPassword() {
		return "123";
	}

	private String givenValidUser() {
		return "fabio.masson";
	}
	
	private String givenAnEmptyUser() {
		return "";
	}
	
	private String givenAnEmptyPassword() {
		return "";
	}
	
	private String givenAnInvalidPassword() {
		return "invalid123";
	}

	private String givenAnInvalidUser() {
		return "invalid.user";
	}
}