package Model;

import java.util.Date;

public class LogSystem {

    public LogSystem() {

    }

    public Integer getIdLog_security() {
        return idLog_security;
    }

    public void setIdLog_security(Integer idLog_security) {
        this.idLog_security = idLog_security;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getUser_idUser() {
        return User_idUser;
    }

    public void setUser_idUser(String User_idUser) {
        this.User_idUser = User_idUser;
    }

    public String getClasss() {
        return classs;
    }

    public void setClasss(String classs) {
        this.classs = classs;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMac_address() {
        return mac_address;
    }

    public void setMac_address(String mac_address) {
        this.mac_address = mac_address;
    }
    private Integer idLog_security;
    private String date;
    private String action;
    private String User_idUser;
    private String classs;
    private String ip;
    private String mac_address;

}
