
package dao;

import Model.LocationCell;
import Model.LocationCellDetail;
import Model.Rack;
import java.util.List;


public interface DaoLocationCellDetail {
    
    public LocationCellDetail locationCellDetailGet(Integer id );
    
    public String locationCellDetailDel(List<Integer> ids);
    
    public String locationCellDetailUpd(LocationCellDetail users);
    
     public String locationCellDetailIns(LocationCellDetail users);
     
     public LocationCellDetail locationCellDetailQry(Integer idLocationCellDetail, Integer idLocationCell);

     public String locationCellDetailUpdAvailability(Integer idRack, Integer status);
}
