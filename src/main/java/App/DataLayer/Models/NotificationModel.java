package App.DataLayer.Models;

import javax.persistence.*;
import lombok.Data;

/**
 *
 * @author cesar
 */

@Entity
@Data
@Table(name = "notification")
public class NotificationModel {
       
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_notification")
    private int idNotification;
    
    @Column(name = "id_user")
    private int idUser;
    
    private String data;
    
    private String destination;

    public int getIdNotification() {
        return idNotification;
    }

    public void setIdNotification(int idNotification) {
        this.idNotification = idNotification;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
        
    @ManyToOne
    @JoinColumn( name = "id_user", insertable=false, updatable=false  )
    private UserModel userModel;
    
}
