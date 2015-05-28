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
public class PalletProduct {
  
    Integer idpallet; 
    Integer idtrademark; 
    Integer idproduct; 
    Integer status; 
    Timestamp created_at; 
    Timestamp updated_at; 
    Integer user_created; 
    Integer user_updated; 

    public PalletProduct() {
    }

    public PalletProduct(Integer idpallet, Integer idtrademark, Integer idproduct, Integer status, Timestamp created_at, Timestamp updated_at, Integer user_created, Integer user_updated) {
        this.idpallet = idpallet;
        this.idtrademark = idtrademark;
        this.idproduct = idproduct;
        this.status = status;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.user_created = user_created;
        this.user_updated = user_updated;
    }

    public Integer getIdpallet() {
        return idpallet;
    }

    public void setIdpallet(Integer idpallet) {
        this.idpallet = idpallet;
    }

    public Integer getIdtrademark() {
        return idtrademark;
    }

    public void setIdtrademark(Integer idtrademark) {
        this.idtrademark = idtrademark;
    }

    public Integer getIdproduct() {
        return idproduct;
    }

    public void setIdproduct(Integer idproduct) {
        this.idproduct = idproduct;
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
