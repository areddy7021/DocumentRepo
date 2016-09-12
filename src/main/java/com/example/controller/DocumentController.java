package com.example.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.domain.Document;
import com.example.service.ProjectService;

@Controller
public class DocumentController {
	@Autowired
	private ProjectService projectService;

	@RequestMapping(value = "/document/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Resource<Document> getDocument(@PathVariable(value = "id") String id) {
		Document a = projectService.getDocument(id);
		Resource<Document> resource = new Resource<Document>(a);
		resource.add(linkTo(methodOn(DocumentController.class).getDocument(id)).withSelfRel());
		return resource;
	}
}