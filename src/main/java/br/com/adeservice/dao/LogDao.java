package br.com.adeservice.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.Index;
import org.springframework.data.mongodb.core.query.Order;
import org.springframework.stereotype.Repository;

import br.com.adeservice.model.Log;
import br.com.adeservice.repository.LogRepository;

/**
 * Dec 5, 2011
 * @author fabio
 *
 */
@Repository
public class LogDao implements LogRepository {
	
	private MongoTemplate mongoTemplate;

	@Autowired
	public LogDao(final MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
		createIndex();
	}
	
	private void createIndex(){
		mongoTemplate.ensureIndex(new Index().on("project", Order.DESCENDING), Log.class);
	}
	
	public void save(final Log log){
		mongoTemplate.save(log);
	}
	
	public List<Log> getAll() {
		return mongoTemplate.findAll(Log.class);
	}
	
	

}
