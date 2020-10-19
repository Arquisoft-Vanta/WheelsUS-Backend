package App.DataLayer.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import java.sql.Date;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author cesar
 */

@Entity
@Data
@Table(name = "ride")
// JsonIdentityInfo evita que se generen ciclos al leer la BD
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "idRide")

public class RideModel{

    public RideModel(){
    
    }
    
    public RideModel(int idVehicle, LocalDateTime rideStartDatetime, LocalDateTime rideEndDatetime, String rideStartCoordinates, String rideEndCoordinates, int rideCapacity){
    
        this.idVehicle = idVehicle;
        this.rideStartDatetime = rideStartDatetime;
        this.rideEndDatetime = rideEndDatetime;
        this.rideStartCoordinates = rideStartCoordinates;
        this.rideEndCoordinates = rideEndCoordinates;
        this.rideCapacity = rideCapacity;
    }
    
    @Id // Primary key, con autoincremento
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idRide;
    
    @Column(name = "id_vehicle")
    private int idVehicle;
    
    @JsonFormat(pattern = "yyyy-MM-dd@HH:mm:ss")
    private LocalDateTime rideStartDatetime;
    
    @JsonFormat(pattern = "yyyy-MM-dd@HH:mm:ss")
    private LocalDateTime rideEndDatetime;
    
    private String rideStartCoordinates;
    private String rideEndCoordinates;
    private int rideCapacity;  
    
    @ManyToOne
    @JoinColumn( name = "id_vehicle", insertable=false, updatable=false )
    private VehicleModel vehicleModel;
    
}
