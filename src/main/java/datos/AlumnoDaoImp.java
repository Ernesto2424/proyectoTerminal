package datos;

import domain.Alumno;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ernes
 */
public class AlumnoDaoImp implements AlumnoDao {

    private static final String SQL_INSERT = "INSERT INTO alumno(matricula,nombre,primer_apellido,segundo_apellido,grupo,turno) VALUES(?,?,?,?,?,?)";
    private static final String SQL_SELECTBYID = "SELECT * FROM alumno WHERE matricula = ?";
    private static final String SQL_UPDATE = "UPDATE alumno SET nombre = ?, primer_apellido = ?, segundo_apellido = ?, grupo = ?, turno = ? WHERE matricula=?";

    @Override
    public int insert(Alumno alumno) {

        Connection cn = null;
        PreparedStatement pst = null;
        int rows = 0;
        try {
            cn = Conexion.getConnection();
            if (cn != null) {
                System.out.println("el estado de la conexion es: ");
            }
            pst = cn.prepareStatement(SQL_INSERT);
            pst.setString(1, alumno.getMatricula());
            pst.setString(2, alumno.getNombre());
            pst.setString(3, alumno.getPrimerApellido());
            pst.setString(4, alumno.getSegundoApellido());
            pst.setString(5, alumno.getGrupo());
            pst.setString(6, alumno.getTurno());
            rows = pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlumnoDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(pst);
            Conexion.close(cn);
        }
        return rows;
    }

    @Override
    public int delete(Alumno Alumno) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Alumno selectById(Alumno alumno) {

        Alumno alumnoBuscado = null;
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            cn = Conexion.getConnection();
            pst = cn.prepareStatement(SQL_SELECTBYID);
            pst.setString(1, alumno.getMatricula());
            rs = pst.executeQuery();

            //rs.next();
            rs.absolute(1);
            String matricula = rs.getString("matricula");
            String nombre = rs.getString("nombre");
            String primerApellido = rs.getString("primer_apellido");
            String segundoApellido = rs.getString("segundo_apellido");
            String grupo = rs.getString("grupo");
            String turno = rs.getString("turno");
            alumnoBuscado = new Alumno(matricula, nombre, primerApellido, segundoApellido, grupo, turno);

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlumnoDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(rs);
            Conexion.close(pst);
            Conexion.close(cn);
        }
        return alumnoBuscado;

    }

    @Override
    public int update(Alumno alumno) {

        int row = 0;
        Connection cn = null;
        PreparedStatement pst = null;

        try {
            cn = Conexion.getConnection();
            pst = cn.prepareStatement(SQL_UPDATE);
            pst.setString(1, alumno.getNombre());
            pst.setString(2, alumno.getPrimerApellido());
            pst.setString(3, alumno.getSegundoApellido());
            pst.setString(4, alumno.getGrupo());
            pst.setString(5, alumno.getTurno());
            pst.setString(6, alumno.getMatricula());
            row = pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(pst);
            Conexion.close(cn);
        }
        return row;
    }

}
