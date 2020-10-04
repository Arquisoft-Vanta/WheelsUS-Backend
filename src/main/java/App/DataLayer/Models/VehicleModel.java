package App.DataLayer.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author cesar
 */
@Entity
@Data
@Table(name = "Vehicle")
// JsonIdentityInfo evita que se generen ciclos al leer la BD
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "idVehicle")

public class VehicleModel{
    
    public VehicleModel(){

    }
    
    public VehicleModel(int vehicleOwner, String vehicleLicenseplate, int vehicleType, String vehicleModel, int vehicleYear, String vehicleColor, LocalDateTime vehicleRegistryDatetime, String vehiclePicture, int vehicleCapacity){
    
        this.vehicleOwner = vehicleOwner;
        this.vehicleLicenseplate = vehicleLicenseplate;
        this.vehicleType = vehicleType;
        this.vehicleModel = vehicleModel;
        this.vehicleYear = vehicleYear;
        this.vehicleColor = vehicleColor;
        this.vehicleRegistryDatetime = vehicleRegistryDatetime;
        this.vehiclePicture = vehiclePicture;
        this.vehicleCapacity = vehicleCapacity;
        
    }
    
    @Id // Primary key, con autoincremento
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idVehicle;
    
    //@Column(name = "abc")
    private int vehicleOwner;
    
    private String vehicleLicenseplate;
    
    private int vehicleType;
    
    private String vehicleModel;
    
    private int vehicleYear;
    
    private String vehicleColor;
    
    @JsonFormat(pattern = "yyyy-MM-dd@HH:mm:ss")
    private LocalDateTime vehicleRegistryDatetime;
    
    private String vehiclePicture;
    
    private int vehicleCapacity;
    
}
