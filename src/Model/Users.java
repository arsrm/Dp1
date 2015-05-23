package Model;

import java.sql.Timestamp;

public class Users {

    private Integer idUser;
    private String name;
    private String password;
    private Integer password_change;
    private Integer status;
    private Integer Profile_idProfile;
    private Integer Distribution_Center_idDistribution_Center;

    public Users() {

    }
      public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

      public Integer getPassword_change() {
        return password_change;
    }

    public void setPassword_change(Integer password_change) {
        this.password_change = password_change;
    }
    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }
    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getProfile_idProfile() {
        return Profile_idProfile;
    }

    public void setProfile_idProfile(Integer Profile_idProfile) {
        this.Profile_idProfile = Profile_idProfile;
    }

    public Integer getDistribution_Center_idDistribution_Center() {
        return Distribution_Center_idDistribution_Center;
    }

    public void setDistribution_Center_idDistribution_Center(Integer Distribution_Center_idDistribution_Center) {
        this.Distribution_Center_idDistribution_Center = Distribution_Center_idDistribution_Center;
    }

}
