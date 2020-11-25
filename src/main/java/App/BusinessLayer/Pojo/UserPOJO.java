package App.BusinessLayer.Pojo;

import App.DataLayer.Models.UserModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.security.crypto.password.PasswordEncoder;


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

    public UserModel getModel(PasswordEncoder passwordEncoder) {
        UserModel user = new UserModel();
        user.setUserName(getUserName());
        user.setUserDoc(getUserDoc());
        user.setUserPhone(getUserPhone());
        user.setUniversityId(getUniversityId());
        user.setUserMail(getUserMail());
        user.setUserAddress(getUserAddress());
        user.setPassword(passwordEncoder.encode(getPassword()));
        user.setRegistryDatetime(getRegistryDatetime());
        user.setPicture(getPicture());
        user.setRh(getRh());
        return user;
    }

    public UserModel updateModel(PasswordEncoder passwordEncoder,
                                 UserModel user) {
        if (getUserName() != null) {
            user.setUserName(getUserName());
        }
        if (getUserDoc() != null) {
            user.setUserDoc(getUserDoc());
        }
        if (getUserPhone() != null) {
            user.setUserPhone(getUserPhone());
        }
        if (getUniversityId() != user.getUniversityId()) {
            user.setUniversityId(getUniversityId());
        }
        if (getUserMail() != null) {
            user.setUserMail(getUserMail());
        }

        if (getUserAddress() != null) {
            user.setUserAddress(getUserAddress());
        }
        if (getPassword() != null) {
            user.setPassword(passwordEncoder.encode(getPassword()));
        }
        if (getRegistryDatetime() != null) {
            user.setRegistryDatetime(getRegistryDatetime());
        }
        if (getPicture() != null) {
            user.setPicture(getPicture());
        }
        if (getRh() != null) {
            user.setRh(getRh());
        }
        return user;
    }

    public UserPOJO(UserModel userModel) {
        setUserName(userModel.getUserName());
        setUserDoc(userModel.getUserDoc());
        setUserPhone(userModel.getUserPhone());
        setUniversityId(userModel.getUniversityId());
        setUserMail(userModel.getUserMail());
        setUserAddress(userModel.getUserAddress());
        setRegistryDatetime(userModel.getRegistryDatetime());
        setPicture(userModel.getPicture());
        setRh(userModel.getRh());
    }

}
