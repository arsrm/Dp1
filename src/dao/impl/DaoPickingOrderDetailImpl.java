/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.impl;

import Model.PickingOrderDetail;
import dao.DaoPickingOrderDetail;
import java.util.List;

/**
 *
 * @author Luis Miguel
 */
public class DaoPickingOrderDetailImpl implements DaoPickingOrderDetail{

    @Override
    public List<PickingOrderDetail> pickingOrderDetailQry(Integer idPickingOrder) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    
    }

    @Override
    public String pickingOrderDetailIns(PickingOrderDetail pickingOrderDetail) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String pickingOrderDetailDel(Integer idPickingOrderDetail, Integer idPickingOrder,Integer status) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PickingOrderDetail pickingOrderDetailGet(Integer idpickingOrderDetail) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String pickingOrderDetailUpd(PickingOrderDetail pickingOrderDetail) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
