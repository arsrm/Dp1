
package dao;

import Model.PickingOrderDetail;
import java.util.List;


public interface DaoPickingOrderDetail {
    
    public List<PickingOrderDetail> pickingOrderDetailQry(Integer idPickingOrder);
    
    public String pickingOrderDetailIns(PickingOrderDetail pickingOrderDetail);
    
    public String pickingOrderDetailDel(Integer idPickingOrderDetail,Integer idPickingOrder);
    
    public void pickingOrderDetailsetStatus(Integer idPickingOrderDetail,Integer idPickingOrder,Integer status);
    
    public PickingOrderDetail pickingOrderDetailGet(Integer idpickingOrderDetail);
    
    public String pickingOrderDetailUpd(PickingOrderDetail pickingOrderDetail);
    
}
