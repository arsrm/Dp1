
package dao;

import Model.LocationCell;
import Model.LocationCellDetail;
import Model.LocationCellDetailInventory;
import Model.Rack;
import java.util.List;


public interface DaoLocationCellDetail {
    
    public LocationCellDetail locationCellDetailGet(Integer idWh, Integer idRack, Integer idLocCell,Integer idLocCellDet );
    
    public String locationCellDetailDel(List<Integer> ids);
    
    public String locationCellDetailUpd(LocationCellDetail users);
    
     public String locationCellDetailIns(LocationCellDetail users);
     
     public LocationCellDetail locationCellDetailQry(Integer idLocationCellDetail, Integer idLocationCell);

     public String locationCellDetailUpdAvailability(Integer idRack, Integer status);
     
     public List<LocationCellDetailInventory> locationCellDetailInventory(Integer idWh);
}
