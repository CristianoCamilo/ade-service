package br.com.adeservice.resources;

import static java.lang.System.getProperty;
import static org.apache.commons.lang.StringUtils.isNotEmpty;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.log4j.Logger;

import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;

/**
 * Configurations properties ade-service.
 * 
 * Oct 18, 2011
 * @author fabio
 *
 */
@ApplicationScoped
@Component
public class AdeServiceProperties {
	
	private static final String ADE_SERVER_IP = "ade.server.ip";
	private static final String ADE_SERVER_PORT = "ade.server.port";

	private static Logger log = Logger.getLogger(AdeServiceProperties.class);

	private static final String SEPARATOR = "/";
	private static final String CONFIG_FILENAME = "adeservice.properties";
	private static final String CONFIG_PATH_VARIABLE = "config.adeservice";
	
	private static Configuration config;
	
	static {
		try {
			String pathVariable = getProperty(CONFIG_PATH_VARIABLE);
			String pathProperties = isNotEmpty(pathVariable) ? 
									pathVariable + SEPARATOR + CONFIG_FILENAME :
									CONFIG_FILENAME;
			config = new PropertiesConfiguration(pathProperties);	
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
		}
	}
	
	public static String getAdeServerIp() {
		return config.getString(ADE_SERVER_IP);
	}
	
	public static Integer getAdeServerPort(){
		return config.getInt(ADE_SERVER_PORT);
	}
	
}