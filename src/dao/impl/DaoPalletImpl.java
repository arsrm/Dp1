/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.impl;
import Model.Pallet;
import dao.DaoPallet;
import java.util.*;
import java.sql.*;
import enlaceBD.ConectaDb;


/**
 *
 * @author gzavala
 */
public class DaoPalletImpl implements DaoPallet{

   private final ConectaDb db;
   
   public DaoPalletImpl() {
        db = new ConectaDb();
   }

    @Override
    public List<Pallet> PalletQry() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String PalletIns(Pallet pallet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String PalletDel(Pallet pallet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String PalletUpd(Pallet pallet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Pallet PalletGet(Integer idpallet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object[]> PalletCbo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
