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
    
    public VehicleModel(int vehicleOwner, String vehicleLicenseplate, String vehicleType, String vehicleModel, int vehicleYear, String vehicleColor, LocalDateTime vehicleRegistryDatetime, String vehiclePicture, int vehicleCapacity, String vehicleBrand, String vehicleServiceType, String vehicleBody, Date vehicleSoatExpiration, int vehicleEngine, String vehicleGasType){
    
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
    
    public VehicleModel(int idVehicle, int vehicleOwner, String vehicleLicenseplate, String vehicleType, String vehicleModel, int vehicleYear, String vehicleColor, LocalDateTime vehicleRegistryDatetime, String vehiclePicture, int vehicleCapacity, String vehicleBrand, String vehicleServiceType, String vehicleBody, Date vehicleSoatExpiration, int vehicleEngine, String vehicleGasType){
        
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
    
    private String vehicleType;
    
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

    public int getIdVehicle() {
        return idVehicle;
    }

    public void setIdVehicle(int idVehicle) {
        this.idVehicle = idVehicle;
    }

    public int getVehicleOwner() {
        return vehicleOwner;
    }

    public void setVehicleOwner(int vehicleOwner) {
        this.vehicleOwner = vehicleOwner;
    }

    public String getVehicleLicenseplate() {
        return vehicleLicenseplate;
    }

    public void setVehicleLicenseplate(String vehicleLicenseplate) {
        this.vehicleLicenseplate = vehicleLicenseplate;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public int getVehicleYear() {
        return vehicleYear;
    }

    public void setVehicleYear(int vehicleYear) {
        this.vehicleYear = vehicleYear;
    }

    public String getVehicleColor() {
        return vehicleColor;
    }

    public void setVehicleColor(String vehicleColor) {
        this.vehicleColor = vehicleColor;
    }

    public LocalDateTime getVehicleRegistryDatetime() {
        return vehicleRegistryDatetime;
    }

    public void setVehicleRegistryDatetime(LocalDateTime vehicleRegistryDatetime) {
        this.vehicleRegistryDatetime = vehicleRegistryDatetime;
    }

    public String getVehiclePicture() {
        return vehiclePicture;
    }

    public void setVehiclePicture(String vehiclePicture) {
        this.vehiclePicture = vehiclePicture;
    }

    public int getVehicleCapacity() {
        return vehicleCapacity;
    }

    public void setVehicleCapacity(int vehicleCapacity) {
        this.vehicleCapacity = vehicleCapacity;
    }

    public String getVehicleBrand() {
        return vehicleBrand;
    }

    public void setVehicleBrand(String vehicleBrand) {
        this.vehicleBrand = vehicleBrand;
    }

    public String getVehicleServiceType() {
        return vehicleServiceType;
    }

    public void setVehicleServiceType(String vehicleServiceType) {
        this.vehicleServiceType = vehicleServiceType;
    }

    public String getVehicleBody() {
        return vehicleBody;
    }

    public void setVehicleBody(String vehicleBody) {
        this.vehicleBody = vehicleBody;
    }

    public Date getVehicleSoatExpiration() {
        return vehicleSoatExpiration;
    }

    public void setVehicleSoatExpiration(Date vehicleSoatExpiration) {
        this.vehicleSoatExpiration = vehicleSoatExpiration;
    }

    public int getVehicleEngine() {
        return vehicleEngine;
    }

    public void setVehicleEngine(int vehicleEngine) {
        this.vehicleEngine = vehicleEngine;
    }

    public String getVehicleGasType() {
        return vehicleGasType;
    }

    public void setVehicleGasType(String vehicleGasType) {
        this.vehicleGasType = vehicleGasType;
    }

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }
}