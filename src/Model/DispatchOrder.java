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

public class DispatchOrder implements Serializable {
    
    private Integer idDispatch_Order;
    private Integer idClient;
    private Date departureDate;
    private Date arrivalDate;
    private Integer status;
    private Integer idPickingOrder;

    public DispatchOrder() {
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
     * @return the departureDate
     */
    public Date getDepartureDate() {
        return departureDate;
    }

    /**
     * @param departureDate the departureDate to set
     */
    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    /**
     * @return the arrivalDate
     */
    public Date getArrivalDate() {
        return arrivalDate;
    }

    /**
     * @param arrivalDate the arrivalDate to set
     */
    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
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
     * @return the idPickingOrder
     */
    public Integer getIdPickingOrder() {
        return idPickingOrder;
    }

    /**
     * @param idPickingOrder the idPickingOrder to set
     */
    public void setIdPickingOrder(Integer idPickingOrder) {
        this.idPickingOrder = idPickingOrder;
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

   

    
}
