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
    public boolean locationCellInUse(LocationCell locationCell);
    public String LocationCellAvailabilityUpd(Integer idDistCent, Integer idWh, Integer idRack,Integer idLocCell,Integer idLocCellDetail,Integer status);
    public void LocationCellAvailabilityUpd(LocationCell locationCell, Integer statusToChange);
    public Integer idLocatioCellByColumFloor(Integer idWh, Integer idRack, Integer numCol, Integer numFloor);
    public String LocationCellUpdStatus(Integer idRack, Integer status);
}
