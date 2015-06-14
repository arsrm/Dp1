/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import Model.InternmentOrder;
import Model.InternmentOrderDetail;
import Model.LocationCell;
import Model.LocationCellDetail;
import Model.Movement;
import Model.VirtualWarehouse;
import Model.Warehouse;
import dao.DaoInternmentOrder;
import dao.DaoInternmentOrderDetail;
import dao.DaoKardex;
import dao.DaoLocationCell;
import dao.DaoPalletProduct;
import dao.DaoProducts;
import dao.DaoRack;
import dao.DaoWH;
import dao.daoVirtualWarehouse;
import enlaceBD.ConectaDb;
import java.net.NetworkInterface;
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
    DaoLocationCell daoLocCell = new DaoLocationCellImpl();
    DaoWH daoWh = new DaoWHImpl();
    DaoRack daoRack = new DaoRackImpl();
    DaoPalletProduct daoPalletProduct = new DaoPalletProductImpl();
    DaoProducts daoProduct = new DaoProdImpl();
    DaoKardex daoKardex = new DaoKardexImpl();
    daoVirtualWarehouse daoVirtualWh = new daoVirtualWarehouseImpl();
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
                    ps.setInt(3, idIntOrder);
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

    @Override
    public String IntOrdersIntern(List<Integer> ids) {
        String result = null;
        for (Integer id : ids) {
            result = IntOrderIntern(id);
            IntOrdUpdStatus(id, 2);
        }
        return result;
    }

    public String IntOrderIntern(Integer id) {
        String result = "";
        for (InternmentOrderDetail intOrdDet : IntOrderGet(id).getInternmentOrderDetail()) {
            result += IntOrderDetailIntern(id, intOrdDet);
        }
        return result;
    }

    public String IntOrderIntern(InternmentOrder intOrder) {
        String result = "";
        for (InternmentOrderDetail intOrdDet : intOrder.getInternmentOrderDetail()) {
            result += IntOrderDetailIntern(intOrder.getIdInternmentOrder(), intOrdDet);
        }
        return result;
    }

    public String IntOrderDetailIntern(Integer idIntOrder, InternmentOrderDetail intOrdDetail) {
        String result = "";
        List<LocationCellDetail> freeLocCellList = GetFreeLocationCellsDetail(intOrdDetail.getProduct().getIdProduct());
        List<Integer> palletProduList = daoPalletProduct.GetPalletsByIntOrder(idIntOrder, intOrdDetail.getProduct().getIdProduct());
        Integer cantPalletsIngresados = 0;
        Integer cantFreeLocCells = freeLocCellList.size();
        int lastFreeLocCell = 0;
        Integer stockProd = intOrdDetail.getProduct().getPhysicalStock();
        Integer pesoPallet = intOrdDetail.getProduct().getQuantityBoxesPerPallet() * intOrdDetail.getProduct().getWeightPerBox();
        for (int i = 0; i < palletProduList.size(); i++) {
            Boolean encuentraCeldaDisponible = false;
            for (int j = lastFreeLocCell; j < cantFreeLocCells; j++) {                
                Warehouse wh = daoWh.whGet(freeLocCellList.get(j).getLocation_Cell_Rack_Warehouse_idWarehouse());
                LocationCell locCell = daoLocCell.LocationCellGet(1, freeLocCellList.get(j).getLocation_Cell_Rack_Warehouse_idWarehouse(),
                        freeLocCellList.get(j).getLocation_Cell_Rack_idRack(), freeLocCellList.get(j).getLocation_Cell_idLocation_Cell());
                if (freeLocCellList.get(j).getAvailability() == 1
                        && intOrdDetail.getProduct().getTypeConditionWH()
                        == wh.getType_Condition_WareHouse_idType_Condition_WareHouse()
                        && pesoPallet <= daoRack.rackGet(locCell.getRack_idRack()).getResistance_weigth_per_floor()) {
                    PalletProductLocaCellIns(freeLocCellList.get(j), idIntOrder, palletProduList.get(i), intOrdDetail);
                    freeLocCellList.get(j).setAvailability(0);
                    daoLocCell.LocationCellAvailabilityUpd(1, freeLocCellList.get(j).getLocation_Cell_Rack_Warehouse_idWarehouse(),
                            freeLocCellList.get(j).getLocation_Cell_Rack_idRack(), locCell.getIdLocation_Cell(), freeLocCellList.get(j).getIdLocation_Cell_Detail(), 0);
                    Movement mov = new Movement();
                    mov.setDate(IntOrderGet(idIntOrder).getDate());
                    mov.setIdProduct(intOrdDetail.getProduct().getIdProduct());
                    mov.setIdWh(freeLocCellList.get(j).getLocation_Cell_Rack_Warehouse_idWarehouse());
                    mov.setStock_inicial(stockProd);
                    stockProd += intOrdDetail.getProduct().getQuantityBoxesPerPallet();
                    mov.setStock_final(stockProd);
                    mov.setType_Movement_id(1);
                    mov.setType_Movement_idSubtype(1);
                    daoKardex.MovementIns(mov);
                    cantPalletsIngresados++;
                    lastFreeLocCell = j + 1;
                    encuentraCeldaDisponible = true;
                    break;
                }
            }
            if(encuentraCeldaDisponible==false)
                break;
        }
        
        daoProduct.ProductUpdStock(intOrdDetail.getProduct().getIdProduct(), cantPalletsIngresados, 1);//1 indica Ingreso de productos
        if (cantPalletsIngresados < intOrdDetail.getQuantityPallets()) {
            VirtualWarehouse virtualWh = new VirtualWarehouse();
            virtualWh.setIdIntermentOrder(idIntOrder);
            virtualWh.setIdInternmentOrderDetail(intOrdDetail.getIdInternmentOrderDetail());
            virtualWh.setIdProduct(intOrdDetail.getProduct().getIdProduct());
            virtualWh.setDate(IntOrderGet(idIntOrder).getDate());
            virtualWh.setQuantity(intOrdDetail.getQuantityPallets() - cantPalletsIngresados);
            daoVirtualWh.VirtualWarehouseIns(virtualWh);
            result = virtualWh.getQuantity()+" pallets del producto "+intOrdDetail.getProduct().getName()+
                    " se ingresaron al almacén virtual.\n";
        }

        return result;

    }

    public List<LocationCellDetail> GetFreeLocationCellsDetail(Integer idProduct) {
        List<LocationCellDetail> locCellDetList = null;
        String sql = "SELECT "
                + "idLocation_Cell_Detail,"
                + "description,"
                + "Location_Cell_idLocation_Cell,"
                + "Location_Cell_Rack_idRack,"
                + "Location_Cell_Rack_Warehouse_idWarehouse, "
                + "availability "
                + "FROM Location_Cell_Detail "
                + "WHERE availability=?";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1, 1);
                ResultSet rs = ps.executeQuery();

                locCellDetList = new LinkedList<>();
                while (rs.next()) {
                    LocationCellDetail locCellDetail = new LocationCellDetail();

                    locCellDetail.setIdLocation_Cell_Detail(rs.getInt(1));
                    locCellDetail.setDescription(rs.getString(2));
                    locCellDetail.setLocation_Cell_idLocation_Cell(rs.getInt(3));
                    locCellDetail.setLocation_Cell_Rack_idRack(rs.getInt(4));
                    locCellDetail.setLocation_Cell_Rack_Warehouse_idWarehouse(rs.getInt(5));
                    locCellDetail.setAvailability(rs.getInt(6));
                    locCellDetList.add(locCellDetail);
                }

            } catch (SQLException e) {
                locCellDetList = null;
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }
        return locCellDetList;
    }

    public String PalletProductLocaCellIns(LocationCellDetail locCellDet, Integer idIntOrd, Integer idPalletProduct, InternmentOrderDetail intOrderDetail) {
        String result = null;
        String sql = "INSERT INTO Pallet_By_Product_By_Location_Cell_Detail("
                + "Pallet_By_Product_Pallet_idPallet,"
                + "Pallet_By_Product_Product_Trademark_id_Trademark,"
                + "Pallet_By_Product_Product_idProduct,"
                + "Location_Cell_Detail_idLocation_Cell_Detail,"
                + "Location_Cell_Detail_Location_Cell_idLocation_Cell,"
                + "Location_Cell_Detail_Location_Cell_Rack_idRack,"
                + "Location_Cell_Detail_Location_Cell_Rack_Warehouse_idWarehouse,"
                + "Location_Cell_Detail_idDistribution_Center,"
                + "status"
                + ") VALUES(?,?,?,?,?,?,?,?,?)";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1, idPalletProduct);
                ps.setInt(2, intOrderDetail.getProduct().getTrademark());
                ps.setInt(3, intOrderDetail.getProduct().getIdProduct());
                ps.setInt(4, locCellDet.getIdLocation_Cell_Detail());
                ps.setInt(5, locCellDet.getLocation_Cell_idLocation_Cell());
                ps.setInt(6, locCellDet.getLocation_Cell_Rack_idRack());
                ps.setInt(7, locCellDet.getLocation_Cell_Rack_Warehouse_idWarehouse());
                ps.setInt(8, 1);
                ps.setInt(9, 1);

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

    public void IntOrdUpdStatus(Integer intOrd, Integer status) {
        String sql = "UPDATE Internment_Order SET "
                + "status=? "
                + "WHERE idInternment_Order = ? ";
        Connection cn = db.getConnection();
        if (cn != null) {
            try {

                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setInt(1, status);
                ps.setInt(2, intOrd);
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
    public String IntOrdersInternAdjustManual(List<InternmentOrder> listIntOrd) {
        String result = null;
        for (InternmentOrder intOrd : listIntOrd) {
            result = IntOrderIntern(intOrd);
//            IntOrdUpdStatus(intOrd.getIdInternmentOrder(), 1);
        }
        return result;
    }
}
