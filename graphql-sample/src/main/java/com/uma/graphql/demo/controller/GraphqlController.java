package com.uma.graphql.demo.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class GraphqlController {

	  @RequestMapping(value = "/graphiql/domain", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
	    public ModelAndView indexAnnotation() {
	        return new ModelAndView("/index-domain");
	    }
	    
	    @RequestMapping(value = "/graphiql", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
	    public ModelAndView indexDomain() {
	        return new ModelAndView("/index-annotation");
	    }
	    
	    @RequestMapping(value = "/workspace", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
	    public ModelAndView workspace() {
	        return new ModelAndView("/workspace");
	    }
}
