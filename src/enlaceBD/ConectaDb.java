package enlaceBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author parainformaticos.com
 */
public class ConectaDb {

    private final String database;

    public Connection getConnection() {
        Connection cn = null;

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            cn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/" + database,
                    "root", "123456");
        } catch (SQLException | ClassNotFoundException 
                | InstantiationException | IllegalAccessException ex) {
        }

        return cn;
    }

    public ConectaDb() {
        this.database = "wms"; // cambiar
    }

    public ConectaDb(String database) {
        this.database = database; 
    }
}

