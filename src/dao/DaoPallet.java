/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;
import Model.Distribution_Center;
import Model.LocationCell;
import Model.LocationCellDetail;
import Model.Pallet;
import Model.PalletProduct;
import Model.Rack;
import Model.Warehouse;
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
    
    public List<String> DetalleCeldaQry(String Cadenacelda);
    
    public Warehouse Warehousename(String nameWR); 
    
    public String PalletIns(Pallet pallet);
   
    public String PalletLocationIns(Integer idpallet,Integer idmarca,Integer  idproduct,Integer  numorden,Integer idCD,
            Integer idware,Integer idrack, Integer idcelda,Integer idceldadet);     
    
    public String PalletDel(Pallet pallet ); 
    
    public String PalletUpd(Pallet pallet);
    
    public Pallet PalletGet(Integer idpallet);
    
    public List<Object[]> PalletCbo();
    
    public Rack Rackid(String identifier ); 
    
    public LocationCell LocationCellid(String description); 
    
    public Pallet GetPallet(LocationCellDetail obj); 
        
    public Integer GetIdwarehouse(Integer idCD, String nameWare);
    
    public Integer GetIdRack(Integer idCD, Integer idware, String namerack); 
    
    public Integer GetIdCelda(Integer idCD, Integer idware, Integer idrackm,  String celda); 
    
    public Integer GetIdCeldaDetail(Integer idCD, Integer idware, Integer idrackm,  Integer idcelda, String celdadetail);

    public Integer ValidaCelda(Integer idCD, Integer idware, Integer idrack, Integer idcelda, Integer idceldadet);
    
    public PalletProduct palletProducLocatioCellDetailGet(Integer idWh, Integer idRack, Integer idLocationCell, Integer idLocationCellDetail);
}
