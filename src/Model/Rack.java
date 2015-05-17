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

public class Rack {
    
    public Integer idRack;
    public String description;
    public Double length;
    public Double width;
    public Integer floor_number;
    public Integer height_per_floor;
    public Integer resistance_weigth_per_floor;
    public Integer column_number;
    public Timestamp created_at;
    public Timestamp updated_at;
    public Timestamp deleted_at;
    public Integer idWarehouse;
    public Integer idDistribution_Center;
    
    public Rack() {
    }

    /**
     * @return the idRack
     */
    public Integer getIdRack() {
        return idRack;
    }

    /**
     * @param idRack the idRack to set
     */
    public void setIdRack(Integer idRack) {
        this.idRack = idRack;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the length
     */
    public Double getLength() {
        return length;
    }

    /**
     * @param length the length to set
     */
    public void setLength(Double length) {
        this.length = length;
    }

    /**
     * @return the width
     */
    public Double getWidth() {
        return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(Double width) {
        this.width = width;
    }

    /**
     * @return the floor_number
     */
    public Integer getFloor_number() {
        return floor_number;
    }

    /**
     * @param floor_number the floor_number to set
     */
    public void setFloor_number(Integer floor_number) {
        this.floor_number = floor_number;
    }

    /**
     * @return the height_per_floor
     */
    public Integer getHeight_per_floor() {
        return height_per_floor;
    }

    /**
     * @param height_per_floor the height_per_floor to set
     */
    public void setHeight_per_floor(Integer height_per_floor) {
        this.height_per_floor = height_per_floor;
    }

    /**
     * @return the resistance_weigth_per_floor
     */
    public Integer getResistance_weigth_per_floor() {
        return resistance_weigth_per_floor;
    }

    /**
     * @param resistance_weigth_per_floor the resistance_weigth_per_floor to set
     */
    public void setResistance_weigth_per_floor(Integer resistance_weigth_per_floor) {
        this.resistance_weigth_per_floor = resistance_weigth_per_floor;
    }

    /**
     * @return the column_number
     */
    public Integer getColumn_number() {
        return column_number;
    }

    /**
     * @param column_number the column_number to set
     */
    public void setColumn_number(Integer column_number) {
        this.column_number = column_number;
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
     * @return the deleted_at
     */
    public Timestamp getDeleted_at() {
        return deleted_at;
    }

    /**
     * @param deleted_at the deleted_at to set
     */
    public void setDeleted_at(Timestamp deleted_at) {
        this.deleted_at = deleted_at;
    }

    /**
     * @return the idWarehouse
     */
    public Integer getIdWarehouse() {
        return idWarehouse;
    }

    /**
     * @param idWarehouse the idWarehouse to set
     */
    public void setIdWarehouse(Integer idWarehouse) {
        this.idWarehouse = idWarehouse;
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
    
    
}
