package br.com.adeservice.dao;

import java.lang.reflect.ParameterizedType;

import br.com.adeservice.repository.BaseRepository;
import br.com.adeservice.repository.RepositoryFactory;

/**
 * May 8, 2012
 * @author fabio
 *
 */
public abstract class ActiveRecord <T extends BaseRepository, E extends AbstractBaseDao> {
	
	private T repository;
	private Class<E> daoClass;

	@SuppressWarnings("unchecked")
	public T getRepository(){
		this.daoClass = (Class<E>) ((ParameterizedType) getClass()
									.getGenericSuperclass()).getActualTypeArguments()[1];
		if(repository == null)
			this.repository = RepositoryFactory.getInstance(daoClass);
		return this.repository;
	}

}
