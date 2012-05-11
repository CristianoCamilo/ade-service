package br.com.adeservice.repository;

import br.com.adeservice.dao.AbstractBaseDao;
import br.com.adeservice.infra.ade.AdeApiFactory;
import br.com.adeservice.infra.ade.FiltersResourcesFactory;
import br.com.adeservice.infra.ade.ResourceSettingsFactory;
import br.com.adeservice.infra.exception.DaoException;

import com.adesoft.beans.AdeApi;
import com.adesoft.beans.filters.FiltersResources;
import com.adesoft.beans.settings.ResourceSettings;


/**
 * May 7, 2012
 * @author fabio
 *
 */
public class RepositoryFactory {
	
	@SuppressWarnings("unchecked")
	public static <T extends BaseRepository> T getInstance(final Class<? extends AbstractBaseDao> clazz) {
		try {
			return (T) clazz.getConstructor(AdeApi.class, ResourceSettings.class, FiltersResources.class)
					.newInstance(AdeApiFactory.getInstance(), ResourceSettingsFactory.getInstance(), FiltersResourcesFactory.getInstance());
		} catch (Exception ex) {
			throw new DaoException(ex);
		}
	}

}
