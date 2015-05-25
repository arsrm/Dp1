/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author Luis Miguel
 */
public class LocationCellDetail {
    private Integer idLocation_Cell_Detail;
    private String description;
    private Integer availability;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Integer userCreated;
    private Integer userUpdated;
    private LocationCell locationCell;
    //private List<PalletByProductByLocationCellDetail> palletByProductByLocationCellDetailList;
    private List<PickingOrderDetail> pickingOrderDetailList;

    public LocationCellDetail() {
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

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getUserCreated() {
        return userCreated;
    }

    public void setUserCreated(Integer userCreated) {
        this.userCreated = userCreated;
    }

    public Integer getUserUpdated() {
        return userUpdated;
    }

    public void setUserUpdated(Integer userUpdated) {
        this.userUpdated = userUpdated;
    }

    public LocationCell getLocationCell() {
        return locationCell;
    }

    public void setLocationCell(LocationCell locationCell) {
        this.locationCell = locationCell;
    }

    /*public List<PalletByProductByLocationCellDetail> getPalletByProductByLocationCellDetailList() {
        return palletByProductByLocationCellDetailList;
    }

    public void setPalletByProductByLocationCellDetailList(List<PalletByProductByLocationCellDetail> palletByProductByLocationCellDetailList) {
        this.palletByProductByLocationCellDetailList = palletByProductByLocationCellDetailList;
    }
    */
    public List<PickingOrderDetail> getPickingOrderDetailList() {
        return pickingOrderDetailList;
    }

    public void setPickingOrderDetailList(List<PickingOrderDetail> pickingOrderDetailList) {
        this.pickingOrderDetailList = pickingOrderDetailList;
    }


    /**
     * @return the idLocation_Cell_Detail
     */
    public Integer getIdLocation_Cell_Detail() {
        return idLocation_Cell_Detail;
    }

    /**
     * @param idLocation_Cell_Detail the idLocation_Cell_Detail to set
     */
    public void setIdLocation_Cell_Detail(Integer idLocation_Cell_Detail) {
        this.idLocation_Cell_Detail = idLocation_Cell_Detail;
    }
    
}
