package App.BusinessLayer.Controllers;

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
public class ExampleControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectmapper;

    public ExampleControllerIT() {
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

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/example").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "[{idExample:1,name:\"Gonzalo Diaz\",city:\"Bogota\",birthday:\"1998-05-07\",hasCreditCard: false},"
                + "{idExample:2,name:\"Cesar Pineda\",city:\"Bogota\",birthday:\"1999-09-11\",hasCreditCard: true}]";
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }

    /**
     * Test of findById method, of class ExampleController.
     */
    @Test
    @Sql("/test-postgres.sql")
    public void testFindById() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/example/1").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "{idExample:1,name:\"Gonzalo Diaz\",city:\"Bogota\",birthday:\"1998-05-07\",hasCreditCard: false}";
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }

    /**
     * Test of create method, of class ExampleController.
     */
    @Test
    @Sql("/drop-tables.sql")
    public void testCreate() throws Exception {
        String exampleJson = "{\"name\":\"Sebastian Reina\",\"city\":\"Cali\",\"birthday\":\"2020-09-30\",\"hasCreditCard\": true}";
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
    @Sql("/test-postgres.sql")
    public void testUpdate() throws Exception {
        String exampleJson = "{\"idExample\":1,\"name\":\"Gonzalo Diaz\",\"city\":\"Berlin\",\"birthday\":\"2020-09-30\",\"hasCreditCard\": true}";
        String expected = "{idExample:1,name:\"Gonzalo Diaz\",city:\"Berlin\",birthday:\"2020-09-30\",hasCreditCard: true}";
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/example").with(csrf())
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
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/example/1").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
    }
}
