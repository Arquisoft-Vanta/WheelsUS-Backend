package App.BusinessLayer.Pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class FavoriteDirectionPOJO {

    private int idFavoriteDirection;

    private String favLatitude;

    private String favLongitude;

    private String favAddress;

    @JsonFormat(pattern = "yyyy-MM-dd@HH:mm:ss")
    private LocalDateTime datetimeCreationFav;

    private String nameFd;


    public String getFavLatitude() {
        return favLatitude;
    }

    public void setFavLatitude(String favLatitude) {
        this.favLatitude = favLatitude;
    }

    public String getFavLongitude() {
        return favLongitude;
    }

    public void setFavLongitude(String favLongitude) {
        this.favLongitude = favLongitude;
    }

    public String getFavAddress() {
        return favAddress;
    }

    public void setFavAddress(String favAddress) {
        this.favAddress = favAddress;
    }

    public LocalDateTime getDateTimeCreationFav() {
        return datetimeCreationFav;
    }

    @Override
    public String toString() {
        return "FavoriteDirectionPOJO{" +
                ", favLatitude='" + favLatitude + '\'' +
                ", favLongitude='" + favLongitude + '\'' +
                ", favAddress='" + favAddress + '\'' +
                ", datetimeCreationFav=" + datetimeCreationFav +
                ", nameFd='" + nameFd + '\'' +
                '}';
    }

    public String getNameFd() {
        return nameFd;
    }

    public void setNameFd(String nameFd) {
        this.nameFd = nameFd;
    }

    public void setDateTimeCreationFav(LocalDateTime dateTimeCreationFav) {
        this.datetimeCreationFav = dateTimeCreationFav;
    }
    public int getIdFavoriteDirection() {
        return idFavoriteDirection;
    }

    public void setIdFavoriteDirection(int idFavoriteDirection) {
        this.idFavoriteDirection = idFavoriteDirection;
    }


}
