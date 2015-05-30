/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author Luis Miguel
 */

public class RequestOrderDetail implements Serializable {
    
    private Integer idRequest_Order_Detail;
    private Product product;
    private Integer quantity;
    private Integer status;
    private Date createdAt;
    private Date updatedAt;
    private Integer delivered;
    private Integer remaining;
    private Integer userCreated;
    private Integer userUpdated;
    private RequestOrder requestOrder;

    public RequestOrderDetail() {
    }

   
    public Product getProduct() {
        return product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
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

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getDelivered() {
        return delivered;
    }

    public void setDelivered(Integer delivered) {
        this.delivered = delivered;
    }

    public Integer getRemaining() {
        return remaining;
    }

    public void setRemaining(Integer remaining) {
        this.remaining = remaining;
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

    public void setProduct(Product product) {
        this.product = product;
    }

    public RequestOrder getRequestOrder() {
        return requestOrder;
    }

    public void setRequestOrder(RequestOrder requestOrder) {
        this.requestOrder = requestOrder;
    }

    /**
     * @return the idRequest_Order_Detail
     */
    public Integer getIdRequest_Order_Detail() {
        return idRequest_Order_Detail;
    }

    /**
     * @param idRequest_Order_Detail the idRequest_Order_Detail to set
     */
    public void setIdRequest_Order_Detail(Integer idRequest_Order_Detail) {
        this.idRequest_Order_Detail = idRequest_Order_Detail;
    }

}
