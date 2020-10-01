/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App.BusinessLayer.Controllers;

import App.BusinessLayer.Services.ExampleService;
import App.DataLayer.Models.ExampleModel;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.context.support.WithMockUser;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 *
 * @author gonza
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = ExampleController.class)
@WithMockUser
public class ExampleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ExampleService exampleService;

    ExampleModel mockExampleModel = new ExampleModel(1, "Gonzalo Diaz", "Bogota", LocalDate.parse("2020-09-30"), true);
    ExampleModel mockExampleModel1 = new ExampleModel(1, "Gonzalo Diaz", "Medellin", LocalDate.parse("2020-09-30"), true);

    public ExampleControllerTest() {
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
    public void testFindAll() throws Exception {
        List list = new ArrayList();
        list.add(mockExampleModel);
        Mockito.when(exampleService.findAll()).thenReturn(list);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/example").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        System.out.println("---------------------------------------------------------------------------");
        System.out.println(result.getResponse().getContentAsString());
        String expected = "[{idExample:1,name:\"Gonzalo Diaz\",city:\"Bogota\",birthday:\"2020-09-30\",hasCreditCard: true}]";
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }

    /**
     * Test of findById method, of class ExampleController.
     */
    @Test
    public void testFindById() throws Exception {

        Mockito.when(exampleService.findById(Mockito.anyInt())).thenReturn(mockExampleModel);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/example/1").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        System.out.println("---------------------------------------------------------------------------");
        System.out.println(result.getResponse().getContentAsString());
        String expected = "{idExample:1,name:\"Gonzalo Diaz\",city:\"Bogota\",birthday:\"2020-09-30\",hasCreditCard: true}";
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }

    /**
     * Test of create method, of class ExampleController.
     */
    @Test
    public void testCreate() throws Exception {
        String exampleJson = "{\"name\":\"Gonzalo Diaz\",\"city\":\"Bogota\",\"birthday\":\"2020-09-30\",\"hasCreditCard\": true}";
        Mockito.when(exampleService.save(Mockito.any(ExampleModel.class))).thenReturn(mockExampleModel);
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/example").with(csrf())
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
    public void testUpdate() throws Exception {
        String exampleJson = "{\"name\":\"Gonzalo Diaz\",\"city\":\"Medellin\",\"birthday\":\"2020-09-30\",\"hasCreditCard\": true}";
        Mockito.when(exampleService.save(Mockito.any(ExampleModel.class))).thenReturn(mockExampleModel1);
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/example").with(csrf())
                .accept(MediaType.APPLICATION_JSON)
                .content(exampleJson)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        assertEquals(HttpStatus.CREATED.value(), result.getResponse().getStatus());
    }

    /**
     * Test of deleteById method, of class ExampleController.
     */
    @Test
    public void testDeleteById() throws Exception {
        Mockito.doThrow(new IllegalArgumentException()).when(exampleService).deleteById(Mockito.anyInt());
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/example/1").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        System.out.println("---------------------------------------------------------------------------");
        System.out.println(result.getResponse().getContentAsString());
        String expected = "{idExample:1,name:\"Gonzalo Diaz\",city:\"Bogota\",birthday:\"2020-09-30\",hasCreditCard: true}";
        assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
    }

}
