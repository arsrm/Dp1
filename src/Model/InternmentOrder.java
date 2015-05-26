/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Gustavo
 */
public class InternmentOrder {
    private Integer idInternmentOrder;
    private Date date;
    private Integer status;
    private List<InternmentOrderDetail> internmentOrderDetail;

    /**
     * @return the idInternmentOrder
     */
    public Integer getIdInternmentOrder() {
        return idInternmentOrder;
    }

    /**
     * @param idInternmentOrder the idInternmentOrder to set
     */
    public void setIdInternmentOrder(Integer idInternmentOrder) {
        this.idInternmentOrder = idInternmentOrder;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
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
     * @return the internmentOrderDetail
     */
    public List<InternmentOrderDetail> getInternmentOrderDetail() {
        return internmentOrderDetail;
    }

    /**
     * @param internmentOrderDetail the internmentOrderDetail to set
     */
    public void setInternmentOrderDetail(List<InternmentOrderDetail> internmentOrderDetail) {
        this.internmentOrderDetail = internmentOrderDetail;
    }
}
