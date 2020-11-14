package App.DataLayer.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.time.LocalDateTime;
import javax.persistence.*;

import lombok.Data;
import java.sql.Date;
import java.util.List;

@Entity
@Data
@Table(name = "favorite_destination")
// JsonIdentityInfo evita que se generen ciclos al leer la BD

public class FavoriteDirectionModel {

    public FavoriteDirectionModel(){

    }

    public FavoriteDirectionModel(int idFavDest, String lat, String lng, String nameDirection, String nameAddress, int idUserFav){
        this.idFavDest = idFavDest;
        this.favLatitude = lat;
        this.favLongitude = lng;
        this.nameFd = nameDirection;
        this.favAddress = nameAddress;
        this.idUserFav= idUserFav;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column( name = "id_fav_dest" )
    private int idFavDest;

    @Column(name = "id_user_fav")
    private int idUserFav;

    private String favLatitude;

    private String favLongitude;

    private String favAddress;

    @JsonFormat(pattern = "yyyy-MM-dd@HH:mm:ss")
    private LocalDateTime datetimeCreationFav;

    private String nameFd;


    @ManyToOne
    @JoinColumn( name = "id_user_fav", insertable=false, updatable=false  )
    private UserModel userModel;

    public int getIdFavDest() {
        return idFavDest;
    }

    public void setIdFavDest(int idFavDest) {
        this.idFavDest = idFavDest;
    }

    public int getIdUserFav() {
        return idUserFav;
    }

    public void setIdUserFav(int idUserFav) {
        this.idUserFav = idUserFav;
    }

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

    public LocalDateTime getDatetimeCreationFav() {
        return datetimeCreationFav;
    }

    public void setDatetimeCreationFav(LocalDateTime datetimeCreationFav) {
        this.datetimeCreationFav = datetimeCreationFav;
    }

    public String getNameFd() {
        return nameFd;
    }

    public void setNameFd(String nameFd) {
        this.nameFd = nameFd;
    }

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }

    @Override
    public String toString() {
        return "FavoriteDirectionModel{" +
                "idFavDest=" + idFavDest +
                ", idUserFav=" + idUserFav +
                ", favLatitude='" + favLatitude + '\'' +
                ", favLongitude='" + favLongitude + '\'' +
                ", favAddress='" + favAddress + '\'' +
                ", datetimeCreationFav=" + datetimeCreationFav +
                ", nameFd='" + nameFd + '\'' +
                ", userModel=" + userModel +
                '}';
    }
}

