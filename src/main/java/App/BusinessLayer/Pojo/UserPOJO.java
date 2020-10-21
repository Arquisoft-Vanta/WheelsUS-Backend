package App.BusinessLayer.Pojo;

import com.fasterxml.jackson.annotation.JsonFormat;


import java.time.LocalDateTime;

public class UserPOJO {
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

    public UserPOJO(int idUser, String userName, String userDoc,
                    String userPhone, int universityId, String userMail,
                    String userAddress, String password,
                    LocalDateTime registryDatetime, String picture, String rh) {
        this.idUser = idUser;
        this.userName = userName;
        this.userDoc = userDoc;
        this.userPhone = userPhone;
        this.universityId = universityId;
        this.userMail = userMail;
        this.userAddress = userAddress;
        this.password = password;
        this.registryDatetime = registryDatetime;
        this.picture = picture;
        Rh = rh;
    }

    public UserPOJO(String userName, String userDoc, String userPhone,
                    int universityId, String userMail, String userAddress,
                    String password, LocalDateTime registryDatetime,
                    String rh) {
        this.userName = userName;
        this.userDoc = userDoc;
        this.userPhone = userPhone;
        this.universityId = universityId;
        this.userMail = userMail;
        this.userAddress = userAddress;
        this.password = password;
        this.registryDatetime = registryDatetime;
        this.picture = picture;
        Rh = rh;
    }

    public UserPOJO() {
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserDoc() {
        return userDoc;
    }

    public void setUserDoc(String userDoc) {
        this.userDoc = userDoc;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public int getUniversityId() {
        return universityId;
    }

    public void setUniversityId(int universityId) {
        this.universityId = universityId;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getRegistryDatetime() {
        return registryDatetime;
    }

    public void setRegistryDatetime(LocalDateTime registryDatetime) {
        this.registryDatetime = registryDatetime;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getRh() {
        return Rh;
    }

    public void setRh(String rh) {
        Rh = rh;
    }
}
