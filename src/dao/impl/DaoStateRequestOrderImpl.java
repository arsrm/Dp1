/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.impl;

import Model.StateRequestOrder;
import dao.DaoStateRequestOrder;
import enlaceBD.ConectaDb;
import java.util.List;

/**
 *
 * @author Luis Miguel
 */
public class DaoStateRequestOrderImpl implements DaoStateRequestOrder{
    
    private final ConectaDb db;

    public DaoStateRequestOrderImpl() {
        db = new ConectaDb();
    }

    @Override
    public List<StateRequestOrder> stateRequestOrderQry() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<StateRequestOrder> stateRequestOrderQry_search() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String stateRequestOrderIns(StateRequestOrder client) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String stateRequestOrderDel(List<String> ids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public StateRequestOrder stateRequestOrderGet(int idState) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String clientUpd(StateRequestOrder stateRequest) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
