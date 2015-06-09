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
    private Integer idDispatch_Order;
    public Integer idClient;
    public Date return_date;
    private Integer Motive_Return_idMotive_Return;
    private Integer Picking_Order_Detail_idPicking_Order_Detail;
    private Integer Picking_Order_Detail_Picking_Order_idPicking_Order;
    private Integer Picking_Order_Detail_Product_idProduct;

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

    /**
     * @return the quantity
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
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
     * @return the Motive_Return_idMotive_Return
     */
    public Integer getMotive_Return_idMotive_Return() {
        return Motive_Return_idMotive_Return;
    }

    /**
     * @param Motive_Return_idMotive_Return the Motive_Return_idMotive_Return to set
     */
    public void setMotive_Return_idMotive_Return(Integer Motive_Return_idMotive_Return) {
        this.Motive_Return_idMotive_Return = Motive_Return_idMotive_Return;
    }

    /**
     * @return the Picking_Order_Detail_idPicking_Order_Detail
     */
    public Integer getPicking_Order_Detail_idPicking_Order_Detail() {
        return Picking_Order_Detail_idPicking_Order_Detail;
    }

    /**
     * @param Picking_Order_Detail_idPicking_Order_Detail the Picking_Order_Detail_idPicking_Order_Detail to set
     */
    public void setPicking_Order_Detail_idPicking_Order_Detail(Integer Picking_Order_Detail_idPicking_Order_Detail) {
        this.Picking_Order_Detail_idPicking_Order_Detail = Picking_Order_Detail_idPicking_Order_Detail;
    }

    /**
     * @return the Picking_Order_Detail_Picking_Order_idPicking_Order
     */
    public Integer getPicking_Order_Detail_Picking_Order_idPicking_Order() {
        return Picking_Order_Detail_Picking_Order_idPicking_Order;
    }

    /**
     * @param Picking_Order_Detail_Picking_Order_idPicking_Order the Picking_Order_Detail_Picking_Order_idPicking_Order to set
     */
    public void setPicking_Order_Detail_Picking_Order_idPicking_Order(Integer Picking_Order_Detail_Picking_Order_idPicking_Order) {
        this.Picking_Order_Detail_Picking_Order_idPicking_Order = Picking_Order_Detail_Picking_Order_idPicking_Order;
    }

    /**
     * @return the Picking_Order_Detail_Product_idProduct
     */
    public Integer getPicking_Order_Detail_Product_idProduct() {
        return Picking_Order_Detail_Product_idProduct;
    }

    /**
     * @param Picking_Order_Detail_Product_idProduct the Picking_Order_Detail_Product_idProduct to set
     */
    public void setPicking_Order_Detail_Product_idProduct(Integer Picking_Order_Detail_Product_idProduct) {
        this.Picking_Order_Detail_Product_idProduct = Picking_Order_Detail_Product_idProduct;
    }

    /**
     * @return the idDispatch_Order
     */
    public Integer getIdDispatch_Order() {
        return idDispatch_Order;
    }

    /**
     * @param idDispatch_Order the idDispatch_Order to set
     */
    public void setIdDispatch_Order(Integer idDispatch_Order) {
        this.idDispatch_Order = idDispatch_Order;
    }

    /**
     * @return the idClient
     */
    public Integer getIdClient() {
        return idClient;
    }

    /**
     * @param idClient the idClient to set
     */
    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    /**
     * @return the return_date
     */
    public Date getReturn_date() {
        return return_date;
    }

    /**
     * @param return_date the return_date to set
     */
    public void setReturn_date(Date return_date) {
        this.return_date = return_date;
    }
    
}
