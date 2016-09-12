package com.example;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.service.ProjectService;
import com.jayway.restassured.RestAssured;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoApplication.class)
@WebIntegrationTest("server.port=0") // Use a random free port
@DirtiesContext // Avoid Spring caching contexts
public abstract class AbstractControllerTest {

   @Value("${local.server.port}")
   int port;
   
   @Autowired
   ProjectService projectService;
  
   @Before
   public void setUp() {
      RestAssured.port = port;
   }   
   
}
