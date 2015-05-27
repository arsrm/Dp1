/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.impl;
import Model.PalletState;
import Model.Rack;
import dao.DaoPalletState;
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
public class DaoPalletStateImpl implements DaoPalletState {

   private final ConectaDb db;
   
   public DaoPalletStateImpl() {
        db = new ConectaDb();
   }

    @Override
    public List<PalletState> PalletStateQry() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        List<PalletState> list = null;
        String sql = "SELECT "
                + "idPallet_State, "
                + "description, "
                + "status, "
                + "created_at, "
                + "updated_at, "
                + "user_created, "
                + "user_updated "
                + "FROM pallet_state";
        Connection cn = db.getConnection();
        
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                //System.out.println("Ejecuto select a pallet_state");
                list = new LinkedList<>();
                while (rs.next()) {
                    PalletState palletstate = new PalletState();
                    palletstate.setIdPallet_State(rs.getInt(1));
                    palletstate.setDescription(rs.getString(2));
                    palletstate.setStatus(rs.getInt(3));
                    palletstate.setCreated_at(rs.getTimestamp(4));
                    palletstate.setUpdated_at(rs.getTimestamp(5));
                    palletstate.setUser_created(rs.getInt(6));
                    palletstate.setUser_updated(rs.getInt(7));
                    list.add(palletstate);
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
    public String PalletStateIns(PalletState pallet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String PalletStateDel(PalletState pallet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String PalletStateUpd(PalletState pallet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PalletState PalletStateGet(Integer idpalletstate) {
        PalletState objpalletstate=null; 
        String sql = "SELECT "
                + "idPallet_State, "
                + "description, "
                + "status, "
                + "created_at, "
                + "updated_at, "
                + "user_created, "
                + "user_updated "
                + "FROM pallet_state  where idPallet_State="+idpalletstate+" ";
        Connection cn = db.getConnection();
        
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                //System.out.println("Ejecuto select a pallet_state");
                while (rs.next()) {
                    objpalletstate = new PalletState();
                    objpalletstate.setIdPallet_State(rs.getInt(1));
                    objpalletstate.setDescription(rs.getString(2));
                    objpalletstate.setStatus(rs.getInt(3));
                    objpalletstate.setCreated_at(rs.getTimestamp(4));
                    objpalletstate.setUpdated_at(rs.getTimestamp(5));
                    objpalletstate.setUser_created(rs.getInt(6));
                    objpalletstate.setUser_updated(rs.getInt(7));
                }

            } catch (SQLException e) {
                objpalletstate = null;
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }
        return objpalletstate;
        
    }

    @Override
    public List<Object[]> PalletStateCbo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer PalletStateIdGet(String description) {
        Integer idpalletstate=0; 
        String sql = "SELECT "
                + "distinct(idPallet_State) "
                + "FROM pallet_state  where description='"+description+"'";
        Connection cn = db.getConnection();
        
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                //System.out.println("Ejecuto select a pallet_state");
                while (rs.next()) {
                    idpalletstate=rs.getInt(1);
                }

            } catch (SQLException e) {
                idpalletstate = 0;
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }
        return idpalletstate;
    }
    
    
}
