/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import Model.DispatchOrder;
import java.util.List;

/**
 *
 * @author Luis Miguel
 */
public interface DaoDispatchOrder {
     public List<DispatchOrder> dispatchOrderQry();
    
    public List<DispatchOrder> dispatchOrderQry_search();
    
    public String dispatchOrderIns(DispatchOrder dispatchOrder);
    
    public String dispatchOrderDel(List<String> ids);
    
    public DispatchOrder dispatchOrderGet(String iddispatchOrder);
    
    public String dispatchOrderUpd(DispatchOrder dispatchOrder);
    
    
}
