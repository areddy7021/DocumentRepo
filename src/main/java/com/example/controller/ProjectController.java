package com.example.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.domain.Project;
import com.example.service.ProjectService;

@Controller
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;

	@RequestMapping(value = "/projects", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Collection<Resource<Project>> getAllProjects() {
		Collection<Project> projects = projectService.getAllProjects();
		List<Resource<Project>> resources = new ArrayList<Resource<Project>>();
		for (Project album : projects) {
			resources.add(getProjectResource(album));
		}
		return resources;
		
	}

	@RequestMapping(value = "/project/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Resource<Project> getProject(@PathVariable(value = "id") String id) {
		Project album = projectService.getProject(id);
		return getProjectResource(album);

	}

	private Resource<Project> getProjectResource(Project project) {
		Resource<Project> resource = new Resource<Project>(project);
		// Link to Project
		resource.add(linkTo(methodOn(ProjectController.class).getProject(project.getId())).withSelfRel());
		// Link to Document
		resource.add(linkTo(methodOn(DocumentController.class).getDocument(project.getDocument().getId())).withRel("artist"));
		if (project.getStockLevel() > 0) {
			resource.add(linkTo(methodOn(ProjectController.class).getProjectDocumentById(project.getId())).withRel("album.purchase"));
		}

		return resource;

	}

	@RequestMapping(value = "/project/document/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Resource<Project> getProjectDocumentById(@PathVariable(value = "id") String id) {
		
		Project a = projectService.getProject(id);
		a.setStockLevel(a.getStockLevel() - 1);
		Resource<Project> resource = new Resource<Project>(a);
		resource.add(linkTo(methodOn(ProjectController.class).getProject(id)).withSelfRel());
		return resource;
		
	}
}
