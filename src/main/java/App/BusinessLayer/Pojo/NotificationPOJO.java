package App.BusinessLayer.Pojo;

import App.DataLayer.Models.NotificationModel;

/**
 *
 * @author cesar
 */
public class NotificationPOJO {
   
    private int idNotification;
    
    private String data;
    
    private String destination;
    
    private int idUser;
    
    private String mailUser;
    
    public String getMailUser() {
        return mailUser;
    }

    public void setMailUser(String mailUser) {
        this.mailUser = mailUser;
    }
    
    public int getIdNotification() {
        return idNotification;
    }

    public void setIdNotification(int idNotification) {
        this.idNotification = idNotification;
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

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
    
    public NotificationModel getModel() {
        NotificationModel notificationModel = new NotificationModel();
        notificationModel.setData(getData());
        notificationModel.setIdUser(getIdUser());
        notificationModel.setDestination(getDestination());
        
        return notificationModel;
    }
    
    public NotificationPOJO(){
        
    }
    
    public NotificationPOJO(NotificationModel notificationModel){
    
        setData(notificationModel.getData());
        setIdUser(notificationModel.getIdUser());
        setDestination(notificationModel.getDestination());
        
    }
        
}
