/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import Model.Rack;
import java.util.List;

/**
 *
 * @author Luigi
 */
public interface DaoRack {
    
    public List<Rack> rackQry(Integer idDistributionCenter, Integer idWarehouse, String idIdentifier);
    
    public void rackIns(Rack rack);
    
    public void rackDel(Rack rack);
    
    public Rack rackGet(String identifier_rack);
    
    public void rackUpd(Rack rack);
    
    public List<Object[]> rackCbo();
    
    
}
