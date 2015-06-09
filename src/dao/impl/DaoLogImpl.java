package dao.impl;

import Model.Log;
import Model.LogSystem;
import dao.DaoLog;
import enlaceBD.ConectaDb;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

public class DaoLogImpl implements DaoLog {

    private final ConectaDb db;

    public DaoLogImpl() {
        db = new ConectaDb();
    }

    @Override
    public String clientIns(String mensaje, String clase, Integer iduser) {

        String result = null;
        String sql = "INSERT INTO Log_Security("
                + "date,action ,class, User_idUser,ip,mac_address"
                + ") VALUES(?,?,?,?,?,?)";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                Calendar Cal = Calendar.getInstance();
                String fec = Cal.get(Cal.YEAR) + "/" + (Cal.get(Cal.MONTH) + 1) + "/" + Cal.get(Cal.DATE)
                        + " " + Cal.get(Cal.HOUR_OF_DAY) + ":" + Cal.get(Cal.MINUTE) + ":" + Cal.get(Cal.SECOND);;

                ps.setString(1, fec);
                ps.setString(2, mensaje);
                ps.setString(3, clase);
                ps.setInt(4, iduser);

                InetAddress ip;
                try {

                    ip = InetAddress.getLocalHost();
                    //System.out.println("Current IP address : " + ip.getHostAddress());
                    ps.setString(5, "Current IP address : " + ip.getHostAddress());

                    NetworkInterface network = NetworkInterface.getByInetAddress(ip);

                    byte[] mac = network.getHardwareAddress();

		//System.out.print("Current MAC address : ");
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < mac.length; i++) {
                        sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
                    }
                    //System.out.println(sb.toString());
                    ps.setString(6, "Current MAC address : " + sb.toString());
                } catch (UnknownHostException e) {

                    e.printStackTrace();

                } catch (SocketException e) {

                    e.printStackTrace();

                }

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

    public List<LogSystem> clientQry(){
        List<LogSystem> list = null;
        String sql =  "select idLog_security,date,action,User_idUser,class,ip,mac_address "
                +"From  Log_Security";

        Connection cn = db.getConnection();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();

                list = new LinkedList<>();
                while (rs.next()) {
                    LogSystem c = new LogSystem();
                    c.setIdLog_security(rs.getInt(1));
                
                    c.setDate(rs.getDate(2));
                    c.setAction(rs.getString(3));
                    c.setUser_idUser(rs.getString(4));
                    c.setClasss(rs.getString(5));
                    c.setIp(rs.getString(6));
                    c.setMac_address(rs.getString(7));
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
    
}
