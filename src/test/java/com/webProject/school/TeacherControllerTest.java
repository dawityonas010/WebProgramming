package com.webProject.school;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.webProject.school.controllers.HomeController;
import com.webProject.school.controllers.TeacherController;

@RunWith(SpringRunner.class)
@WebMvcTest(TeacherController.class)   
public class TeacherControllerTest {

  @Autowired
  private MockMvc mockMvc;   

  @Test
  public void testHomePage() throws Exception {
    mockMvc.perform(get("/teacher/home"))   
    
      .andExpect(status().isOk())  
      
      .andExpect(view().name("post_results"))  
      
      .andExpect(content().string(           
          containsString("Ethio's Future High")));  
  }

}

