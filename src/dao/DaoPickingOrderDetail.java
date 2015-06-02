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
    
    public List<PickingOrderDetail> pickingOrderDetailQry(Integer idPickingOrder);
    
    public String pickingOrderDetailIns(PickingOrderDetail pickingOrderDetail);
    
    public String pickingOrderDetailDel(Integer idPickingOrderDetail,Integer idPickingOrder, Integer status);
    
    public PickingOrderDetail pickingOrderDetailGet(Integer idpickingOrderDetail);
    
    public String pickingOrderDetailUpd(PickingOrderDetail pickingOrderDetail);
    
}
