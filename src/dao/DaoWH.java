/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import Model.Warehouse;
import java.util.List;

/**
 *
 * @author mibisaoficina
 */
import Model.Distribution_Center;
import Model.Warehouse;
import java.util.ArrayList;
import java.util.List;
public interface DaoWH {
    
    public List<Warehouse> whQry();
    
    public String whIns(Warehouse wh);
    
    public String whsDel(Integer idWarehouse, Integer status);    
    
    public Warehouse whGet(Integer idWh);
    
    public String whUpd(Warehouse wh);
    
    public ArrayList<Warehouse> whSearchByID(Distribution_Center distribution_center);
    
    public List<Warehouse> whSearch(Integer idWh, Integer idTypeCondition);
    public Integer whGetMaxId();
    
    public boolean warehouseInUse(Integer idWarehouse);
    
}
