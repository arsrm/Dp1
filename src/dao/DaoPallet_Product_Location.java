package dao;

import Model.Pallet_Product_Location;
import java.util.List;

public interface DaoPallet_Product_Location {

    public List<Pallet_Product_Location> daoPallet_Product_LocationQry();

    public List<Pallet_Product_Location> GetPallet_Product_LocationWhere(String Cadwhere);

    public String daoPallet_Product_LocationIns(Pallet_Product_Location client);
    
    public String daoPallet_Product_LocationDel(List<String> ids);
    
    public Pallet_Product_Location daoPallet_Product_LocationGet(Integer id);
    
    public String daoPallet_Product_LocationUpd(Pallet_Product_Location client);
    
    public String daoPallet_Product_LocationDel(Integer idPallet_Product_Location, Integer idPallet);
    
     public String daoPallet_Product_LocationActivate(Integer idPallet_Product_Location, Integer idPallet);    
    
}

