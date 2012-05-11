package br.com.adeservice.infra.ade;

import com.adesoft.beans.settings.ResourceSettings;

/**
 * May 3, 2012
 * @author fabio
 *
 */
public class ResourceSettingsFactory {

	public static ResourceSettings getInstance() {
		return new ResourceSettings();
	}

}
