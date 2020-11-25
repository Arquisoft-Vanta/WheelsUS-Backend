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
    
    @ManyToOne
    @JoinColumn( name = "id_user", insertable=false, updatable=false  )
    private UserModel userModel;
    
}
