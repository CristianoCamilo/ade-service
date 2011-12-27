package br.com.adeservice.repository;

import static br.com.adeservice.util.DateUtil.now;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.adeservice.model.Log;
import br.com.adeservice.model.DbCollection;

/**
 * Dec 27, 2011
 * @author fabio
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext.xml")
public class LogRepositoryTest extends AbstractRepositoryTest {
	
	@Autowired
	private LogRepository repository;
	
	@Test
	public void savingLog() {
		Log log = givenALog();
		repository.save(log);
		List<Log> logs = repository.getAll();
		
		assertThat(logs, hasItem(log));
	}
	
	private Log givenALog(){
		Log log = new Log();
		log.setId("1");
		log.setCreatedDate(now());
		log.setEntityId(11L);
		log.setEntityName("Entitiy Name");
		log.setErrorMessage("Error description");
		log.setIsAnyError(true);
		log.setProject("x1_project");
		return log;
	}

	@Override
	Class<? extends DbCollection> getCollectionType() {
		return Log.class;
	}

}