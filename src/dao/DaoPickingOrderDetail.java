/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import Model.PickingOrderDetail;
import java.util.List;

/**
 *
 * @author Luis Miguel
 */
public interface DaoPickingOrderDetail {
    
    public List<PickingOrderDetail> pickingOrderDetailQry();
    
    public List<PickingOrderDetail> pickingOrderDetailQry_search();
    
    public String pickingOrderDetailIns(PickingOrderDetail pickingOrderDetail);
    
    public String pickingOrderDetailDel(List<String> ids);
    
    public PickingOrderDetail pickingOrderDetailGet(String idpickingOrderDetail);
    
    public String pickingOrderDetailUpd(PickingOrderDetail pickingOrderDetail);
    
}
