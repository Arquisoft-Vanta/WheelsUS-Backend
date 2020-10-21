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
import java.sql.Date;
import java.util.List;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author cesar
 */
@Entity
@Data
@Table(name = "vehicle")
// JsonIdentityInfo evita que se generen ciclos al leer la BD
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "idVehicle")

public class VehicleModel{
    
    public VehicleModel(){

    }
    
    public VehicleModel(int vehicleOwner, String vehicleLicenseplate, int vehicleType, String vehicleModel, int vehicleYear, String vehicleColor, LocalDateTime vehicleRegistryDatetime, String vehiclePicture, int vehicleCapacity, String vehicleBrand, String vehicleServiceType, String vehicleBody, Date vehicleSoatExpiration, int vehicleEngine, String vehicleGasType){
    
        this.vehicleOwner = vehicleOwner;
        this.vehicleLicenseplate = vehicleLicenseplate;
        this.vehicleType = vehicleType;
        this.vehicleModel = vehicleModel;
        this.vehicleYear = vehicleYear;
        this.vehicleColor = vehicleColor;
        this.vehicleRegistryDatetime = vehicleRegistryDatetime;
        this.vehiclePicture = vehiclePicture;
        this.vehicleCapacity = vehicleCapacity;
        this.vehicleBrand = vehicleBrand;
        this.vehicleServiceType = vehicleServiceType;
        this.vehicleBody = vehicleBody;
        this.vehicleSoatExpiration = vehicleSoatExpiration;
        this.vehicleEngine = vehicleEngine;
        this.vehicleGasType = vehicleGasType;
        
    }
    
    public VehicleModel(int idVehicle, int vehicleOwner, String vehicleLicenseplate, int vehicleType, String vehicleModel, int vehicleYear, String vehicleColor, LocalDateTime vehicleRegistryDatetime, String vehiclePicture, int vehicleCapacity, String vehicleBrand, String vehicleServiceType, String vehicleBody, Date vehicleSoatExpiration, int vehicleEngine, String vehicleGasType){
        
        this.vehicleOwner = vehicleOwner;
        this.vehicleLicenseplate = vehicleLicenseplate;
        this.vehicleType = vehicleType;
        this.vehicleModel = vehicleModel;
        this.vehicleYear = vehicleYear;
        this.vehicleColor = vehicleColor;
        this.vehicleRegistryDatetime = vehicleRegistryDatetime;
        this.vehiclePicture = vehiclePicture;
        this.vehicleCapacity = vehicleCapacity;
        this.vehicleBrand = vehicleBrand;
        this.vehicleServiceType = vehicleServiceType;
        this.vehicleBody = vehicleBody;
        this.vehicleSoatExpiration = vehicleSoatExpiration;
        this.vehicleEngine = vehicleEngine;
        this.vehicleGasType = vehicleGasType;
        
    }
    
    @Id // Primary key, con autoincremento
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idVehicle;
 
    @Column(name = "vehicle_owner")
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
    
    private String vehicleBrand;
    
    private String vehicleServiceType;
    
    private String vehicleBody;
    
    private Date vehicleSoatExpiration;
    
    private int vehicleEngine;
    
    private String vehicleGasType;
    
    @ManyToOne
    @JoinColumn( name = "vehicle_owner", insertable=false, updatable=false  )
    private UserModel userModel;
    
    @OneToMany( mappedBy = "idVehicle" )
    private List<RideModel> rideModel;
}