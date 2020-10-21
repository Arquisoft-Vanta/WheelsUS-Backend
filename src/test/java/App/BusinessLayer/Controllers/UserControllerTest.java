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

import App.BusinessLayer.Services.UserService;
import App.BusinessLayer.Services.VehicleService;
import App.DataLayer.Models.UserModel;
import App.DataLayer.Models.VehicleModel;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


@RunWith(SpringRunner.class)
@WebMvcTest(value = UserController.class)
@WithMockUser
public class UserControllerTest {
    
     @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;
/*
    UserModel mockUserModel = new UserModel("Cristian","123456789","7777","U nacional","cesaineam","en bogota", "el pass", LocalDateTime.parse("2020-09-30T10:11:30"),"0-" );
    UserModel mockUserModel1 = new UserModel("Esteban","987654321","9999","U nacional","cesteban","en bogota1", "el pass1", LocalDateTime.parse("2020-09-30T10:11:50"),"0+");
*/
    public UserControllerTest() {
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
 /*       List list = new ArrayList();
        list.add(mockUserModel);
        Mockito.when(userService.findAll()).thenReturn(list);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/users").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "[{idUser:0,name:\"Cristian\",document:\"123456789\",phone:\"7777\",userUniversity:\"U nacional\",mail:\"cesaineam\",address:\"en bogota\",password:\"el pass\",registryDatatime:\"2020-09-30@10:11:30\",rh:\"0-\"}]";
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
   */ }

    /**
     * Test of findById method, of class ExampleController.
     */
    @Test
    public void testFindById() throws Exception {
/*
        Mockito.when(userService.findById(Mockito.anyInt())).thenReturn(mockUserModel);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/users/1").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "{idUser:0,name:\"Cristian\",document:\"123456789\",phone:\"7777\",userUniversity:\"U nacional\",mail:\"cesaineam\",address:\"en bogota\",password:\"el pass\",registryDatatime:\"2020-09-30@10:11:30\",rh:\"0-\"}";
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
*/  }

    /**
     * Test of create method, of class ExampleController.
     */
    @Test
    public void testCreate() throws Exception {
/*        String exampleJson = "{\"name\":\"Cristian\"," +
                "\"document\":\"123456789\",\"phone\":\"7777\",\"userUniversity\":\"U nacional\",\"mail\":\"cesaineam\",\"address\":\"en bogota\",\"password\":\"el pass\",\"registryDatatime\":\"2020-09-30@10:11:30\",\"rh\":\"0-\"}";
        Mockito.when(userService.save(Mockito.any(UserModel.class))).thenReturn(mockUserModel);
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/api/users").with(csrf())
                .accept(MediaType.APPLICATION_JSON)
                .content(exampleJson)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        assertEquals(HttpStatus.CREATED.value(), result.getResponse().getStatus());
*/
    }

    /**
     * Test of update method, of class ExampleController.
     */
    @Test
    public void testUpdate() throws Exception {
 /*       String exampleJson = "{\"idUser\":1,\"name\":\"Cristian\"," +
                "\"document\":\"123456789\",\"phone\":\"7777\",\"userUniversity\":\"U nacional\",\"mail\":\"cesaineam\",\"address\":\"en bogota\",\"password\":\"el pass\",\"registryDatatime\":\"2020-09-30@10:11:30\",\"rh\":\"0-\"}";
        Mockito.when(userService.save(Mockito.any(UserModel.class))).thenReturn(mockUserModel1);
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/api/users").with(csrf())
                .accept(MediaType.APPLICATION_JSON)
                .content(exampleJson)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        assertEquals(HttpStatus.CREATED.value(), result.getResponse().getStatus());
   */ }

    /**
     * Test of deleteById method, of class ExampleController.
     */
    @Test
    public void testDeleteById() throws Exception {
      /*  Mockito.doThrow(new IllegalArgumentException()).when(userService)
      .deleteById(Mockito.anyInt());

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/users/1").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
    */}
    
}
