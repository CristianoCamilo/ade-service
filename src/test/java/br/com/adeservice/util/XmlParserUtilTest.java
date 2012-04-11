package br.com.adeservice.util;

import static br.com.adeservice.util.XmlParserUtil.toEntity;
import static br.com.adeservice.util.XmlParserUtil.toXml;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.equalToIgnoringWhiteSpace;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.junit.Test;

import br.com.adeservice.model.Project;
import br.com.adeservice.model.Projects;

import com.thoughtworks.xstream.XStream;

/**
 * Apr 10, 2012
 * @author fabio
 *
 */
public class XmlParserUtilTest {
	
	private static final String XML_EXPECTED =  " <projects> "+
	  											"	<project> " +
	  											"		<id>18</id> " +
	  											"		<name>project-name</name> " +
	  											"	</project> " +
	  											" </projects> ";
	
	@Test
	public void convertingElementToXml(){
		Element element = givenAnElement();
		
		assertThat(toXml(element), equalToIgnoringWhiteSpace(XML_EXPECTED));
	}
	
	@Test
	public void convertingXmlToEntity(){
		String xml = givenAXml();
		
		Projects projects = toEntity(xml, Projects.class);
		Project p = projects.getProjects().get(0);
		
		assertThat(p.getId(), is(28L));
		assertThat(p.getName(), equalTo("project test"));
	}
	

	private String givenAXml() {
		Project project = new Project();
		project.setId(28L);
		project.setName("project test");
		
		List<Project> proj = new ArrayList<Project>();
		proj.add(project);
		
		Projects projects = new Projects(proj);
		
		XStream xstream = new XStream();
		xstream.processAnnotations(Projects.class);
		return xstream.toXML(projects);
	}

	private Element givenAnElement(){
		Document document = new Document();
		Element root = new Element("projects");

		Element child = new Element("project");
		child.addContent(new Element("id").setText("18"));
		child.addContent(new Element("name").setText("project-name"));

		root.addContent(child);
		document.setContent(root);
		return document.getRootElement();
	}
}