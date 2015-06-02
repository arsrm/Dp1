/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import Model.PickingOrder;
import java.util.List;

/**
 *
 * @author Luis Miguel
 */
public interface DaoPickingOrder {
    
    public List<PickingOrder> pickingOrderQry();
    
    public List<PickingOrder> pickingOrderQry_search();
    
    public String pickingOrderIns(PickingOrder pickingOrder);
    
    public String pickingOrderDel(Integer idPickingOrder);
    
    public PickingOrder pickingOrderGet(Integer idpickingOrder);
    
    public String pickingOrderUpd(PickingOrder pickingOrder);
}
