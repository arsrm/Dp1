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

public class VehicleState implements Serializable {
   
    private Integer idVehicleState;
    private String description;
    private Integer status;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Integer userCreated;
    private Integer userUpdated;
    private List<Vehicle> vehicleList;

    public VehicleState() {
    }

    public VehicleState(Integer idVehicleState) {
        this.idVehicleState = idVehicleState;
    }

    public Integer getIdVehicleState() {
        return idVehicleState;
    }

    public void setIdVehicleState(Integer idVehicleState) {
        this.idVehicleState = idVehicleState;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public void setVehicleList(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVehicleState != null ? idVehicleState.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VehicleState)) {
            return false;
        }
        VehicleState other = (VehicleState) object;
        if ((this.idVehicleState == null && other.idVehicleState != null) || (this.idVehicleState != null && !this.idVehicleState.equals(other.idVehicleState))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model_WMS.VehicleState[ idVehicleState=" + idVehicleState + " ]";
    }
    
}
