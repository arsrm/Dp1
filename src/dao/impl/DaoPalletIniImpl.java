/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.impl;

import Model.PalletIni;
import Model.PalletState;
import dao.DaoPalletIni;
import enlaceBD.ConectaDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author gzavala
 */
public class DaoPalletIniImpl implements DaoPalletIni{

   private final ConectaDb db;
   
   public DaoPalletIniImpl() {
        db = new ConectaDb();
   }

    @Override
    public List<PalletIni> PalletIniQry() {
        List<PalletIni> list = null;
        String sql = "SELECT "
                + "idPallet, "
                + "status, "
                + "description, "
                + "created_at, "
                + "updated_at, "
                + "Pallet_State_idPallet_Type, "
                + "user_created, "
                + "user_updated "
                + "FROM pallet";
        Connection cn = db.getConnection();
        
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                //System.out.println("Ejecuto select a pallet_state");
                list = new LinkedList<>();
                while (rs.next()) {
                    PalletIni pallet = new PalletIni();
                    pallet.setIdpallet(rs.getInt(1));
                    pallet.setStatusactividad(rs.getInt(2));
                    pallet.setDescription(rs.getString(3));
                    pallet.setCreated_at(rs.getTimestamp(4));
                    pallet.setUpdated_at(rs.getTimestamp(5));
                    pallet.setStatuspallet(rs.getInt(6));
                    pallet.setUser_created(rs.getInt(7));
                    pallet.setUser_updated(rs.getInt(8));
                    list.add(pallet);
                }

            } catch (SQLException e) {
                list = null;
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }
        return list;
    }
    

   
    @Override
    public String PalletIniIns(PalletIni palletini) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String PalletIniDel(PalletIni palletini) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String PalletIniUpd(PalletIni palletini) {

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PalletIni PalletIniGet(Integer idpallet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}