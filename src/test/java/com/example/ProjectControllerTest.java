package com.example;

import static com.jayway.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;

import com.example.domain.Project;
import com.jayway.restassured.http.ContentType;

//This is actually an integration test
public class ProjectControllerTest extends AbstractControllerTest {
   Collection<Project> projects;

   @Before
   public void setupTestDataset() {
	  projects = projectService.getAllProjects();
   }   
   
   @Test
   public void canShowOneProject() {
	  List<Project> list = new ArrayList<Project>(projects);
      final Project project = list.get(0);
      when().get("/project/1").
      then().statusCode(HttpStatus.SC_OK).and().contentType(ContentType.JSON).
      and().body("title", equalTo( project.getTitle() ));
      
   }
   
   @Test
   public void canShowOneProjectDocument() {
	  List<Project> list = new ArrayList<Project>(projects);
      final Project project = list.get(0);
      when().get("/project/document/1").
      then().statusCode(HttpStatus.SC_OK).and().contentType(ContentType.JSON).
      and().body("title", equalTo( project.getTitle() ));
      
   }
   
}
