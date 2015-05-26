/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import Model.InternmentOrder;
import Model.InternmentOrderDetail;
import dao.DaoInternmentOrder;
import dao.DaoInternmentOrderDetail;
import dao.DaoProducts;
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
 * @author Gustavo
 */
public class DaoInternmentOrderImpl implements DaoInternmentOrder {

    DaoInternmentOrderDetail daoProdIntDet = new DaoInternmentOrderDetailImpl();
    private final ConectaDb db;

    public DaoInternmentOrderImpl() {
        db = new ConectaDb();
    }

    @Override
    public List<InternmentOrder> IntOrderQry() {
        List<InternmentOrder> intOrders = null;
        String sql = "SELECT "
                + "idInternment_Order,"
                + "date,"
                + "status "
                + "FROM Internment_Order";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();

                intOrders = new LinkedList<>();
                while (rs.next()) {
                    List<InternmentOrderDetail> intOrdDetailList = null;
                    InternmentOrder intOrd = new InternmentOrder();
                    intOrdDetailList = daoProdIntDet.IntOrderDetailQry(rs.getInt(1));

                    intOrd.setIdInternmentOrder(rs.getInt(1));
                    intOrd.setDate(rs.getDate(2));
                    intOrd.setStatus(rs.getInt(3));
                    intOrd.setInternmentOrderDetail(intOrdDetailList);
                    intOrders.add(intOrd);
                }

            } catch (SQLException e) {
                intOrders = null;
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }

        return intOrders;
    }

    @Override
    public String IntOrderIns(InternmentOrder intOrder) {
        String result = null;
        String sql = "INSERT INTO Internment_Order("
                + "idInternment_Order,"
                + "date,"
                + "status"
                + ") VALUES(?,?,?)";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1, intOrder.getIdInternmentOrder());
//                java.sql.Date date = new java.sql.Date(intOrder.getDate().getTime());
                ps.setDate(2, new java.sql.Date(intOrder.getDate().getTime()));
                ps.setInt(3, intOrder.getStatus());

                int ctos = ps.executeUpdate();

                for (int i = 0; i < intOrder.getInternmentOrderDetail().size(); i++) {
                    daoProdIntDet.IntOrderDetailIns(intOrder.getIdInternmentOrder(), intOrder.getInternmentOrderDetail().get(i));
                }
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
    public String IntOrderDel(List<Integer> ids) {
        String result = null;

        for (Integer id : ids) {
            result = ProdIntOrderDel(id);
        }

        return result;
    }

    public String ProdIntOrderDel(Integer idOrdInt) {
        String result = null;
        String sql = "UPDATE Internment_Order SET "
                + "status = ? "
                + "WHERE idInternment_Order = ?";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1, 0);//se cambia a cero el campo status
                ps.setInt(2, idOrdInt);

                ps.executeUpdate();
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
    public InternmentOrder IntOrderGet(Integer idIntOrder) {
         InternmentOrder intOrder = null;
         List<InternmentOrderDetail> intOrderDetailList = null;
        String sql = "SELECT "
                + "date,"
                + "status "
                + "FROM Internment_Order WHERE idInternment_Order = ?";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1, idIntOrder);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    intOrder = new InternmentOrder();
                    intOrder.setIdInternmentOrder(idIntOrder);
                    intOrder.setDate(rs.getDate(1));
                    intOrder.setStatus(rs.getInt(2));
                    
                    intOrderDetailList = daoProdIntDet.IntOrderDetailQry(idIntOrder);
                    intOrder.setInternmentOrderDetail(intOrderDetailList);
                }

            } catch (SQLException e) {
                intOrder = null;
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }

        return intOrder;
    }

    @Override
    public List<InternmentOrder> IntOrderSearch(Integer idIntOrder, Date dateIni, Date dateEnd) {        
        String sql = null;
        List<InternmentOrder> intOrders = null;
        if (idIntOrder != 0) {
            sql = "SELECT "
                    + "idInternment_Order,"
                    + "date,"
                    + "status "
                    + "FROM Internment_Order "
                    + "WHERE date >= ? "
                    + "AND date <= ? "
                    + "AND idInternment_Order = ?";
        } else {
            sql = "SELECT "
                    + "idInternment_Order,"
                    + "date,"
                    + "status "
                    + "FROM Internment_Order "
                    + "WHERE date >= ? "
                    + "AND date <= ? ";
        }

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
//                java.sql.Date dateIniSql = new java.sql.Date(dateIni.getTime());
                ps.setDate(1, new java.sql.Date(dateIni.getTime()));
                ps.setDate(2, new java.sql.Date(dateEnd.getTime()));

                if (idIntOrder != 0) {
                    ps.setInt(3,idIntOrder);
                }

                ResultSet rs = ps.executeQuery();

                intOrders = new LinkedList<>();
                while (rs.next()) {
                    InternmentOrder intOrder = new InternmentOrder();

                    intOrder.setIdInternmentOrder(rs.getInt(1));
                    intOrder.setDate(rs.getDate(2));
                    intOrder.setStatus(rs.getInt(3));
                    intOrder.setInternmentOrderDetail(daoProdIntDet.IntOrderDetailQry(rs.getInt(1)));
                    intOrders.add(intOrder);
                }

            } catch (SQLException e) {
                intOrders = null;
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }
        return intOrders;
    }

}
