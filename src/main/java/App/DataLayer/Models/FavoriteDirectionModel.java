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


}

