package br.com.adeservice.controller;

import static br.com.caelum.vraptor.view.Results.json;
import br.com.adeservice.model.College;
import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;

/**
 * May 4, 2012
 * @author fabio
 *
 */
@Resource
public class CollegeController {
	
	private Result result;
	
	public CollegeController(final Result result) {
		this.result = result;
	}

	@Post @Path("/college")
	@Consumes
	public void add(final College college){
		result.use(json()).from(college.save()).serialize();
		
	}
}
