/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import Model.LocationCell;
import Model.Rack;
import java.util.List;

/**
 *
 * @author Gustavo
 */
public interface DaoLocationCell {
    
    public LocationCell LocationCellGet(Integer idDistributionCenter, Integer idWarehouse, Integer idRack, Integer idLocationCell);
    public List<LocationCell> locationCellByRack(Rack rack);
    public void locationCellChangeState(LocationCell locationCell, Integer statusToChange);
    
    public String LocationCellAvailabilityUpd(Integer idDistCent, Integer idWh, Integer idRack,Integer idLocCell,Integer idLocCellDetail,Integer status);
}
