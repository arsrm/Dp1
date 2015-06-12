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
public class DaoKardexImpl implements DaoKardex {

    private final ConectaDb db;

    public DaoKardexImpl() {
        db = new ConectaDb();
    }

    @Override
    public List<Movement> MovementSearch(Integer idProduct, Integer idwh, Date dateIni, Date dateEnd) {

        String sql = null;
        List<Movement> movimientos = null;

        if (idProduct == null && idwh == null) {
            sql = "SELECT "
                    + "idMovement,"
                    + "date,"
                    + "Type_Movement_idType_Movement, "
                    + "Type_Movement_idSubtype, "
                    + "stock_initial, "
                    + "stock_final, "
                    + "Product_idProduct, "
                    + "Warehouse_idWarehouse "
                    + "FROM Movement "
                    + "WHERE date >= ? "
                    + "AND date <= ?";
        }
        if (idProduct != null && idwh == null) {
            sql = "SELECT "
                    + "idMovement,"
                    + "date,"
                    + "Type_Movement_idType_Movement, "
                    + "Type_Movement_idSubtype, "
                    + "stock_initial, "
                    + "stock_final, "
                    + "Product_idProduct, "
                    + "Warehouse_idWarehouse "
                    + "FROM Movement "
                    + "WHERE date >= ? "
                    + "AND date <= ? "
                    + "AND Product_idProduct = ? ";

        }
        if (idProduct == null && idwh != null) {
            sql = "SELECT "
                    + "idMovement,"
                    + "date,"
                    + "Type_Movement_idType_Movement, "
                    + "Type_Movement_idSubtype, "
                    + "stock_initial, "
                    + "stock_final, "
                    + "Product_idProduct, "
                    + "Warehouse_idWarehouse "
                    + "FROM Movement "
                    + "WHERE date >= ? "
                    + "AND date <= ? "
                    + "AND Warehouse_idWarehouse = ?";
        }
        if (idProduct != null && idwh != null) {
            sql = "SELECT "
                    + "idMovement,"
                    + "date,"
                    + "Type_Movement_idType_Movement, "
                    + "Type_Movement_idSubtype, "
                    + "stock_initial, "
                    + "stock_final, "
                    + "Product_idProduct,4487 "
                    + "Warehouse_idWarehouse "
                    + "FROM Movement "
                    + "WHERE date >= ? "
                    + "AND date <= ? "
                    + "AND Product_idProduct = ? "
                    + "AND Warehouse_idWarehouse = ?";
        }

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setDate(1, new java.sql.Date(dateIni.getTime()));
                ps.setDate(2, new java.sql.Date(dateEnd.getTime()));
                if (idProduct != null && idwh == null) {
                    ps.setInt(3, idProduct);
                }
                if (idProduct == null && idwh != null) {
                    ps.setInt(3, idwh);
                }
                if (idProduct != null && idwh != null) {
                    ps.setInt(3, idProduct);
                    ps.setInt(4, idwh);
                }

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
                    mov.setIdProduct(rs.getInt(7));
                    mov.setIdWh(rs.getInt(8));
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

    @Override
    public String MovementIns(Movement mov) {
        String result = null;
        String sql = "INSERT INTO Movement("
                + "date,"
                + "Type_Movement_idType_Movement,"
                + "Type_Movement_idSubtype,"
                + "stock_initial,"
                + "stock_final,"
                + "Product_idProduct,"
                + "Warehouse_idWarehouse,"
                + "Warehouse_Distribution_Center_idDistribution_Center"
                + ") VALUES(?,?,?,?,?,?,?,?)";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setDate(1, new java.sql.Date(mov.getDate().getTime()));
                ps.setInt(2, mov.getType_Movement_id());
                ps.setInt(3, mov.getType_Movement_idSubtype());
                ps.setInt(4, mov.getStock_inicial());
                ps.setInt(5, mov.getStock_final());
                ps.setInt(6, mov.getIdProduct());
                ps.setInt(7, mov.getIdWh());
                ps.setInt(8, 1);

                int ctos = ps.executeUpdate();

                if (ctos == 0) {
                    throw new SQLException("0 filas afectadas");
                }

            } catch (SQLException e) {
                result = e.getMessage();
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                    result = e.getMessage();
                }
            }
        }
        return result;
    }

    @Override
    public List<Movement> ProductsQry() {
        List<Movement> movimientos = null;
        String sql = "SELECT "
                + "idMovement,"
                + "date,"
                + "Type_Movement_idType_Movement,"
                + "Type_Movement_idSubtype,"
                + "stock_initial,"
                + "stock_final,"
                + "Product_idProduct,"
                + "Warehouse_idWarehouse,"
                + "Warehouse_Distribution_Center_idDistribution_Center "
                + "FROM Movement "
                + "ORDER BY Warehouse_idWarehouse,Product_idProduct ";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();

                movimientos = new LinkedList<>();
                while (rs.next()) {
                    Movement m = new Movement();

                    m.setIdMovement(rs.getInt(1));
                    m.setDate(rs.getDate(2));
                    m.setType_Movement_id(rs.getInt(3));
                    m.setType_Movement_idSubtype(rs.getInt(4));
                    m.setStock_inicial(rs.getInt(5));
                    m.setStock_final(rs.getInt(6));
                    m.setIdProduct(rs.getInt(7));
                    m.setIdWh(rs.getInt(8));

                    movimientos.add(m);
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

    @Override
    public void MovementUpdTypeMov(Integer typeMov, Integer subTypeMov, Integer idMov) {
        String sql = "UPDATE Movement SET "
                + "Type_Movement_idType_Movement=?, "
                + "Type_Movement_idSubtype = ?, "
                + "date = ? "
                + "WHERE idMovement = ? ";
        Connection cn = db.getConnection();
        if (cn != null) {
            try {

                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1, typeMov);
                ps.setInt(2, subTypeMov);
                ps.setDate(3, new java.sql.Date(new Date().getTime()));
                ps.setInt(4, idMov);
                ps.executeUpdate();

            } catch (SQLException e) {
                e.getMessage();

            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    @Override
    public Integer MovementGetMaxId() {
        Integer maxIdProduct = 0;
        String sql = "SELECT "
                + "MAX(idMovement)"
                + "FROM Movement ";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    maxIdProduct = rs.getInt(1);
                }

            } catch (SQLException e) {
                maxIdProduct = 0;
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }

        return maxIdProduct;
    }

}
