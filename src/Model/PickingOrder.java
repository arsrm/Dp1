package Model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class PickingOrder {

    private Integer idPickingOrder;
    private Date date;
    private Integer status;
    private Integer idRequest_Order;
    

    public PickingOrder() {

    }

    public Integer getIdPickingOrder() {
        return idPickingOrder;
    }

    public void setIdPickingOrder(Integer idPickingOrder) {
        this.idPickingOrder = idPickingOrder;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIdRequest_Order() {
        return idRequest_Order;
    }

    public void setIdRequest_Order(Integer idRequest_Order) {
        this.idRequest_Order = idRequest_Order;
    }

    
}
