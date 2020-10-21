package App.DataLayer.Models;

/**
 * @author crist
 */

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

/**
 *
 * @author gonza
 */
@Entity
@Data
@Table(name = "`user`")
// JsonIdentityInfo evita que se generen ciclos al leer la BD
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "idUser")
public class UserModel {

    public UserModel() {

    }

    public UserModel(String userName, String userDoc, String userPhone,
                     int universityId, String userMail, String userAddress,
                     String password, LocalDateTime registryDatetime,
                     String Rh) {
        this.userName = userName;
        this.userDoc = userDoc;
        this.userPhone = userPhone;
        this.universityId = universityId;
        this.userMail = userMail;
        this.userAddress = userAddress;
        this.password = password;
        this.registryDatetime = registryDatetime;
        this.Rh = Rh;
    }

    @Id // Primary key, con autoincremento
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_user")
    private int idUser;

    private String userName;

    private String userDoc;

    private String userPhone;

    private int universityId;

    private String userMail;

    private String userAddress;

    private String password;

    @JsonFormat(pattern = "yyyy-MM-dd@HH:mm:ss")
    private LocalDateTime registryDatetime;

    private String picture;

    private String Rh;

    @OneToMany(mappedBy = "vehicleOwner")
    private List<VehicleModel> vehicleModel;

    /*
    // Relacion uno a muchos con modelDos
    // Usar esta parte cuando toque hacer relaciones con otras tablas
    
    private int fkModel2;
    
    @OneToMany(mappedBy = "fkModel2", cascade = CascadeType.ALL,
    orphanRemoval = false)
    @JsonIgnore
    private List<Model2> model2List;
    
     */
}
