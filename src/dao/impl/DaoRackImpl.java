/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.impl;


import dao.DaoRack;
import Model.Rack;
import Model.Users;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import enlaceBD.ConectaDb;
/**
 *
 * @author Luigi
 */
public class DaoRackImpl implements DaoRack{
    
   private final ConectaDb db;
   
   public DaoRackImpl() {
        db = new ConectaDb();
   }

    @Override
    public List<Rack> rackQry() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        List<Rack> list = null;
        String sql = "SELECT "
                + "idRack ,"
                + "description "
                + "length "
                + "width "
                + "floor_number "
                + "height_per_floor "
                + "resistance_weight_per_floor "
                + "column_number "
                + "created_at "
                + "update_at "
                + "deleted_at "
                + "Warehouse_idWarehouse"
                + "Warehouse_Distribution_Center_idDistribution_Center "
                + "FROM Rack";
        Connection cn = db.getConnection();
        
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();

                list = new LinkedList<>();
                while (rs.next()) {
                    Rack c = new Rack();

                    c.setIdRack(rs.getInt(1));
                    c.setDescription(rs.getString(2));
                    // men at work
                    list.add(c);
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
    public String rackIns(Rack rack) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String rackDel(List<Integer> ids) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Rack rackGet(Integer idRack) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String rackUpd(Rack rack) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object[]> rackCbo() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
