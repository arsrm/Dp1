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
public class ProductReturn implements Serializable {
    
    private Integer idProduct_Return;
    private Integer quantity;
    private Integer status;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Integer userCreated;
    private Integer userUpdated;
    private MotiveReturn motiveReturnidMotiveReturn;
    private PickingOrderDetail pickingOrderDetail;

    public ProductReturn() {
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

    public MotiveReturn getMotiveReturnidMotiveReturn() {
        return motiveReturnidMotiveReturn;
    }

    public void setMotiveReturnidMotiveReturn(MotiveReturn motiveReturnidMotiveReturn) {
        this.motiveReturnidMotiveReturn = motiveReturnidMotiveReturn;
    }

    public PickingOrderDetail getPickingOrderDetail() {
        return pickingOrderDetail;
    }

    public void setPickingOrderDetail(PickingOrderDetail pickingOrderDetail) {
        this.pickingOrderDetail = pickingOrderDetail;
    }

    /**
     * @return the idProduct_Return
     */
    public Integer getIdProduct_Return() {
        return idProduct_Return;
    }

    /**
     * @param idProduct_Return the idProduct_Return to set
     */
    public void setIdProduct_Return(Integer idProduct_Return) {
        this.idProduct_Return = idProduct_Return;
    }

    
}
