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
    
    public List<Rack> rackQry();
    
    public String rackIns(Rack rack);
    
    public String rackDel(List<Integer> ids);
    
    public Rack rackGet(Integer idRack);
    
    public String rackUpd(Rack rack);
    
    public List<Object[]> rackCbo();
    
    
}
