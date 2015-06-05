

package Model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;


public class LocationCellDetail {
    private Integer idLocation_Cell_Detail;
    private String description;
    private Integer availability;
    private Integer Location_Cell_idLocation_Cell;
    private Integer Location_Cell_Rack_idRack;
    private Integer Location_Cell_Rack_Warehouse_idWarehouse;
    private Integer idDistribution_Center;            

  
    public Integer getIdLocation_Cell_Detail() {
        return idLocation_Cell_Detail;
    }

  
    public void setIdLocation_Cell_Detail(Integer idLocation_Cell_Detail) {
        this.idLocation_Cell_Detail = idLocation_Cell_Detail;
    }

   
    public String getDescription() {
        return description;
    }

   
    public void setDescription(String description) {
        this.description = description;
    }

   
    public Integer getAvailability() {
        return availability;
    }

    public void setAvailability(Integer availability) {
        this.availability = availability;
    }

    /**
     * @return the Location_Cell_idLocation_Cell
     */
    public Integer getLocation_Cell_idLocation_Cell() {
        return Location_Cell_idLocation_Cell;
    }

    /**
     * @param Location_Cell_idLocation_Cell the Location_Cell_idLocation_Cell to set
     */
    public void setLocation_Cell_idLocation_Cell(Integer Location_Cell_idLocation_Cell) {
        this.Location_Cell_idLocation_Cell = Location_Cell_idLocation_Cell;
    }

    /**
     * @return the Location_Cell_Rack_idRack
     */
    public Integer getLocation_Cell_Rack_idRack() {
        return Location_Cell_Rack_idRack;
    }

    /**
     * @param Location_Cell_Rack_idRack the Location_Cell_Rack_idRack to set
     */
    public void setLocation_Cell_Rack_idRack(Integer Location_Cell_Rack_idRack) {
        this.Location_Cell_Rack_idRack = Location_Cell_Rack_idRack;
    }

    /**
     * @return the Location_Cell_Rack_Warehouse_idWarehouse
     */
    public Integer getLocation_Cell_Rack_Warehouse_idWarehouse() {
        return Location_Cell_Rack_Warehouse_idWarehouse;
    }

    /**
     * @param Location_Cell_Rack_Warehouse_idWarehouse the Location_Cell_Rack_Warehouse_idWarehouse to set
     */
    public void setLocation_Cell_Rack_Warehouse_idWarehouse(Integer Location_Cell_Rack_Warehouse_idWarehouse) {
        this.Location_Cell_Rack_Warehouse_idWarehouse = Location_Cell_Rack_Warehouse_idWarehouse;
    }

    /**
     * @return the idDistribution_Center
     */
    public Integer getIdDistribution_Center() {
        return idDistribution_Center;
    }

    /**
     * @param idDistribution_Center the idDistribution_Center to set
     */
    public void setIdDistribution_Center(Integer idDistribution_Center) {
        this.idDistribution_Center = idDistribution_Center;
    }
    
    
    
}
