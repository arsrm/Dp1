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
import java.util.List;
import Model.Warehouse;
public interface DaoWH {
    
     public List<Warehouse> whQry();
    
    public String whIns(Warehouse whs);
    
    public String whDel(List<Integer> ids);
    
    public Warehouse whGet(Integer iduser);
    
    public String whUpd(Warehouse warehouse);
   
}
