
package App.DataLayer.Models;

/**
 *
 * @author crist
 */

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author gonza
 */
@Entity
@Data
@Table(name = "Usuario")
// JsonIdentityInfo evita que se generen ciclos al leer la BD
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "idUser")
public class UserModel {
    
    public UserModel() {

    }

    public UserModel(String name, String document,String phone,String userUniversity,String mail,String address,String password, LocalDate registryDatatime, String Rh) {
        this.name = name;
        this.document = document;
        this.phone = phone;
        this.userUniversity =userUniversity;
        this.mail = mail;
        this.address = address;
        this.password = password;
        this.registryDatatime  = registryDatatime;
        this.Rh = Rh;
    }

    @Id // Primary key, con autoincremento
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idUser;

    private String name;

    private String document;
    
    private String phone;
    
    private String userUniversity;
    
    private String mail;
    
    private String address;
    
    private String password;
    
  

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate registryDatatime;

    private String Rh;

    /*
    // Relacion uno a muchos con modelDos
    // Usar esta parte cuando toque hacer relaciones con otras tablas
    
    private int fkModel2;
    
    @OneToMany(mappedBy = "fkModel2", cascade = CascadeType.ALL, orphanRemoval = false)
    @JsonIgnore
    private List<Model2> model2List;
    
     */
}
