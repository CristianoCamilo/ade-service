package br.com.adeservice.dao;

import com.adesoft.beans.AdeApi;
import com.adesoft.beans.filters.FiltersResources;
import com.adesoft.beans.settings.ResourceSettings;

/**
 * May 5, 2012
 * @author fabio
 *
 */
public abstract class AbstractBaseDao {
	
	private AdeApi api;
	private ResourceSettings resource;
	private FiltersResources filters;
	
	public AbstractBaseDao(final AdeApi api, final ResourceSettings resource,
			final FiltersResources filters) {
		this.api = api;
		this.resource = resource;
		this.filters = filters;
	}

	public AdeApi getApi() {
		return api;
	}

	public ResourceSettings getResource() {
		return resource;
	}

	public FiltersResources getFilters() {
		return filters;
	}

}
