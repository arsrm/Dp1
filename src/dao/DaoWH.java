/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

/**
 *
 * @author CHACON
 */
import Model.Distribution_Center;
import Model.Warehouse;
import java.util.ArrayList;
import java.util.List;
public interface DaoWH {
    
    public ArrayList<Warehouse> whQry();
    
    public ArrayList<Warehouse> whSearchByID(Distribution_Center distribution_center);
    
    public String whIns(Warehouse wh);
    
    public String whsDel(List<Integer> ids);
    
    public Warehouse whGet(Integer idWh);
    
    public String whUpd(Warehouse wh);
   
}
