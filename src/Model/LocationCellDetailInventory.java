/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

/**
 *
 * @author Gustavo
 */
public class LocationCellDetailInventory {
    Integer idWh;
    Integer idRack;
    Integer idRow;
    Integer idColumn;
    Integer idLocationCellDetail;
    Integer availability;
    Integer idPallet;
    Integer idProduct;
    Integer idLocationCell;

    public Integer getIdLocationCell() {
        return idLocationCell;
    }

    public void setIdLocationCell(Integer idLocationCell) {
        this.idLocationCell = idLocationCell;
    }

    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public Integer getIdPallet() {
        return idPallet;
    }

    public void setIdPallet(Integer idPallet) {
        this.idPallet = idPallet;
    }      

    public Integer getIdWh() {
        return idWh;
    }

    public void setIdWh(Integer idWh) {
        this.idWh = idWh;
    }

    public Integer getIdRack() {
        return idRack;
    }

    public void setIdRack(Integer idRack) {
        this.idRack = idRack;
    }

    public Integer getIdRow() {
        return idRow;
    }

    public void setIdRow(Integer idRow) {
        this.idRow = idRow;
    }

    public Integer getIdColumn() {
        return idColumn;
    }

    public void setIdColumn(Integer idColumn) {
        this.idColumn = idColumn;
    }

    public Integer getIdLocationCellDetail() {
        return idLocationCellDetail;
    }

    public void setIdLocationCellDetail(Integer idLocationCellDetail) {
        this.idLocationCellDetail = idLocationCellDetail;
    }

    public Integer getAvailability() {
        return availability;
    }

    public void setAvailability(Integer availability) {
        this.availability = availability;
    }
    
    
}
