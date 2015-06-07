/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import Model.DispatchOrder;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Luis Miguel
 */
public interface DaoDispatchOrder {
    
    public List<DispatchOrder> dispatchOrderQry();
    
    public List<DispatchOrder> dispatchOrderQry_search(Integer id , Date dateFrom, Date dateTo, Integer index_status);
    
    public List<DispatchOrder> dispatchOrderQry_search(Integer numOrder);
    
    public String dispatchOrderIns(DispatchOrder dispatchOrder);
    
    public String dispatchOrdersDel(List<Integer> ids);
    
    public String dispatchOrderDel(Integer idDispatchOrder);
    
    public DispatchOrder dispatchOrderGet(Integer idispatchOrder);
    
    public String dispatchOrderUpd(DispatchOrder dispatchOrder);
    
    
}
