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
    private Integer userCreated;
    private Integer userUpdated;
    private List<ProductReturn> productReturnList;
    private LocationCellDetail locationCellDetail;
    private PickingOrder pickingOrder;
    private Product product;

    public PickingOrderDetail() {
    }


    public Integer getDelivered() {
        return delivered;
    }

    public void setDelivered(Integer delivered) {
        this.delivered = delivered;
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

    public LocationCellDetail getLocationCellDetail() {
        return locationCellDetail;
    }

    public void setLocationCellDetail(LocationCellDetail locationCellDetail) {
        this.locationCellDetail = locationCellDetail;
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

    public List<ProductReturn> getProductReturnList() {
        return productReturnList;
    }

    public void setProductReturnList(List<ProductReturn> productReturnList) {
        this.productReturnList = productReturnList;
    }

    public PickingOrder getPickingOrder() {
        return pickingOrder;
    }

    public void setPickingOrder(PickingOrder pickingOrder) {
        this.pickingOrder = pickingOrder;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
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
   
}
