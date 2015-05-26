/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Luis Miguel
 */

public class Vehicle implements Serializable {
    private Integer idVehicle;
    private Double capacity;
    private Integer dispatchNumber;
    private Integer status;
    private Timestamp createdAt;
    private Timestamp updatedUp;
    private Integer userCreated;
    private Integer userUpdated;
    private Driver driver;
    private VehicleState vehicleState;
    private List<DispatchOrder> dispatchOrderList;

    public Vehicle() {
    }


    public Double getCapacity() {
        return capacity;
    }

    public void setCapacity(Double capacity) {
        this.capacity = capacity;
    }

    public Integer getDispatchNumber() {
        return dispatchNumber;
    }

    public void setDispatchNumber(Integer dispatchNumber) {
        this.dispatchNumber = dispatchNumber;
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

    public Timestamp getUpdatedUp() {
        return updatedUp;
    }

    public void setUpdatedUp(Timestamp updatedUp) {
        this.updatedUp = updatedUp;
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

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public VehicleState getVehicleState() {
        return vehicleState;
    }

    public void setVehicleState(VehicleState vehicleState) {
        this.vehicleState = vehicleState;
    }

    public List<DispatchOrder> getDispatchOrderList() {
        return dispatchOrderList;
    }

    public void setDispatchOrderList(List<DispatchOrder> dispatchOrderList) {
        this.dispatchOrderList = dispatchOrderList;
    }

    /**
     * @return the idVehicle
     */
    public Integer getIdVehicle() {
        return idVehicle;
    }

    /**
     * @param idVehicle the idVehicle to set
     */
    public void setIdVehicle(Integer idVehicle) {
        this.idVehicle = idVehicle;
    }

}