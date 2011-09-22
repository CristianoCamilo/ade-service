package br.com.adeservice.controller;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

/**
 * Controller responsible to manage index page.
 * 
 * Sep 21, 2011
 * @author fabio
 *
 */
@Resource
public class IndexController {
	
	private Result result;

	public IndexController(final Result result) {
		this.result = result;
	}
	
	@Get("/")
	public void index(){
		this.result.include("index", "ade-service");
	}
	
	

}
