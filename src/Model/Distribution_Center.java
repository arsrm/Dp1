/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.sql.Timestamp;

/**
 *
 * @author Luigi
 */

public class Distribution_Center {
    
    public Integer idDistribution_Center;
    public String name;
    public String address;
    public Integer pos_x;
    public Integer pos_y;
    public Integer status;
    public Timestamp created_at;
    public Timestamp updated_at;
    public Integer user_created;
    public Integer user_updated;
    
    public Distribution_Center() {
    }

    /**
     * @return the idDistribution_Center
     */
    public Integer getIdDistribution_Center() {
        return idDistribution_Center;
    }

    /**
     * @param idDistribution_Center the idDistribution_Center to set
     */
    public void setIdDistribution_Center(Integer idDistribution_Center) {
        this.idDistribution_Center = idDistribution_Center;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the pos_x
     */
    public Integer getPos_x() {
        return pos_x;
    }

    /**
     * @param pos_x the pos_x to set
     */
    public void setPos_x(Integer pos_x) {
        this.pos_x = pos_x;
    }

    /**
     * @return the pos_y
     */
    public Integer getPos_y() {
        return pos_y;
    }

    /**
     * @param pos_y the pos_y to set
     */
    public void setPos_y(Integer pos_y) {
        this.pos_y = pos_y;
    }

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

    /**
     * @return the created_at
     */
    public Timestamp getCreated_at() {
        return created_at;
    }

    /**
     * @param created_at the created_at to set
     */
    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    /**
     * @return the updated_at
     */
    public Timestamp getUpdated_at() {
        return updated_at;
    }

    /**
     * @param updated_at the updated_at to set
     */
    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }

    /**
     * @return the user_created
     */
    public Integer getUser_created() {
        return user_created;
    }

    /**
     * @param user_created the user_created to set
     */
    public void setUser_created(Integer user_created) {
        this.user_created = user_created;
    }

    /**
     * @return the user_updated
     */
    public Integer getUser_updated() {
        return user_updated;
    }

    /**
     * @param user_updated the user_updated to set
     */
    public void setUser_updated(Integer user_updated) {
        this.user_updated = user_updated;
    }

    /**
     * @return the idRack
     */
    
}
