package App.DataLayer.Models;

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
@Table(name = "ExampleTable")
// JsonIdentityInfo evita que se generen ciclos al leer la BD
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "idExample")
public class ExampleModel {

    public ExampleModel() {

    }

    public ExampleModel(String name, String city, LocalDate birthday, boolean hasCreditCard) {
        this.name = name;
        this.city = city;
        this.birthday = birthday;
        this.hasCreditCard = hasCreditCard;
    }

    @Id // Primary key, con autoincremento
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idExample;

    private String name;

    private String city;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    private boolean hasCreditCard;

    /*
    // Relacion uno a muchos con modelDos
    // Usar esta parte cuando toque hacer relaciones con otras tablas
    
    private int fkModel2;
    
    @OneToMany(mappedBy = "fkModel2", cascade = CascadeType.ALL, orphanRemoval = false)
    @JsonIgnore
    private List<Model2> model2List;
    
     */
}
