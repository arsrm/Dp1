/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import Model.Trademark;
import dao.DaoTrademark;
import enlaceBD.ConectaDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Gustavo
 */
public class DaoTrademarkImpl implements DaoTrademark {

    private final ConectaDb db;

    public DaoTrademarkImpl() {
        db = new ConectaDb();
    }

    @Override
    public List<Trademark> TrademarkQry() {
        List<Trademark> trademarkList = null;
        String sql = "SELECT "
                + "id_Trademark,"
                + "name "
                + "FROM Trademark";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();

                trademarkList = new LinkedList<>();
                while (rs.next()) {
                    Trademark t = new Trademark();

                    t.setId_Trademark(rs.getInt(1));
                    t.setName(rs.getString(2));
                    
                    trademarkList.add(t);
                }

            } catch (SQLException e) {
                trademarkList = null;
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }

        return trademarkList;
    }

    @Override
    public String trademarkIns(Trademark trademark) {
        String result = null;
        String sql = "INSERT INTO Trademark("
                + "id_Trademark,"
                + "name"
                + ") VALUES(?,?)";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1, trademark.getId_Trademark());
                ps.setString(2, trademark.getName());                

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
    public Integer trademarkGetMaxId() {
        Integer maxIdTrademark=0;
        String sql = "SELECT "
                + "MAX(id_Trademark)"
                + "FROM Trademark ";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                
                while (rs.next()) {
                    maxIdTrademark = rs.getInt(1);
                }

            } catch (SQLException e) {
                maxIdTrademark = 0;
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }

        return maxIdTrademark;
    }

}
