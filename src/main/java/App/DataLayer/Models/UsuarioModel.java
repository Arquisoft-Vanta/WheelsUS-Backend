
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
        property = "idUsuario")
public class UsuarioModel {
    
    public UsuarioModel() {

    }

    public UsuarioModel(String nombre, String documento,String telefono,String usuarioUniversitario,String correo,String direccion,String password, LocalDate horaDeRegistro, String Rh) {
        this.nombre = nombre;
        this.documento = documento;
        this.telefono = telefono;
        this.usuarioUniversitario =usuarioUniversitario;
        this.correo = correo;
        this.direccion = direccion;
        this.password = password;
        this.horaDeRegistro = horaDeRegistro;
        this.Rh = Rh;
    }

    @Id // Primary key, con autoincremento
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idUsuario;

    private String nombre;

    private String documento;
    
    private String telefono;
    
    private String usuarioUniversitario;
    
    private String correo;
    
    private String direccion;
    
    private String password;
    
  

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate horaDeRegistro;

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
