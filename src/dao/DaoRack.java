/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import Model.LocationCell;
import Model.LocationCellDetail;
import Model.Rack;
import java.util.List;

/**
 *
 * @author Luigi
 */
public interface DaoRack {
    
    public List<Rack> rackQry(Integer idDistributionCenter, Integer idWarehouse, String idIdentifier);    
    public void rackIns(Rack rack);    
    public int rackDel(Integer idRack, Integer statusToChange);    
    public Rack rackGet(Integer idRack);    
    public void rackUpd(Rack rack);    
    public List<Object[]> rackCbo();    
    public boolean existsRackName(String rackName);
    public boolean rackInUse(Rack rack);
    public int rackMaxIdGet();
    public void rackLocationCellsIns(LocationCell locationCell);
    public void rackLocationCellDetailIns(LocationCellDetail locationCellDetail);
    
}
