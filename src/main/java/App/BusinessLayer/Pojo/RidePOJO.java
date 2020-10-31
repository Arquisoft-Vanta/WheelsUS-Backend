package App.BusinessLayer.Pojo;

import java.time.LocalDateTime;

public class RidePOJO {
    private int idRide;
    private int idVehicle;
    private LocalDateTime rideStartDatetime;
    private LocalDateTime rideEndDatetime;
    private String rideStartCoordinates;
    private String rideEndCoordinates;
    private int rideCapacity;

    public RidePOJO(int idVehicle, LocalDateTime rideStartDatetime,
                    LocalDateTime rideEndDatetime,
                    String rideStartCoordinates, String rideEndCoordinates,
                    int rideCapacity) {
        this.idVehicle = idVehicle;
        this.rideStartDatetime = rideStartDatetime;
        this.rideEndDatetime = rideEndDatetime;
        this.rideStartCoordinates = rideStartCoordinates;
        this.rideEndCoordinates = rideEndCoordinates;
        this.rideCapacity = rideCapacity;
    }

    public RidePOJO() {

    }

    public int getIdRide() {
        return idRide;
    }

    public void setIdRide(int idRide) {
        this.idRide = idRide;
    }

    public int getIdVehicle() {
        return idVehicle;
    }

    public void setIdVehicle(int idVehicle) {
        this.idVehicle = idVehicle;
    }

    public LocalDateTime getRideStartDatetime() {
        return rideStartDatetime;
    }

    public void setRideStartDatetime(LocalDateTime rideStartDatetime) {
        this.rideStartDatetime = rideStartDatetime;
    }

    public LocalDateTime getRideEndDatetime() {
        return rideEndDatetime;
    }

    public void setRideEndDatetime(LocalDateTime rideEndDatetime) {
        this.rideEndDatetime = rideEndDatetime;
    }

    public String getRideStartCoordinates() {
        return rideStartCoordinates;
    }

    public void setRideStartCoordinates(String rideStartCoordinates) {
        this.rideStartCoordinates = rideStartCoordinates;
    }

    public String getRideEndCoordinates() {
        return rideEndCoordinates;
    }

    public void setRideEndCoordinates(String rideEndCoordinates) {
        this.rideEndCoordinates = rideEndCoordinates;
    }

    public int getRideCapacity() {
        return rideCapacity;
    }

    public void setRideCapacity(int rideCapacity) {
        this.rideCapacity = rideCapacity;
    }
}
