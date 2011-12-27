package br.com.adeservice.repository;

import org.junit.After;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import br.com.adeservice.model.Log;
import br.com.adeservice.model.DbCollection;

/**
 * Dec 27, 2011
 * @author fabio
 *
 */
public abstract class AbstractRepositoryTest {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	abstract Class<? extends DbCollection> getCollectionType();
	
	@After
	public void tearDown(){
		if(mongoTemplate.collectionExists(Log.class))
			mongoTemplate.dropCollection(Log.class);
	}
}
