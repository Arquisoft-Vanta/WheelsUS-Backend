/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App.BusinessLayer.Controllers;

import App.DataLayer.Models.VehicleModel;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author gonza
 */
public class VehicleControllerTest {
    
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
     * Test of findAll method, of class VehicleController.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        VehicleController instance = new VehicleController();
        List<VehicleModel> expResult = null;
        List<VehicleModel> result = instance.findAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findById method, of class VehicleController.
     */
    @Test
    public void testFindById() {
        System.out.println("findById");
        int id = 0;
        VehicleController instance = new VehicleController();
        ResponseEntity<VehicleModel> expResult = null;
        ResponseEntity<VehicleModel> result = instance.findById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class VehicleController.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        VehicleModel vehicleModel = null;
        VehicleController instance = new VehicleController();
        ResponseEntity<VehicleModel> expResult = null;
        ResponseEntity<VehicleModel> result = instance.create(vehicleModel);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class VehicleController.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        VehicleModel vehicleModel = null;
        VehicleController instance = new VehicleController();
        ResponseEntity<VehicleModel> expResult = null;
        ResponseEntity<VehicleModel> result = instance.update(vehicleModel);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteById method, of class VehicleController.
     */
    @Test
    public void testDeleteById() {
        System.out.println("deleteById");
        int id = 0;
        VehicleController instance = new VehicleController();
        ResponseEntity<VehicleModel> expResult = null;
        ResponseEntity<VehicleModel> result = instance.deleteById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
