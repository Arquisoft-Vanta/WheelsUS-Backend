/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App.BusinessLayer.Controllers;

/**
 *
 * @author crist
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:test.properties")
@AutoConfigureMockMvc


public class UserControllerIT {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectmapper;

    public UserControllerIT() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of findAll method, of class ExampleController.
     */
    @Test
    @Sql("/test-postgres.sql")
    public void testFindAll() throws Exception {

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/users").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "[{idUser:1,name:\"Cristian\",document:\"123456789\",phone:\"7777\",userUniversity:\"U nacional\",mail:\"cesaineam\",address:\"en bogota\",password:\"el pass\",registryDatatime:\"2020-09-30@10:11:30\",rh:\"0-\"},"
                + "{idUser:2,name:\"Esteban\",document:\"987654321\",phone:\"9999\",userUniversity:\"U nacional\",mail:\"cesteban\",address:\"en bogota1\",password:\"el pass1\",registryDatatime:\"2020-09-30@10:11:50\",rh:\"0+\"}]";
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }

    /**
     * Test of findById method, of class ExampleController.
     */
    @Test
    @Sql("/test-postgres.sql")
    public void testFindById() throws Exception {

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/users/1").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "{idUser:1,name:\"Cristian\",document:\"123456789\",phone:\"7777\",userUniversity:\"U nacional\",mail:\"cesaineam\",address:\"en bogota\",password:\"el pass\",registryDatatime:\"2020-09-30@10:11:30\",rh:\"0-\"}";
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }

    /**
     * Test of create method, of class ExampleController.
     */
    @Test
    @Sql("/drop-tables.sql")
    public void testCreate() throws Exception {
        String exampleJson = "{\"name\":\"Cristian\",\"document\":\"123456789\",\"phone\":\"7777\",\"userUniversity\":\"U nacional\",\"mail\":\"cesaineam\",\"address\":\"en bogota\",\"password\":\"el pass\",\"registryDatatime\":\"2020-09-30@10:11:30\",\"rh\":\"0-\"}";
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/api/users").with(csrf())
                .accept(MediaType.APPLICATION_JSON)
                .content(exampleJson)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        assertEquals(HttpStatus.CREATED.value(), result.getResponse().getStatus());

    }

    /**
     * Test of update method, of class ExampleController.
     */
    @Test
    @Sql("/test-postgres.sql")
    public void testUpdate() throws Exception {
        String exampleJson = "{\"idUser\":1,\"name\":\"Cristian\",\"document\":\"123456789\",\"phone\":\"7777\",\"userUniversity\":\"U nacional\",\"mail\":\"cesaineam\",\"address\":\"en bogota\",\"password\":\"el pass\",\"registryDatatime\":\"2020-09-30@10:11:30\",\"rh\":\"0-\"}";
        String expected = "{idUser:1,name:\"Cristian\",document:\"123456789\",phone:\"7777\",userUniversity:\"U nacional\",mail:\"cesaineam\",address:\"en bogota\",password:\"el pass\",registryDatatime:\"2020-09-30@10:11:30\",rh:\"0-\"}";
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/api/users").with(csrf())
                .accept(MediaType.APPLICATION_JSON)
                .content(exampleJson)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        assertEquals(HttpStatus.CREATED.value(), result.getResponse().getStatus());
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);

    }

    /**
     * Test of deleteById method, of class ExampleController.
     */
    @Test
    @Sql("/test-postgres.sql")
    public void testDeleteById() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/users/1").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
    }
    
}
