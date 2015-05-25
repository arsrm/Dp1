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

public class RequestOrder {
   
    private Integer idRequestOrder;
    private Timestamp dateArrive;
    private Timestamp dateline;
    private Integer idClient;
    private Integer status;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private String requestOrdercol;
    private Integer userCreated;
    private Integer userUpdated;
    private Client clientidClient;
    private PickingOrder pickingOrder;
    private StateRequestOrder stateRequestOrderidStateRequestOrder;
    private List<RequestOrderDetail> requestOrderDetailList;

    public RequestOrder() {
    }

    public Timestamp getDateArrive() {
        return dateArrive;
    }

    public void setDateArrive(Timestamp dateArrive) {
        this.dateArrive = dateArrive;
    }

    public Timestamp getDateline() {
        return dateline;
    }

    public void setDateline(Timestamp dateline) {
        this.dateline = dateline;
    }

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
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

    public String getRequestOrdercol() {
        return requestOrdercol;
    }

    public void setRequestOrdercol(String requestOrdercol) {
        this.requestOrdercol = requestOrdercol;
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

    public Client getClientidClient() {
        return clientidClient;
    }

    public void setClientidClient(Client clientidClient) {
        this.clientidClient = clientidClient;
    }

    public PickingOrder getPickingOrder() {
        return pickingOrder;
    }

    public void setPickingOrder(PickingOrder pickingOrder) {
        this.pickingOrder = pickingOrder;
    }

    public StateRequestOrder getStateRequestOrderidStateRequestOrder() {
        return stateRequestOrderidStateRequestOrder;
    }

    public void setStateRequestOrderidStateRequestOrder(StateRequestOrder stateRequestOrderidStateRequestOrder) {
        this.stateRequestOrderidStateRequestOrder = stateRequestOrderidStateRequestOrder;
    }

    public List<RequestOrderDetail> getRequestOrderDetailList() {
        return requestOrderDetailList;
    }

    public void setRequestOrderDetailList(List<RequestOrderDetail> requestOrderDetailList) {
        this.requestOrderDetailList = requestOrderDetailList;
    }

    /**
     * @return the idRequestOrder
     */
    public Integer getIdRequestOrder() {
        return idRequestOrder;
    }

    /**
     * @param idRequestOrder the idRequestOrder to set
     */
    public void setIdRequestOrder(Integer idRequestOrder) {
        this.idRequestOrder = idRequestOrder;
    }

}
