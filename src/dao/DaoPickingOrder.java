package dao;

import Model.PickingOrder;
import java.util.Date;
import java.util.List;

public interface DaoPickingOrder {
    
    public List<PickingOrder> pickingOrderQry();
    
    public List<PickingOrder> pickingOrderQry_search(Date fi , Date ff);
    
    public String pickingOrderIns(PickingOrder pickingOrder);
    
    public String pickingOrderDel(Integer idPickingOrder);
    
    public PickingOrder pickingOrderGet(Integer idpickingOrder);
    
    public String pickingOrderUpd(PickingOrder pickingOrder);
}
