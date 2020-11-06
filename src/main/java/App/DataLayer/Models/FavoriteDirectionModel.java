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

@Entity
@Data
@Table(name = "favoriteDestination")
// JsonIdentityInfo evita que se generen ciclos al leer la BD
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "idFavoriteDirection")


public class FavoriteDirectionModel {

    public FavoriteDirectionModel(){

    }

    public FavoriteDirectionModel(int idFavoriteDirection, double lat, double lng, String nameDirection, String nameAddress, int favoriteDirectionOwner){
        this.idFavoriteDirection = idFavoriteDirection;
        this.lat = lat;
        this.lng = lng;
        this.nameDirection = nameDirection;
        this.nameAddress = nameAddress;
        this.favoriteDirectionOwner= favoriteDirectionOwner;
    }

    @Id // Primary key, con autoincremento
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idFavoriteDirection;

    @Column(name = "favorite_direction_owner")
    private int favoriteDirectionOwner;

    @Column( name = "lat" )
    private double lat;

    @Column( name = "lng" )
    private double lng;

    @Column( name = "name_direction" )
    private String nameDirection;

    @Column( name = "dame_address" )
    private String nameAddress;

    @ManyToOne
    @JoinColumn( name = "favorite_direction_owner", insertable=false, updatable=false  )
    private UserModel userModel;


    public int getIdFavoriteDirection() {
        return idFavoriteDirection;
    }

    public void setIdFavoriteDirection(int idFavoriteDirection) {
        this.idFavoriteDirection = idFavoriteDirection;
    }

    public int getFavoriteDirectionOwner() {
        return favoriteDirectionOwner;
    }

    public void setFavoriteDirectionOwner(int favoriteDirectionOwner) {
        this.favoriteDirectionOwner = favoriteDirectionOwner;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public String getNameDirection() {
        return nameDirection;
    }

    public void setNameDirection(String nameDirection) {
        this.nameDirection = nameDirection;
    }

    public String getNameAddress() {
        return nameAddress;
    }

    public void setNameAddress(String nameAddress) {
        this.nameAddress = nameAddress;
    }
}
