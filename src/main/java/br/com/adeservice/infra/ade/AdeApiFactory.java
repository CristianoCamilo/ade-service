package br.com.adeservice.infra.ade;

import br.com.adeservice.resources.AdeServiceProperties;

import com.adesoft.beans.AdeApi;

/**
 * Creates AdeApi instance and provides it to IOC.
 * Oct 31, 2011
 * @author fabio
 *
 */
public class AdeApiFactory {

	public static AdeApi getInstance() {
		AdeApi adeApi = new AdeApi();
		adeApi.setServer(AdeServiceProperties.getAdeServerIp());
		adeApi.setServerPort(AdeServiceProperties.getAdeServerPort());
		adeApi.setLogin("root");
		adeApi.setPassword("");
		return adeApi;
	}
}