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
    private Double width;
    private Double length;
    private Double height;
    private Integer row;
    private Integer column;
    private Integer status;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    
    private Integer userCreated;
    private Integer userUpdated;
    private LocationState locationStateidLocationState;
    private Rack rack;
    private List<LocationCellDetail> locationCellDetailList;

    public LocationCell() {
    }


    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getColumn() {
        return column;
    }

    public void setColumn(Integer column) {
        this.column = column;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getUserCreated() {
        return userCreated;
    }

    public void setUserCreated(Integer userCreated) {
        this.userCreated = userCreated;
    }

    public Integer getUserUpdated() {
        return userUpdated;
    }

    public void setUserUpdated(Integer userUpdated) {
        this.userUpdated = userUpdated;
    }

    public LocationState getLocationStateidLocationState() {
        return locationStateidLocationState;
    }

    public void setLocationStateidLocationState(LocationState locationStateidLocationState) {
        this.locationStateidLocationState = locationStateidLocationState;
    }

    public Rack getRack() {
        return rack;
    }

    public void setRack(Rack rack) {
        this.rack = rack;
    }

    public List<LocationCellDetail> getLocationCellDetailList() {
        return locationCellDetailList;
    }

    public void setLocationCellDetailList(List<LocationCellDetail> locationCellDetailList) {
        this.locationCellDetailList = locationCellDetailList;
    }

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

}
