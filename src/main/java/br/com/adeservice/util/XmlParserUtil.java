package br.com.adeservice.util;

import static org.jdom.output.Format.getPrettyFormat;

import org.jdom.Element;
import org.jdom.output.XMLOutputter;

import br.com.adeservice.infra.ade.AdeRootEntity;

import com.thoughtworks.xstream.XStream;

/**
 * Apr 10, 2012
 * @author fabio
 *
 */
public class XmlParserUtil {
	
	public static String toXml(final Element element) {
		return new XMLOutputter(getPrettyFormat()).outputString(element);
	}
	
	@SuppressWarnings("unchecked")
	public static <T extends AdeRootEntity> T toEntity(final String xml, final Class<T> clazz){
		XStream xstream = new XStream();
		xstream.processAnnotations(clazz);
		return ((T) xstream.fromXML(xml));
	}
	
	@SuppressWarnings("unchecked")
	public static <T extends AdeRootEntity> T toEntity(final Element element, final Class<T> clazz){
		String xml = toXml(element);
		XStream xstream = new XStream();
		xstream.processAnnotations(clazz);
		return ((T) xstream.fromXML(xml));
	}
}
