
package dao;

import Model.PickingOrderDetail;
import java.util.List;


public interface DaoPickingOrderDetail {
    
    public List<PickingOrderDetail> pickingOrderDetailQry(Integer idPickingOrder);
    
    public String pickingOrderDetailIns(PickingOrderDetail pickingOrderDetail);
    
    public String pickingOrderDetailDel(Integer idPickingOrderDetail,Integer idPickingOrder, Integer status);
    
    public PickingOrderDetail pickingOrderDetailGet(Integer idpickingOrderDetail);
    
    public List<PickingOrderDetail> pickingOrderDetailFind(Integer orderpallet , Integer numpallet , Integer codProd);
    
    public String pickingOrderDetailAssignToDispatch(Integer idPickingOrderDetail,Integer idPickingOrder);

    public String pickingOrderDetailReturnToWarehouse(Integer idPickingOrderDetail,Integer idPickingOrder);
}
