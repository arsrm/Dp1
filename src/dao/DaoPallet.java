/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;
import Model.Pallet;
import Model.Warehouse;
import Model.Distribution_Center;
import Model.LocationCellDetail;
import Model.Rack;
import java.util.*;

/**
 *
 * @author gzavala
 */
public interface DaoPallet {

    public List<Pallet>PalletQry();
    
    public List<Distribution_Center>CDQry();
    
    public List<Warehouse>WarehoseQry(String CentroCD);
    
    public List<Rack> RackQry(String cadena); 
    
    public List<String> CeldaQry(String cadrack);
    
    public Warehouse Warehousename(String nameWR); 
    
    public String PalletIns(Pallet pallet);
   
    public String PalletDel(Pallet pallet ); 
    
    public String PalletUpd(Pallet pallet);
    
    public Pallet PalletGet(Integer idpallet);
    
    public List<Object[]> PalletCbo();
    
    public Rack Rackid(String identifier ); 
    
    public Pallet GetPallet(LocationCellDetail obj); 
    

}
