package App.BusinessLayer.Controllers;

import App.BusinessLayer.Pojo.RidePOJO;
import App.BusinessLayer.Pojo.UserPOJO;
import App.BusinessLayer.Services.RideService;
import App.DataLayer.Models.RideModel;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityNotFoundException;

import App.DataLayer.Models.UserModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author cesar
 */

@RestController
// RequestMapping atiende las peticiones en la ruta dada por parametro
@RequestMapping("/api/ride")
// CrossOrigin permite el acceso desde paginas web diferentes a localhost
// Por ser entorno de pruebas se le da acceso a cualquier pagina web externa
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})

public class RideController {
    
    Logger logger = LoggerFactory.getLogger(UserController.class);
    
    // Autowired asigna un objeto a la instancia en el momento en el que
    // sea requerido

    @Autowired
    private RideService rideService;

    public RideModel fillModel(RidePOJO ridePOJO){
        RideModel ride = new RideModel();
        ride.setIdVehicle(ridePOJO.getIdVehicle());
        ride.setRideStartDatetime(ridePOJO.getRideStartDatetime());
        ride.setRideEndDatetime(ridePOJO.getRideEndDatetime());
        ride.setRideStartCoordinates(ridePOJO.getRideStartCoordinates());
        ride.setRideEndCoordinates(ridePOJO.getRideEndCoordinates());
        ride.setRideCapacity(ridePOJO.getRideCapacity());
        return ride;
    }

    public RidePOJO fillPojo(RideModel rideModel){
        RidePOJO ride = new RidePOJO();
        ride.setIdVehicle(rideModel.getIdVehicle());
        ride.setRideStartDatetime(rideModel.getRideStartDatetime());
        ride.setRideEndDatetime(rideModel.getRideEndDatetime());
        ride.setRideStartCoordinates(rideModel.getRideStartCoordinates());
        ride.setRideEndCoordinates(rideModel.getRideEndCoordinates());
        ride.setRideCapacity(rideModel.getRideCapacity());
        return ride;
    }

    // GetMapping obtiene valores en una sub ruta dada como parametro
    @GetMapping
    public List<RidePOJO> findAll() {
        List<RidePOJO> rides = new ArrayList<>();
        List<RideModel> ridesModels = rideService.findAll();
        for (RideModel ride:ridesModels) {
            rides.add(fillPojo(ride));
        }
        return rides;
    }

    // GetMapping obtiene valores en una sub ruta dada como parametro
    @GetMapping("/{id}")
    public ResponseEntity<RidePOJO> findById(@PathVariable int id) {
        try {
            return ResponseEntity.ok(fillPojo(rideService.findById(id)));
        } catch (JsonParseException e) {
            logger.error(HttpStatus.BAD_REQUEST.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (EntityNotFoundException e) {
            logger.error(HttpStatus.NOT_FOUND.toString());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }

    }

    // PostMapping hace una peticion post a la ruta del controlador
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody RidePOJO ridePOJO) {
        try {
            rideService.save(fillModel(ridePOJO));
            logger.trace(HttpStatus.CREATED.toString());
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error(HttpStatus.BAD_REQUEST.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // PutMapping hace una peticion put a la ruta del controlador
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody RidePOJO ridePOJO) {
        try {
            // Busqueda de prueba para saber si el registro ya existe
            RideModel rideModel1 = rideService.findById(ridePOJO.getIdRide());
            logger.trace(HttpStatus.CREATED.toString());
            return new ResponseEntity<>(HttpStatus.CREATED);

        } catch (JsonParseException e) {
            logger.error(HttpStatus.BAD_REQUEST.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (EntityNotFoundException e) {
            logger.error(HttpStatus.NOT_FOUND.toString());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
    }

    // DeleteMapping hace una peticion delete a la ruta del controlador
    @DeleteMapping("/{id}")
    public ResponseEntity<RideModel> deleteById(@PathVariable int id) {

        try {
            rideService.deleteById(id);
            logger.trace(HttpStatus.OK.toString());
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (EmptyResultDataAccessException e) {
            logger.error(HttpStatus.NOT_FOUND.toString());
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (JsonParseException e) {
            logger.error(HttpStatus.BAD_REQUEST.toString());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
    
}
