/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import Model.LocationCell;

/**
 *
 * @author Gustavo
 */
public interface DaoLocationCell {
    
    public LocationCell LocationCellGet(Integer idLocCell);
    public String LocationCellAvailabilityUpd(Integer idDistCent, Integer idWh, Integer idRack,Integer idLocCell,Integer idLocCellDetail,Integer status);
}
