/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.impl;

import Model.Movement;
import dao.DaoKardex;
import enlaceBD.ConectaDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Kari
 */
public class DaoKardexImpl implements DaoKardex{

    private final ConectaDb db;
    public DaoKardexImpl() {
         db = new ConectaDb();
    }
    @Override
    public List<Movement> MovementSearch(Integer idProduct, Integer idwh, Date dateIni, Date dateEnd) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String sql = null;
        List<Movement> movimientos = null;
      
            sql = "SELECT "
                    + "idMovement,"
                    + "date,"
                    + "Type_Movement_idType_Movement, "
                    +"Type_Movement_idSubtype, "
                    +"stock_initial, "
                    +"stock_final "
                    + "FROM Movement "
                    + "WHERE date >= ? "
                    + "AND date <= ? "
                    + "AND Warehouse_idWarehouse=? "
                    + "AND Product_idProduct = ?";
        

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
//                java.sql.Date dateIniSql = new java.sql.Date(dateIni.getTime());
                ps.setDate(1, new java.sql.Date(dateIni.getTime()));
                ps.setDate(2, new java.sql.Date(dateEnd.getTime()));
                ps.setInt(3, idwh);
                ps.setInt(4, idProduct);

                ResultSet rs = ps.executeQuery();

                movimientos = new LinkedList<>();
                while (rs.next()) {
                    Movement mov = new Movement();

                    mov.setIdMovement(rs.getInt(1));
                    mov.setDate(rs.getDate(2));
                    mov.setType_Movement_id(rs.getInt(3));
                    mov.setType_Movement_idSubtype(rs.getInt(4));
                    mov.setStock_inicial(rs.getInt(5));
                    mov.setStock_final(rs.getInt(6));
                    mov.setIdProduct(idProduct);
                    mov.setIdWh(idwh);
                    movimientos.add(mov);
                }

            } catch (SQLException e) {
                movimientos = null;
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }
        return movimientos;
    }

    
    
}
