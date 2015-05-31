/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

import java.util.Date;

/**
 *
 * @author Kari
 */
public class Movement {
    private int idMovement;
    private Date date;
    private int type_Movement_id;
    private int type_Movement_idSubtype;
    private int stock_inicial;
    private int stock_final;
    private int idProduct;
    private int idWh;

    public int getType_Movement_idSubtype() {
        return type_Movement_idSubtype;
    }

    public void setType_Movement_idSubtype(int type_Movement_idSubtype) {
        this.type_Movement_idSubtype = type_Movement_idSubtype;
    }

    
    public int getIdMovement() {
        return idMovement;
    }

    public void setIdMovement(int idMovement) {
        this.idMovement = idMovement;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getType_Movement_id() {
        return type_Movement_id;
    }

    public void setType_Movement_id(int type_Movement_id) {
        this.type_Movement_id = type_Movement_id;
    }

    public int getStock_inicial() {
        return stock_inicial;
    }

    public void setStock_inicial(int stock_inicial) {
        this.stock_inicial = stock_inicial;
    }

    public int getStock_final() {
        return stock_final;
    }

    public void setStock_final(int stock_final) {
        this.stock_final = stock_final;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getIdWh() {
        return idWh;
    }

    public void setIdWh(int idWh) {
        this.idWh = idWh;
    }
    
    
    
}
