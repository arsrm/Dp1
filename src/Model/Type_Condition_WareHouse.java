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

    public Integer getIdType_Condition_WareHouse() {
        return idType_Condition_WareHouse;
    }

    public void setIdType_Condition_WareHouse(Integer idType_Condition_WareHouse) {
        this.idType_Condition_WareHouse = idType_Condition_WareHouse;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
    private Integer idType_Condition_WareHouse;
    private String description;
    private Integer status;

    /**
     * @return the status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}
