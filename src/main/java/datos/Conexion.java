package datos;

import java.sql.*;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 * Esta clase tiene como objetivo conectar la aplicacion con una base de datos,
 * de igual forma poder desconectar de la base de datos.
 *
 * @author Ernesto F.
 */
public class Conexion {
    /**
     * metodo constructor por defecto
     */
    public Conexion(){}

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/terminal?serverTimezone=UTC";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "admin";

    private static BasicDataSource dataSource;

    /**
     * metodo que nos va permitir realizar la conexion a la base de datos
     *
     * @return regresa una conexion, si hay una existente, regresara la conexion
     * actual, sino va a retornar una conexion nueva
     *
     */
    public static DataSource getDataSource() {
        if (dataSource == null) {
            dataSource = new BasicDataSource();
            dataSource.setUrl(JDBC_URL);
            dataSource.setUsername(JDBC_USER);
            dataSource.setPassword(JDBC_PASSWORD);
            dataSource.setInitialSize(50);
        }

        return dataSource;
    }

    /**
     *
     * metodo que hace la llamada para conectarse a la base de datos
     *
     * @return reresa la conexion, ya sea actual o nueva
     * @throws SQLException excepcion si ocurro del tipo SQL
     */
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        return getDataSource().getConnection();
    }
    
    /**
     * Metodo que permite cerrar el Objeto ResultSet,
     * el cual nos brinda metodos para la obtención de datos
     * de las columnas o filas de la BD.
     * 
     * @param rs Recibe un Objeto del tipo ResultSet.
     */
    public static void close(ResultSet rs) {
        try {
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    /**
     * Metodo que permite cerrar el Objeto PreparedStatement,
     * el cual nos proporciona varios métodos para establecer parámetros,
     * como lo puede ser a las consutas SQL.
     * 
     * @param pst Recibe un Objeto del tipo PreparedStatement.
     */
    public static void close(PreparedStatement pst) {
        try {
            pst.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);

        }
    }

    /**
     * Metodo que nos permite cerrar el Objeto Connection el cual
     * representa una conexión física con la fuente de datos.
     * @param cn Recibe un objteo del tipo Connection.
     */
    public static void close(Connection cn) {
        try {
            cn.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);

        }
    }

}
