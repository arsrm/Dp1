/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.sql.Timestamp;

/**
 *
 * @author CHACON
 */
public class Type_Condition_WareHouse {

    public int getIdType_Condition_WareHouse() {
        return idType_Condition_WareHouse;
    }

    public void setIdType_Condition_WareHouse(int idType_Condition_WareHouse) {
        this.idType_Condition_WareHouse = idType_Condition_WareHouse;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
    
    private int idType_Condition_WareHouse;
    private String description;
    private Timestamp created_at;
    private Timestamp update_at;
    private Timestamp deleted_at;
}
