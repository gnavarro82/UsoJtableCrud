package conexion;

import java.sql.*;
import javax.swing.JOptionPane;

public class Conexiones {

    private static Connection cnx = null;

    public static Connection obtener() throws SQLException, ClassNotFoundException {
        if (cnx == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                cnx = DriverManager.getConnection("jdbc:mysql://localhost/muestra", "root", "navarro");
                JOptionPane.showMessageDialog(null, "Conexion exitosa");

            } catch (SQLException ex) {
                throw new SQLException(ex);
            } catch (ClassNotFoundException ex) {
                throw new ClassCastException(ex.getMessage());
            }
        }
        return cnx;
    }

    public Connection getConnection() {
        return cnx;
    }

    public static void cerrar() throws SQLException {
        if (cnx != null) {
            cnx.close();
            JOptionPane.showMessageDialog(null, "Desconexion exitosa");
        }
    }

}//finn
