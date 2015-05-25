/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;
import java.sql.Timestamp;

/**
 *
 * @author gzavala
 */
public class PalletState {
    
    Integer idPallet_State; 
    String description="";
    Integer status; 
    Timestamp created_at; 
    Timestamp updated_at; 
    Integer user_created;
    Integer user_updated;

    public PalletState() {
    }

    public PalletState(Integer idPallet_State, Integer status, Timestamp created_at, Timestamp updated_at, Integer user_created, Integer user_updated) {
        this.idPallet_State = idPallet_State;
        this.status = status;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.user_created = user_created;
        this.user_updated = user_updated;
    }

    public Integer getIdPallet_State() {
        return idPallet_State;
    }

    public void setIdPallet_State(Integer idPallet_State) {
        this.idPallet_State = idPallet_State;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }

    public Integer getUser_created() {
        return user_created;
    }

    public void setUser_created(Integer user_created) {
        this.user_created = user_created;
    }

    public Integer getUser_updated() {
        return user_updated;
    }

    public void setUser_updated(Integer user_updated) {
        this.user_updated = user_updated;
    }
    
    
    
}
