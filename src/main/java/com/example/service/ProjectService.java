package com.example.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.domain.Project;
import com.example.domain.Document;


/**
 * Hard coded simulation of a Service + Data Access Layer.
 */
@Service
public class ProjectService {

	private Map<String, Project> projects;
	private Map<String, Document> documents;

	/**
	 * Constructor populates the 'database' (i.e. Maps) of Projects and Documents.
	 */
	public ProjectService() {

		projects = new HashMap<String, Project>();
		documents = new HashMap<String, Document>();
		
		Document document1 = new Document("opeth", "Opeth");
		Document document2 = new Document("cfrost", "Celtic Frost");
		documents.put(document1.getId(), document1);
		documents.put(document2.getId(), document2);
		
		Project project1 = new Project("1", "Heritage", document1, 2);
		Project project2 = new Project("2", "Deliverance", document1, 3);
		Project project3 = new Project("3", "Pale Communion", document1, 0);
		Project project4 = new Project("3", "Monotheist", document2, 1);
		projects.put(project1.getId(), project1);
		projects.put(project2.getId(), project2);
		projects.put(project3.getId(), project3);
		projects.put(project4.getId(), project4);
		
	}

	public Collection<Project> getAllProjects() {
		return projects.values();
	}

	public Project getProject(final String id) {
		return projects.get(id);
	}

	public Document getDocument(final String id) {
		return documents.get(id);
	}
}