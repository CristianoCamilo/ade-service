package br.com.adeservice.model;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.jmock.lib.legacy.ClassImposteriser;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.adesoft.beans.AdeApi;
import com.adesoft.errors.InvalidLogin;

/**
 * Oct 31, 2011
 * @author fabio
 *
 */
@RunWith(JMock.class)
public class LoggedUserTest {
	
	private AdeApi adeApi;
	private LoggedUser loggedUser;
	
	private Mockery context = new JUnit4Mockery(){{
		setImposteriser(ClassImposteriser.INSTANCE);
	}};
	
	@Before
	public void setup(){

	}
	
	@Test
	public void loginWithValidUser() {
		LoggedUser user = givenLoggedUser("fabio.masson", "123");
		
		givenThatUserExist(user);
		
		shouldLogin(user);
		
		whenILoginWith(user);
		
		assertThat(this.loggedUser.getIsLogged(), is(true));
	}

	@Test
	public void loginWithInvalidUser() {
		LoggedUser user = givenLoggedUser("fabio.masson", "123");
		
		givenThatUserDoesntExist(user);
		
		shouldNotLogin(user);
		
		whenILoginWith(user);
		
		assertThat(this.loggedUser.getIsLogged(), is(false));
	}
	
	
	private void whenILoginWith(final LoggedUser user) {
		this.loggedUser = new LoggedUser(adeApi);
		this.loggedUser.login(user.getUsername(), user.getPassword());
	}

	private LoggedUser givenLoggedUser(final String username, final String password){
		loggedUser = new LoggedUser(adeApi);
		loggedUser.setUsername(username);
		loggedUser.setPassword(password);
		return loggedUser;
	}
	
	private void givenThatUserDoesntExist(final LoggedUser user){
		user.setUsername("invalid.user");
		user.setPassword("invalid.password");
	}
	
	private void givenThatUserExist(final LoggedUser user) {
		user.setUsername("root");
		user.setPassword("");
	}
	
	private void shouldNotLogin(final LoggedUser loggedUser) {
		this.adeApi = context.mock(AdeApi.class);
		context.checking(new Expectations() {
			{
				one(adeApi).setLogin(loggedUser.getUsername());
				will(throwException(new InvalidLogin()));
			}
		});
	}
	
	private void shouldLogin(final LoggedUser user) {
		this.adeApi = context.mock(AdeApi.class);
		context.checking(new Expectations() {
			{
				allowing(adeApi).setLogin(loggedUser.getUsername());
				allowing(adeApi).setPassword(loggedUser.getPassword());
			}
		});
	}
}