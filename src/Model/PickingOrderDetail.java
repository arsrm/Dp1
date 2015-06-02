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

public class PickingOrderDetail{
    private Integer idPicking_Order_Detail;
    private Integer delivered;
    private Integer status;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private LocationCellDetail locationCellDetail;
    private PickingOrder pickingOrder;
    private Integer userCreated;
    private Integer userUpdated;
    
    

    public PickingOrderDetail() {
    }

    /**
     * @return the idPicking_Order_Detail
     */
    public Integer getIdPicking_Order_Detail() {
        return idPicking_Order_Detail;
    }

    /**
     * @param idPicking_Order_Detail the idPicking_Order_Detail to set
     */
    public void setIdPicking_Order_Detail(Integer idPicking_Order_Detail) {
        this.idPicking_Order_Detail = idPicking_Order_Detail;
    }

    /**
     * @return the delivered
     */
    public Integer getDelivered() {
        return delivered;
    }

    /**
     * @param delivered the delivered to set
     */
    public void setDelivered(Integer delivered) {
        this.delivered = delivered;
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
     * @return the createdAt
     */
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    /**
     * @param createdAt the createdAt to set
     */
    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * @return the updatedAt
     */
    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    /**
     * @param updatedAt the updatedAt to set
     */
    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * @return the locationCellDetail
     */
    public LocationCellDetail getLocationCellDetail() {
        return locationCellDetail;
    }

    /**
     * @param locationCellDetail the locationCellDetail to set
     */
    public void setLocationCellDetail(LocationCellDetail locationCellDetail) {
        this.locationCellDetail = locationCellDetail;
    }

    
    /**
     * @return the pickingOrder
     */
    public PickingOrder getPickingOrder() {
        return pickingOrder;
    }

    /**
     * @param pickingOrder the pickingOrder to set
     */
    public void setPickingOrder(PickingOrder pickingOrder) {
        this.pickingOrder = pickingOrder;
    }


    /**
     * @return the userCreated
     */
    public Integer getUserCreated() {
        return userCreated;
    }

    /**
     * @param userCreated the userCreated to set
     */
    public void setUserCreated(Integer userCreated) {
        this.userCreated = userCreated;
    }

    /**
     * @return the userUpdated
     */
    public Integer getUserUpdated() {
        return userUpdated;
    }

    /**
     * @param userUpdated the userUpdated to set
     */
    public void setUserUpdated(Integer userUpdated) {
        this.userUpdated = userUpdated;
    }

    


}
