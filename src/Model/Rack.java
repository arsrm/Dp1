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
    public String identifier;
    public String description;
    public Double length;
    public Double width;
    public Integer floor_numbers;
    public Integer height_per_floor;
    public Integer resistance_weigth_per_floor;
    public Integer column_number;
    public Integer status;
    public Timestamp created_at;
    public Timestamp updated_at;
    public Integer Warehouse_idWarehouse;
    public Integer Warehouse_Distribution_Center_idDistribution_Center;
    public Integer user_created;
    public Integer user_updated;
    
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
     * @return the identifier
     */
    public String getIdentifier() {
        return identifier;
    }

    /**
     * @param identifier the identifier to set
     */
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
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
     * @return the floor_numbers
     */
    public Integer getFloor_numbers() {
        return floor_numbers;
    }

    /**
     * @param floor_numbers the floor_numbers to set
     */
    public void setFloor_numbers(Integer floor_numbers) {
        this.floor_numbers = floor_numbers;
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
     * @return the Warehouse_idWarehouse
     */
    public Integer getWarehouse_idWarehouse() {
        return Warehouse_idWarehouse;
    }

    /**
     * @param Warehouse_idWarehouse the Warehouse_idWarehouse to set
     */
    public void setWarehouse_idWarehouse(Integer Warehouse_idWarehouse) {
        this.Warehouse_idWarehouse = Warehouse_idWarehouse;
    }

    /**
     * @return the Warehouse_Distribution_Center_idDistribution_Center
     */
    public Integer getWarehouse_Distribution_Center_idDistribution_Center() {
        return Warehouse_Distribution_Center_idDistribution_Center;
    }

    /**
     * @param Warehouse_Distribution_Center_idDistribution_Center the Warehouse_Distribution_Center_idDistribution_Center to set
     */
    public void setWarehouse_Distribution_Center_idDistribution_Center(Integer Warehouse_Distribution_Center_idDistribution_Center) {
        this.Warehouse_Distribution_Center_idDistribution_Center = Warehouse_Distribution_Center_idDistribution_Center;
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

    
    
    
}
