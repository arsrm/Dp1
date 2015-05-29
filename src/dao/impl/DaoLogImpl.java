package dao.impl;

import Model.Log;
import dao.DaoLog;
import enlaceBD.ConectaDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

public class DaoLogImpl implements DaoLog{
      private final ConectaDb db;

    public DaoLogImpl() {
        db = new ConectaDb();
    }
     @Override
    public String clientIns(String mensaje, Integer iduser){
       String result = null;
        String sql = "INSERT INTO Log_Security("
                +"date,action ,User_idUser"
                + ") VALUES(?,?,?)";
         
        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                Calendar Cal= Calendar.getInstance(); 
                String fec= Cal.get(Cal.YEAR)+"/"+(Cal.get(Cal.MONTH)+1)+"/"+Cal.get(Cal.DATE); 

                ps.setString(1,fec);
                ps.setString(2,mensaje);
                ps.setInt(3, iduser);
                
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
