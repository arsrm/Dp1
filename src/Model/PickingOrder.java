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

public class PickingOrder{
    private Integer idPickingOrder;
    private Timestamp date;
    private Integer status;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Integer userCreated;
    private Integer userUpdated;
    private List<RequestOrder> requestOrderList;
    private List<DispatchOrder> dispatchOrderList;
    private List<PickingOrderDetail> pickingOrderDetailList;

    public PickingOrder() {
    }

    public PickingOrder(Integer idPickingOrder) {
        this.idPickingOrder = idPickingOrder;
    }

    public Integer getIdPickingOrder() {
        return idPickingOrder;
    }

    public void setIdPickingOrder(Integer idPickingOrder) {
        this.idPickingOrder = idPickingOrder;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreatedAt() {
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

    public List<DispatchOrder> getDispatchOrderList() {
        return dispatchOrderList;
    }

    public void setDispatchOrderList(List<DispatchOrder> dispatchOrderList) {
        this.dispatchOrderList = dispatchOrderList;
    }

    public List<PickingOrderDetail> getPickingOrderDetailList() {
        return pickingOrderDetailList;
    }

    public void setPickingOrderDetailList(List<PickingOrderDetail> pickingOrderDetailList) {
        this.pickingOrderDetailList = pickingOrderDetailList;
    }

    
}
