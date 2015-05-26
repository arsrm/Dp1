/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import Model.StateRequestOrder;
import java.util.List;

/**
 *
 * @author Luis Miguel
 */
public interface DaoStateRequestOrder {
    
    public List<StateRequestOrder> stateRequestOrderQry();
    
    public List<StateRequestOrder> stateRequestOrderQry_search();
    
    public String stateRequestOrderIns(StateRequestOrder client);
    
    public String stateRequestOrderDel(List<String> ids);
    
    public StateRequestOrder stateRequestOrderGet(int idState);
    
    public String clientUpd(StateRequestOrder stateRequest);
    
}
