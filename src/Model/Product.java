/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.sql.Timestamp;

/**
 *
 * @author Gustavo
 */
public class Product {
    
    private Integer idProduct;
    private String trademark;
    private String description;
    private Integer quantityPerBox;
    private Integer weightPerBox;
    private Integer quantityBoxesPerPallet;
    private Integer physicalStock;
    private Integer freeStock; 
    private Timestamp created_at;
    private Timestamp update_at;
    private Timestamp deleted_at;
    private Integer typeProduct;
    private Integer palletId;

    /**
     * @return the idProduct
     */
    public Integer getIdProduct() {
        return idProduct;
    }

    /**
     * @param idProduct the idProduct to set
     */
    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    /**
     * @return the trademark
     */
    public String getTrademark() {
        return trademark;
    }

    /**
     * @param trademark the trademark to set
     */
    public void setTrademark(String trademark) {
        this.trademark = trademark;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the quantityPerBox
     */
    public Integer getQuantityPerBox() {
        return quantityPerBox;
    }

    /**
     * @param quantityPerBox the quantityPerBox to set
     */
    public void setQuantityPerBox(Integer quantityPerBox) {
        this.quantityPerBox = quantityPerBox;
    }

    /**
     * @return the weightPerBox
     */
    public Integer getWeightPerBox() {
        return weightPerBox;
    }

    /**
     * @param weightPerBox the weightPerBox to set
     */
    public void setWeightPerBox(Integer weightPerBox) {
        this.weightPerBox = weightPerBox;
    }

    /**
     * @return the quantityBoxesPerPallet
     */
    public Integer getQuantityBoxesPerPallet() {
        return quantityBoxesPerPallet;
    }

    /**
     * @param quantityBoxesPerPallet the quantityBoxesPerPallet to set
     */
    public void setQuantityBoxesPerPallet(Integer quantityBoxesPerPallet) {
        this.quantityBoxesPerPallet = quantityBoxesPerPallet;
    }

    /**
     * @return the physicalStock
     */
    public Integer getPhysicalStock() {
        return physicalStock;
    }

    /**
     * @param physicalStock the physicalStock to set
     */
    public void setPhysicalStock(Integer physicalStock) {
        this.physicalStock = physicalStock;
    }

    /**
     * @return the freeStock
     */
    public Integer getFreeStock() {
        return freeStock;
    }

    /**
     * @param freeStock the freeStock to set
     */
    public void setFreeStock(Integer freeStock) {
        this.freeStock = freeStock;
    }

    /**
     * @return the created_at
     */
    public Timestamp getCreated_at() {
        return created_at;
    }

    /**
     * @param created_at the created_at to set
     */
    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    /**
     * @return the update_at
     */
    public Timestamp getUpdate_at() {
        return update_at;
    }

    /**
     * @param update_at the update_at to set
     */
    public void setUpdate_at(Timestamp update_at) {
        this.update_at = update_at;
    }

    /**
     * @return the deleted_at
     */
    public Timestamp getDeleted_at() {
        return deleted_at;
    }

    /**
     * @param deleted_at the deleted_at to set
     */
    public void setDeleted_at(Timestamp deleted_at) {
        this.deleted_at = deleted_at;
    }

    /**
     * @return the typeProduct
     */
    public Integer getTypeProduct() {
        return typeProduct;
    }

    /**
     * @param typeProduct the typeProduct to set
     */
    public void setTypeProduct(Integer typeProduct) {
        this.typeProduct = typeProduct;
    }

    /**
     * @return the idPallet
     */
    public Integer getPalletId() {
        return palletId;
    }

    /**
     * @param idPallet the idPallet to set
     */
    public void setPalletId(Integer palletId) {
        this.palletId = palletId;
    }
}
