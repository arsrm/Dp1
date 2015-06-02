/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import Model.VirtualWarehouse;
import dao.daoVirtualWarehouse;
import enlaceBD.ConectaDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Gustavo
 */
public class daoVirtualWarehouseImpl implements daoVirtualWarehouse {

    private final ConectaDb db;

    public daoVirtualWarehouseImpl() {
        db = new ConectaDb();
    }

    @Override
    public String VirtualWarehouseIns(VirtualWarehouse virtualWh) {
        String result = null;
        String sql = "INSERT INTO Virtual_Warehouse("
                + "Internment_Order_Detail_Internment_Order_idInternment_Order,"
                + "Internment_Order_Detail_idInternment_Order_Detail,"
                + "Internment_Order_Detail_Product_idProduct,"
                + "quantity,"
                + "date"
                + ") VALUES(?,?,?,?,?)";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1, virtualWh.getIdIntermentOrder());
                ps.setInt(2, virtualWh.getIdInternmentOrderDetail());
                ps.setInt(3, virtualWh.getIdProduct());
                ps.setInt(4, virtualWh.getQuantity());
                ps.setDate(5, new java.sql.Date(virtualWh.getDate().getTime()));

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

}
