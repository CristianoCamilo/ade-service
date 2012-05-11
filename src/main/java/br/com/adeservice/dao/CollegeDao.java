package br.com.adeservice.dao;

import java.util.List;

import org.jdom.Element;

import br.com.adeservice.infra.exception.DaoException;
import br.com.adeservice.model.College;
import br.com.adeservice.repository.CollegeRepository;

import com.adesoft.beans.AdeApi;
import com.adesoft.beans.filters.FiltersResources;
import com.adesoft.beans.settings.ResourceSettings;

/**
 * May 3, 2012
 * @author fabio
 */
public class CollegeDao extends AbstractBaseDao implements CollegeRepository {
	
	public CollegeDao(final AdeApi api, final ResourceSettings resource, final FiltersResources filters) {
		super(api, resource, filters);
	}

	public College save(final College college) {
		College createdCollege = null;
		try {
			if(!college.exist()) {
				getApi().setProjectId(college.getProject().getId().intValue());
				
				getResource().setCategory(college.getCategory());
				getResource().setName(college.getName());
				getResource().setCode(college.getCode());
				getResource().setAsAGroup(true);
				
				Integer idCollege = getApi().createResource(getResource());
				createdCollege = getById(idCollege);
			}
			return createdCollege;
		} catch (Exception ex) {
			throw new DaoException(ex);
		}
	}

	public College getById(final Integer id) {
		try {
			getFilters().addFilterById(id);
			Element elem = (Element) getApi().getCategory(ResourceSettings.INSTRUCTOR, getFilters(), 0).getChildren().get(0);
			return new College(elem.getInt("id"), elem.getString("name"), elem.getString("code"));
		} catch (Exception ex) {
			throw new DaoException(ex);
		}
	}

	@SuppressWarnings("unchecked")
	public boolean existCollege(final String name, final Integer idProject) {
		try {
			getApi().setProjectId(idProject);
			getFilters().addFilterName(name);
			List<Element> elems = getApi().getCategory(ResourceSettings.INSTRUCTOR, getFilters(), 0).getChildren();
			return elems.size() > 0;
		} catch (Exception ex) {
			throw new DaoException(ex);
		}
	}
}
