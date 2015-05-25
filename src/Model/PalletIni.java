/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.sql.Timestamp;
import java.util.logging.Logger;

/**
 *
 * @author gzavala
 */
public class PalletIni {
  
   Integer idpallet; 
   String description="";
   Integer statusactividad;
   Integer statuspallet;
   Timestamp created_at; 
   Integer user_created;
   Timestamp updated_at;
   Integer user_updated; 

    public PalletIni() {
    }

    public PalletIni(Integer idpallet, Integer statusactividad, Integer statuspallet, Timestamp created_at, Integer user_created, Timestamp updated_at, Integer user_updated,String description) {
        this.idpallet = idpallet;
        this.statusactividad = statusactividad;
        this.statuspallet = statuspallet;
        this.created_at = created_at;
        this.user_created = user_created;
        this.updated_at = updated_at;
        this.user_updated = user_updated;
        this.description=description; 
    }

    public Integer getIdpallet() {
        return idpallet;
    }

    public void setIdpallet(Integer idpallet) {
        this.idpallet = idpallet;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatusactividad() {
        return statusactividad;
    }

    public void setStatusactividad(Integer statusactividad) {
        this.statusactividad = statusactividad;
    }

    public Integer getStatuspallet() {
        return statuspallet;
    }

    public void setStatuspallet(Integer statuspallet) {
        this.statuspallet = statuspallet;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Integer getUser_created() {
        return user_created;
    }

    public void setUser_created(Integer user_created) {
        this.user_created = user_created;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }

    public Integer getUser_updated() {
        return user_updated;
    }

    public void setUser_updated(Integer user_updated) {
        this.user_updated = user_updated;
    }
   
   
   
  
    
}
