package com.example;

import static com.jayway.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;

import com.example.domain.Document;
import com.example.domain.Project;
import com.jayway.restassured.http.ContentType;

//This is actually an integration test
public class DocumentControllerTest extends AbstractControllerTest {
 Collection<Project> projects;

 @Before
 public void setupTestDataset() {
	  projects = projectService.getAllProjects();
 }   
 
 @Test
 public void canShowOneDocument() {
	  List<Project> list = new ArrayList<Project>(projects);
    final Document document = list.get(0).getDocument();
    when().get("/document/opeth").
    then().statusCode(HttpStatus.SC_OK).and().contentType(ContentType.JSON).
    and().body("id", equalTo( document.getId() ));
    
 }
 
}