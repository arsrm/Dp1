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

public class StateRequestOrder implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer idStateRequestOrder;
    private String description;
    private Integer status;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Integer userCreated;
    private Integer userUpdated;
    private List<RequestOrder> requestOrderList;

    public StateRequestOrder() {
    }

    public StateRequestOrder(Integer idStateRequestOrder) {
        this.idStateRequestOrder = idStateRequestOrder;
    }

    public Integer getIdStateRequestOrder() {
        return idStateRequestOrder;
    }

    public void setIdStateRequestOrder(Integer idStateRequestOrder) {
        this.idStateRequestOrder = idStateRequestOrder;
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

    public List<RequestOrder> getRequestOrderList() {
        return requestOrderList;
    }

    public void setRequestOrderList(List<RequestOrder> requestOrderList) {
        this.requestOrderList = requestOrderList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idStateRequestOrder != null ? idStateRequestOrder.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StateRequestOrder)) {
            return false;
        }
        StateRequestOrder other = (StateRequestOrder) object;
        if ((this.idStateRequestOrder == null && other.idStateRequestOrder != null) || (this.idStateRequestOrder != null && !this.idStateRequestOrder.equals(other.idStateRequestOrder))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model_WMS.StateRequestOrder[ idStateRequestOrder=" + idStateRequestOrder + " ]";
    }
    
}
