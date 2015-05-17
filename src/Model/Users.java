package Model;

import java.sql.Timestamp;

public class Users {

    private Integer idUser;
    private String Names;
    private String password;
    private Timestamp created_at;
    private Timestamp update_at;
    private Timestamp deleted_at;
    private Integer Profile_idProfile;
    private Integer Distribution_Center_idDistribution_Center;

    public Users() {

    }

    public String getNames() {
        return Names;
    }

    public void setNames(String Names) {
        this.Names = Names;
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

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(Timestamp update_at) {
        this.update_at = update_at;
    }

    public Timestamp getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(Timestamp deleted_at) {
        this.deleted_at = deleted_at;
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
