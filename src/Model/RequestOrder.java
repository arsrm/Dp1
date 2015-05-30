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
    private Date dateArrive;
    private Date dateline;
    private Integer status;
    private String requestOrdercol;
    private Integer userCreated;
    private Integer userUpdated;
    private Client client;
    private StateRequestOrder stateRequestOrder;
    private List<RequestOrderDetail> requestOrderDetailList;

    public RequestOrder() {
    }

    public Date getDateArrive() {
        return dateArrive;
    }

    public void setDateArrive(Date dateArrive) {
        this.dateArrive = dateArrive;
    }

    public Date getDateline() {
        return dateline;
    }

    public void setDateline(Date dateline) {
        this.dateline = dateline;
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }


    public StateRequestOrder getStateRequestOrder() {
        return stateRequestOrder;
    }

    public void setStateRequestOrder(StateRequestOrder stateRequestOrder) {
        this.stateRequestOrder = stateRequestOrder;
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
