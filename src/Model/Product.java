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
    private Integer trademark;
    private String name;
    private Integer quantityPerBox;
    private Integer weightPerBox;
    private Integer quantityBoxesPerPallet;
    private Integer physicalStock;
    private Integer freeStock; 
    private Timestamp created_at;
    private Timestamp update_at;    
    private Integer typeConditionWH;
    private String codeEAN13;  
    private Integer status;

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
    public Integer getTrademark() {
        return trademark;
    }

    /**
     * @param trademark the trademark to set
     */
    public void setTrademark(Integer trademark) {
        this.trademark = trademark;
    }

    /**
     * @return the description
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the description to set
     */
    public void setName(String name) {
        this.name = name;
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
     * @return the typeProduct
     */
    public Integer getTypeConditionWH() {
        return typeConditionWH;
    }

    /**
     * @param typeConditionWH the typeProduct to set
     */
    public void setTypeConditionWH(Integer typeConditionWH) {
        this.typeConditionWH = typeConditionWH;
    }

    /**
     * @return the codeEAN13
     */
    public String getCodeEAN13() {
        return codeEAN13;
    }

    /**
     * @param codeEAN13 the codeEAN13 to set
     */
    public void setCodeEAN13(String codeEAN13) {
        this.codeEAN13 = codeEAN13;
    }

    /**
     * @return the status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}
