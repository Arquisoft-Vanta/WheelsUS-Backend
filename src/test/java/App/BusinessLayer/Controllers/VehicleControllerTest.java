/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App.BusinessLayer.Controllers;

import App.BusinessLayer.Services.VehicleService;
import App.DataLayer.Models.VehicleModel;

import java.sql.Date;
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

/**
 * @author gonza
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = VehicleController.class)
@WithMockUser
public class VehicleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private VehicleService vehicleService;

    VehicleModel mockVehicleModel = new VehicleModel(1, 1, "ABC123", 2,
                                                     "Sedan", 2010, "Azul",
                                                     LocalDateTime.parse(
                                                             "2020-09-30T10" +
                                                                     ":11:30"), "imagen", 3, "Renault", "Particular", "Camioneta", Date.valueOf("2021-10-05"), 1000, "Diesel");
    VehicleModel mockVehicleModel1 = new VehicleModel(1, 1, "CJK895", 2,
                                                      "Sedan", 2020, "Azul",
                                                      LocalDateTime.parse(
                                                              "2020-09-30T10" +
                                                                      ":11:30"
                                                      ), "imagen", 2,
                                                      "Chevrolet",
                                                      "Particular",
                                                      "Camioneta",
                                                      Date.valueOf("2021-10-05"), 1000, "Diesel");

    public VehicleControllerTest() {
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
        list.add(mockVehicleModel);
        Mockito.when(vehicleService.findAll()).thenReturn(list);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/vehicle").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "[{idVehicle:1,vehicleOwner:1," +
                "vehicleLicenseplate:\"ABC123\",vehicleType:2," +
                "vehicleModel:\"Sedan\",vehicleYear:2010," +
                "vehicleColor:\"Azul\",vehicleRegistryDatetime:\"2020-09-30" +
                "@10:11:30\",vehiclePicture:\"imagen\",vehicleCapacity:3}]";
        JSONAssert.assertEquals(expected,
                                result.getResponse().getContentAsString(),
                                false);
    }

    /**
     * Test of findById method, of class ExampleController.
     */
    @Test
    public void testFindById() throws Exception {

        Mockito.when(vehicleService.findById(Mockito.anyInt())).thenReturn(mockVehicleModel);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/vehicle/1").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "{idVehicle:1,vehicleOwner:1," +
                "vehicleLicenseplate:\"ABC123\",vehicleType:2," +
                "vehicleModel:\"Sedan\",vehicleYear:2010," +
                "vehicleColor:\"Azul\",vehicleRegistryDatetime:\"2020-09-30" +
                "@10:11:30\",vehiclePicture:\"imagen\",vehicleCapacity:3}";
        JSONAssert.assertEquals(expected,
                                result.getResponse().getContentAsString(),
                                false);
    }

    /**
     * Test of create method, of class ExampleController.
     */
    @Test
    public void testCreate() throws Exception {
        String exampleJson = "{\"vehicleOwner\":1," +
                "\"vehicleLicenseplate\":\"ABC123\",\"vehicleType\":2," +
                "\"vehicleModel\":\"Sedan\",\"vehicleYear\":2010," +
                "\"vehicleColor\":\"Azul\"," +
                "\"vehicleRegistryDatetime\":\"2020-09-30@10:11:30\"," +
                "\"vehiclePicture\":\"imagen\",\"vehicleCapacity\":3}";
        Mockito.when(vehicleService.save(Mockito.any(VehicleModel.class))).thenReturn(mockVehicleModel);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/vehicle").with(csrf()).accept(MediaType.APPLICATION_JSON).content(exampleJson).contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        assertEquals(HttpStatus.CREATED.value(),
                     result.getResponse().getStatus());

    }

    /**
     * Test of update method, of class ExampleController.
     */
    @Test
    public void testUpdate() throws Exception {
        String exampleJson = "{\"idVehicle\":1,\"vehicleOwner\":1," +
                "\"vehicleLicenseplate\":\"UPJ420\",\"vehicleType\":2," +
                "\"vehicleModel\":\"Sedan\",\"vehicleYear\":2010," +
                "\"vehicleColor\":\"Azul\"," +
                "\"vehicleRegistryDatetime\":\"2020-09-30@10:11:30\"," +
                "\"vehiclePicture\":\"imagen\",\"vehicleCapacity\":3}";
        Mockito.when(vehicleService.save(Mockito.any(VehicleModel.class))).thenReturn(mockVehicleModel1);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/vehicle").with(csrf()).accept(MediaType.APPLICATION_JSON).content(exampleJson).contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        assertEquals(HttpStatus.CREATED.value(),
                     result.getResponse().getStatus());
    }

    /**
     * Test of deleteById method, of class ExampleController.
     */
    @Test
    public void testDeleteById() throws Exception {
        Mockito.doThrow(new IllegalArgumentException()).when(vehicleService).deleteById(Mockito.anyInt());
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/vehicle/1").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
    }

}
