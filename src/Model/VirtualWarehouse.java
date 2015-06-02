/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.util.Date;

/**
 *
 * @author Gustavo
 */
public class VirtualWarehouse {
    private Integer idIntermentOrder;
    private Integer idInternmentOrderDetail;
    private Integer idProduct;
    private Integer quantity;
    private Date date;

    public Integer getIdIntermentOrder() {
        return idIntermentOrder;
    }

    public void setIdIntermentOrder(Integer idIntermentOrder) {
        this.idIntermentOrder = idIntermentOrder;
    }

    public Integer getIdInternmentOrderDetail() {
        return idInternmentOrderDetail;
    }

    public void setIdInternmentOrderDetail(Integer idInternmentOrderDetail) {
        this.idInternmentOrderDetail = idInternmentOrderDetail;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
}
