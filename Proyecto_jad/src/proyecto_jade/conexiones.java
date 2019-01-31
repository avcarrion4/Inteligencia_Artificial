/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_jade;

import java.sql.*;
import java.sql.Connection;

/**
 *
 * @author Andy
 */
public class conexiones {

    public Connection con;

    public Connection conectar() throws SQLException, ClassNotFoundException {
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/db_agente";
        Class.forName(driver);
        return DriverManager.getConnection(url, "root", "");
    }

    public Connection AbrirConexion() throws ClassNotFoundException, SQLException {
        con = conectar();
        return con;
    }

    public void CerrarConexion() throws SQLException {
        con.close();
    }

}
