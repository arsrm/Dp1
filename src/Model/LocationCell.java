/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;


/**
 *
 * @author Luis Miguel
 */

public class LocationCell{
    private Integer idLocation_Cell;
    private String description;
    private Double width;
    private Double length;
    private Integer height;
    private Integer row_cell;
    private Integer column_cell;
    private Integer status;
    private Integer Location_State_idLocation_State;
    private Integer Rack_idRack;
    private Integer Rack_Warehouse_idWarehouse;
    private Integer Rack_Warehouse_Distribution_Center_idDistribution_Center;

    /**
     * @return the idLocation_Cell
     */
    public Integer getIdLocation_Cell() {
        return idLocation_Cell;
    }

    /**
     * @param idLocation_Cell the idLocation_Cell to set
     */
    public void setIdLocation_Cell(Integer idLocation_Cell) {
        this.idLocation_Cell = idLocation_Cell;
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
     * @return the height
     */
    public Integer getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(Integer height) {
        this.height = height;
    }

    /**
     * @return the row_cell
     */
    public Integer getRow_Cell() {
        return row_cell;
    }

    /**
     * @param row_cell the row_cell to set
     */
    public void setRow_Cell(Integer row_cell) {
        this.row_cell = row_cell;
    }

    /**
     * @return the column_cell
     */
    public Integer getColumn_Cell() {
        return column_cell;
    }

    /**
     * @param column_cell the column_cell to set
     */
    public void setColumn_Cell(Integer column_cell) {
        this.column_cell = column_cell;
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
     * @return the Location_State_idLocation_State
     */
    public Integer getLocation_State_idLocation_State() {
        return Location_State_idLocation_State;
    }

    /**
     * @param Location_State_idLocation_State the Location_State_idLocation_State to set
     */
    public void setLocation_State_idLocation_State(Integer Location_State_idLocation_State) {
        this.Location_State_idLocation_State = Location_State_idLocation_State;
    }

    /**
     * @return the Rack_idRack
     */
    public Integer getRack_idRack() {
        return Rack_idRack;
    }

    /**
     * @param Rack_idRack the Rack_idRack to set
     */
    public void setRack_idRack(Integer Rack_idRack) {
        this.Rack_idRack = Rack_idRack;
    }

    /**
     * @return the Rack_Warehouse_idWarehouse
     */
    public Integer getRack_Warehouse_idWarehouse() {
        return Rack_Warehouse_idWarehouse;
    }

    /**
     * @param Rack_Warehouse_idWarehouse the Rack_Warehouse_idWarehouse to set
     */
    public void setRack_Warehouse_idWarehouse(Integer Rack_Warehouse_idWarehouse) {
        this.Rack_Warehouse_idWarehouse = Rack_Warehouse_idWarehouse;
    }

    /**
     * @return the Rack_Warehouse_Distribution_Center_idDistribution_Center
     */
    public Integer getRack_Warehouse_Distribution_Center_idDistribution_Center() {
        return Rack_Warehouse_Distribution_Center_idDistribution_Center;
    }

    /**
     * @param Rack_Warehouse_Distribution_Center_idDistribution_Center the Rack_Warehouse_Distribution_Center_idDistribution_Center to set
     */
    public void setRack_Warehouse_Distribution_Center_idDistribution_Center(Integer Rack_Warehouse_Distribution_Center_idDistribution_Center) {
        this.Rack_Warehouse_Distribution_Center_idDistribution_Center = Rack_Warehouse_Distribution_Center_idDistribution_Center;
    }
    
    
    
}
