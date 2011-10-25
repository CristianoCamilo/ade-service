package br.com.adeservice.resources;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

/**
 * Configurations properties ade-service.
 * 
 * Oct 18, 2011
 * @author fabio
 *
 */
public class AdeServiceProperties {
	
	private static final String ADE_SERVER_IP = "ade.server.ip";

	private static Logger log = Logger.getLogger(AdeServiceProperties.class);

	private static final String SEPARATOR = "/";
	private static final String CONFIG_FILENAME = "adeservice.properties";
	private static final String CONFIG_PATH_VARIABLE = "config.adeservice";
	private static final String DEFAULT_PATH = "resources";
	
	private static Configuration config;

	static {
		try {
			String pathVariable = System.getProperty(CONFIG_PATH_VARIABLE);
			String pathProperties = StringUtils.isNotEmpty(pathVariable) ? pathVariable : DEFAULT_PATH;
			
			config = new PropertiesConfiguration(pathProperties + SEPARATOR + CONFIG_FILENAME);	
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
		}
	}
	
	public static String getAdeServerIp() {
		return config.getString(ADE_SERVER_IP);
	}
	
}