package App.BusinessLayer.Pojo;

import java.sql.Date;
import java.time.LocalDateTime;

public class VehiclePOJO {
    private int idVehicle;

    private int vehicleOwner;

    private String vehicleLicenseplate;

    private int vehicleType;

    private String vehicleModel;

    private int vehicleYear;

    private String vehicleColor;

    private LocalDateTime vehicleRegistryDatetime;

    private String vehiclePicture;

    private int vehicleCapacity;

    private String vehicleBrand;

    private String vehicleServiceType;

    private String vehicleBody;

    private Date vehicleSoatExpiration;

    private int vehicleEngine;

    private String vehicleGasType;

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

    public int getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(int vehicleType) {
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
}
