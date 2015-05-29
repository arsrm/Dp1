package Model;

import java.sql.Timestamp;

public class Client {
    
    private Integer idClient;
    private String ruc;
    private String name;
    private String address;
    private Integer priority;
    private Integer pos_x;
    private Integer pos_y;
    private Integer status;
   
    public Client() {
        
    }
    
    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getPos_x() {
        return pos_x;
    }

    public void setPos_x(Integer pos_x) {
        this.pos_x = pos_x;
    }

    public Integer getPos_y() {
        return pos_y;
    }

    public void setPos_y(Integer pos_y) {
        this.pos_y = pos_y;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    
}
