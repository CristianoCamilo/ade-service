package br.com.adeservice.infra.ade;

import javax.annotation.PostConstruct;

import br.com.adeservice.resources.AdeServiceProperties;
import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;
import br.com.caelum.vraptor.ioc.RequestScoped;

import com.adesoft.beans.AdeApi;

/**
 * Creates AdeApi instance and provides it to IOC.
 * Oct 31, 2011
 * @author fabio
 *
 */
@RequestScoped
@Component
public class AdeApiCreator implements ComponentFactory<AdeApi>{

	private AdeApi adeApi;
	private AdeServiceProperties properties;
	
	public AdeApiCreator(final AdeServiceProperties properties) {
		this.properties = properties;
	}

	public AdeApi getInstance() {
		return this.adeApi;
	}
	
	@PostConstruct
	public void create(){
		this.adeApi = new AdeApi();
		this.adeApi.setServer(properties.getAdeServerIp());
		this.adeApi.setServerPort(properties.getAdeServerPort());
	}
}