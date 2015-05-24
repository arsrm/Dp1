/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.impl;

import Model.Product;
import Model.Type_Condition_WareHouse;
import dao.DaoTypeConditionWH;
import enlaceBD.ConectaDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author CHACON
 */
public class DaoTypeConditionWHImpl implements DaoTypeConditionWH{

    private final ConectaDb db;

    public DaoTypeConditionWHImpl() {
        db = new ConectaDb();
    }
    
    @Override
    public List<Type_Condition_WareHouse> tcwhQry() {
        List<Type_Condition_WareHouse> typeConditionList= null;
        String sql = "SELECT "
                + "idType_Condition,"
                + "description,"
                + "status "
                + "FROM Type_Condition";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();

                typeConditionList = new LinkedList<>();
                while (rs.next()) {
                    Type_Condition_WareHouse tc = new Type_Condition_WareHouse();
                    
                    tc.setIdType_Condition_WareHouse(rs.getInt(1));
                    tc.setDescription(rs.getString(2));
                    tc.setStatus(rs.getInt(3));

                    typeConditionList.add(tc);
                }

            } catch (SQLException e) {
                typeConditionList = null;
            } finally {
                try {
                    cn.close();
                } catch (SQLException e) {
                }
            }
        }

        return typeConditionList;
    }



    
}
