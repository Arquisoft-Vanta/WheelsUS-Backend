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

public class VehicleControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectmapper;

    public VehicleControllerIT() {
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

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/vehicle").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "[{idVehicle:1,vehicleOwner:1,vehicleLicenseplate:\"ABC123\",vehicleType:2,vehicleModel:\"Sedan\",vehicleYear:2010,vehicleColor:\"Azul\",vehicleRegistryDatetime:\"2020-09-30@10:11:30\",vehiclePicture:\"imagen\",vehicleCapacity:3},"
                + "{idVehicle:2,vehicleOwner:1,vehicleLicenseplate:\"RMN741\",vehicleType:2,vehicleModel:\"Sedan\",vehicleYear:2020,vehicleColor:\"Rojo\",vehicleRegistryDatetime:\"2020-09-30@10:11:30\",vehiclePicture:\"imagen\",vehicleCapacity:3}]";
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }

    /**
     * Test of findById method, of class ExampleController.
     */
    @Test
    @Sql("/test-postgres.sql")
    public void testFindById() throws Exception {

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/vehicle/1").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "{idVehicle:1,vehicleOwner:1,vehicleLicenseplate:\"ABC123\",vehicleType:2,vehicleModel:\"Sedan\",vehicleYear:2010,vehicleColor:\"Azul\",vehicleRegistryDatetime:\"2020-09-30@10:11:30\",vehiclePicture:\"imagen\",vehicleCapacity:3}";
        JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }

    /**
     * Test of create method, of class ExampleController.
     */
    @Test
    @Sql("/drop-tables.sql")
    public void testCreate() throws Exception {
        String exampleJson = "{\"vehicleOwner\":1,\"vehicleLicenseplate\":\"ABC123\",\"vehicleType\":2,\"vehicleModel\":\"Sedan\",\"vehicleYear\":2010,\"vehicleColor\":\"Azul\",\"vehicleRegistryDatetime\":\"2020-09-30@10:11:30\",\"vehiclePicture\":\"imagen\",\"vehicleCapacity\":3}";
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/api/vehicle").with(csrf())
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
        String exampleJson = "{\"idVehicle\":1,\"vehicleOwner\":1,\"vehicleLicenseplate\":\"ABC123\",\"vehicleType\":2,\"vehicleModel\":\"Camioneta\",\"vehicleYear\":2010,\"vehicleColor\":\"Amarillo\",\"vehicleRegistryDatetime\":\"2020-09-30@10:11:30\",\"vehiclePicture\":\"imagen\",\"vehicleCapacity\":3}";
        String expected = "{idVehicle:1,vehicleOwner:1,vehicleLicenseplate:\"ABC123\",vehicleType:2,vehicleModel:\"Camioneta\",vehicleYear:2010,vehicleColor:\"Amarillo\",vehicleRegistryDatetime:\"2020-09-30@10:11:30\",vehiclePicture:\"imagen\",vehicleCapacity:3}";
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/api/vehicle").with(csrf())
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
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/vehicle/1").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
    }
}
