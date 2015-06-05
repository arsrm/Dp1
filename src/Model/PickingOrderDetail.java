package Model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class PickingOrderDetail {

    
    
    private Integer idPicking_Order_Detail;
    private Integer status;
    private Integer  Picking_Order_idPicking_Order;
    private Integer idPallet_By_Product_By_Location_Cell_Detail;

    public PickingOrderDetail() {

    }
    public Integer getIdPicking_Order_Detail() {
        return idPicking_Order_Detail;
    }

    public void setIdPicking_Order_Detail(Integer idPicking_Order_Detail) {
        this.idPicking_Order_Detail = idPicking_Order_Detail;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPicking_Order_idPicking_Order() {
        return Picking_Order_idPicking_Order;
    }

    public void setPicking_Order_idPicking_Order(Integer Picking_Order_idPicking_Order) {
        this.Picking_Order_idPicking_Order = Picking_Order_idPicking_Order;
    }

    public Integer getIdPallet_By_Product_By_Location_Cell_Detail() {
        return idPallet_By_Product_By_Location_Cell_Detail;
    }

    public void setIdPallet_By_Product_By_Location_Cell_Detail(Integer idPallet_By_Product_By_Location_Cell_Detail) {
        this.idPallet_By_Product_By_Location_Cell_Detail = idPallet_By_Product_By_Location_Cell_Detail;
    }

    

    
}
