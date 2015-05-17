/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.sql.Timestamp;

/**
 *
 * @author CHACON
 */
public class Warehouse {
    private Integer idWarehouse;
    private String description;
    private Timestamp created_at;
    private Timestamp update_at;
    private Timestamp deleted_at;
    private Integer Type_Condition_WareHouse_idType_Condition_WareHouse;
    private Integer Type_Product_idType_Product;
    private Integer Distribution_Center_idDistribution_Center;
    private String Warehousecol;

    public Integer getIdWarehouse() {
        return idWarehouse;
    }

    public void setIdWH(Integer idWarehouse) {
        this.idWarehouse = idWarehouse;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(Timestamp update_at) {
        this.update_at = update_at;
    }

    public Timestamp getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(Timestamp deleted_at) {
        this.deleted_at = deleted_at;
    }

    public Integer getType_Condition_WareHouse_idType_Condition_WareHouse() {
        return Type_Condition_WareHouse_idType_Condition_WareHouse;
    }

    public void setType_Condition_WareHouse_idType_Condition_WareHouse(Integer Type_Condition_WareHouse_idType_Condition_WareHouse) {
        this.Type_Condition_WareHouse_idType_Condition_WareHouse = Type_Condition_WareHouse_idType_Condition_WareHouse;
    }

    public Integer getType_Product_idType_Product() {
        return Type_Product_idType_Product;
    }

    public void setType_Product_idType_Product(Integer Type_Product_idType_Product) {
        this.Type_Product_idType_Product = Type_Product_idType_Product;
    }

    public Integer getDistribution_Center_idDistribution_Center() {
        return Distribution_Center_idDistribution_Center;
    }

    public void setDistribution_Center_idDistribution_Center(Integer Distribution_Center_idDistribution_Center) {
        this.Distribution_Center_idDistribution_Center = Distribution_Center_idDistribution_Center;
    }

    public String getWarehousecol() {
        return Warehousecol;
    }

    public void setWarehousecol(String Warehousecol) {
        this.Warehousecol = Warehousecol;
    }
    
}
