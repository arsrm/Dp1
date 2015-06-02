/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;
import java.sql.*;
import java.util.*;

/**
 *
 * @author gzavala
 */
public class Pallet {
    
    Integer idPallet; 
    Integer status;
    Timestamp created_at;
    Timestamp updated_at;
    Integer Pallet_State_idPallet_Type;
    String  Location_Cell_Detail_idLocation_Cell_Detail="";    
    Integer Location_Cell_Detail_Pallet_idPallet; 
    Integer Location_Cell_Detail_Location_Cell_idLocation_Cell;
    Integer Location_Cell_Detail_Location_Cell_Rack_idRack; 
    Integer Location_Cell_Detail_Location_Cell_Rack_Warehouse_idWarehouse; 
    Integer idDistribution_Center; 
    Integer user_created;
    Integer user_updated;
    Integer Product_idProduct; 
    Integer Product_Trademark_id_Trademark; 

    public Pallet(Integer idPallet, Integer status, Timestamp created_at, Timestamp updated_at, Integer Pallet_State_idPallet_Type, Integer Location_Cell_Detail_Pallet_idPallet, Integer Location_Cell_Detail_Location_Cell_idLocation_Cell, Integer Location_Cell_Detail_Location_Cell_Rack_idRack, Integer Location_Cell_Detail_Location_Cell_Rack_Warehouse_idWarehouse, Integer idDistribution_Center, Integer user_created, Integer user_updated, Integer Product_idProduct, Integer Product_Trademark_id_Trademark) {
        this.idPallet = idPallet;
        this.status = status;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.Pallet_State_idPallet_Type = Pallet_State_idPallet_Type;
        this.Location_Cell_Detail_Pallet_idPallet = Location_Cell_Detail_Pallet_idPallet;
        this.Location_Cell_Detail_Location_Cell_idLocation_Cell = Location_Cell_Detail_Location_Cell_idLocation_Cell;
        this.Location_Cell_Detail_Location_Cell_Rack_idRack = Location_Cell_Detail_Location_Cell_Rack_idRack;
        this.Location_Cell_Detail_Location_Cell_Rack_Warehouse_idWarehouse = Location_Cell_Detail_Location_Cell_Rack_Warehouse_idWarehouse;
        this.idDistribution_Center = idDistribution_Center;
        this.user_created = user_created;
        this.user_updated = user_updated;
        this.Product_idProduct = Product_idProduct;
        this.Product_Trademark_id_Trademark = Product_Trademark_id_Trademark;
    }

    
    public Pallet() {
    }

    public Integer getIdPallet() {
        return idPallet;
    }


    public void setIdPallet(Integer idPallet) {
        this.idPallet = idPallet;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }

    public Integer getPallet_State_idPallet_Type() {
        return Pallet_State_idPallet_Type;
    }

    public void setPallet_State_idPallet_Type(Integer Pallet_State_idPallet_Type) {
        this.Pallet_State_idPallet_Type = Pallet_State_idPallet_Type;
    }

    public String getLocation_Cell_Detail_idLocation_Cell_Detail() {
        return Location_Cell_Detail_idLocation_Cell_Detail;
    }

    public void setLocation_Cell_Detail_idLocation_Cell_Detail(String Location_Cell_Detail_idLocation_Cell_Detail) {
        this.Location_Cell_Detail_idLocation_Cell_Detail = Location_Cell_Detail_idLocation_Cell_Detail;
    }

    public Integer getLocation_Cell_Detail_Pallet_idPallet() {
        return Location_Cell_Detail_Pallet_idPallet;
    }

    public void setLocation_Cell_Detail_Pallet_idPallet(Integer Location_Cell_Detail_Pallet_idPallet) {
        this.Location_Cell_Detail_Pallet_idPallet = Location_Cell_Detail_Pallet_idPallet;
    }

    public Integer getLocation_Cell_Detail_Location_Cell_idLocation_Cell() {
        return Location_Cell_Detail_Location_Cell_idLocation_Cell;
    }

    public void setLocation_Cell_Detail_Location_Cell_idLocation_Cell(Integer Location_Cell_Detail_Location_Cell_idLocation_Cell) {
        this.Location_Cell_Detail_Location_Cell_idLocation_Cell = Location_Cell_Detail_Location_Cell_idLocation_Cell;
    }

    public Integer getLocation_Cell_Detail_Location_Cell_Rack_idRack() {
        return Location_Cell_Detail_Location_Cell_Rack_idRack;
    }

    public void setLocation_Cell_Detail_Location_Cell_Rack_idRack(Integer Location_Cell_Detail_Location_Cell_Rack_idRack) {
        this.Location_Cell_Detail_Location_Cell_Rack_idRack = Location_Cell_Detail_Location_Cell_Rack_idRack;
    }

    public Integer getLocation_Cell_Detail_Location_Cell_Rack_Warehouse_idWarehouse() {
        return Location_Cell_Detail_Location_Cell_Rack_Warehouse_idWarehouse;
    }

    public void setLocation_Cell_Detail_Location_Cell_Rack_Warehouse_idWarehouse(Integer Location_Cell_Detail_Location_Cell_Rack_Warehouse_idWarehouse) {
        this.Location_Cell_Detail_Location_Cell_Rack_Warehouse_idWarehouse = Location_Cell_Detail_Location_Cell_Rack_Warehouse_idWarehouse;
    }

    public Integer getIdDistribution_Center() {
        return idDistribution_Center;
    }

    public void setIdDistribution_Center(Integer idDistribution_Center) {
        this.idDistribution_Center = idDistribution_Center;
    }


    public Integer getUser_created() {
        return user_created;
    }

    public void setUser_created(Integer user_created) {
        this.user_created = user_created;
    }

    public Integer getUser_updated() {
        return user_updated;
    }

    public void setUser_updated(Integer user_updated) {
        this.user_updated = user_updated;
    }

    public Integer getProduct_idProduct() {
        return Product_idProduct;
    }

    public void setProduct_idProduct(Integer Product_idProduct) {
        this.Product_idProduct = Product_idProduct;
    }

    public Integer getProduct_Trademark_id_Trademark() {
        return Product_Trademark_id_Trademark;
    }

    public void setProduct_Trademark_id_Trademark(Integer Product_Trademark_id_Trademark) {
        this.Product_Trademark_id_Trademark = Product_Trademark_id_Trademark;
    }
    
}
