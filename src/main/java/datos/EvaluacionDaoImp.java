package datos;

import domain.Evaluacion;
import domain.Recurso;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ernes
 */
public class EvaluacionDaoImp implements EvaluacionDao {

    private static final String SQL_INSERT = "INSERT INTO evaluacion (id_recurso,id_alumno,calificacion) VALUES (?,?,?)";
    private static final String SQL_SELECTBYID = "SELECT * FROM evaluacion WHERE id = ?";
    private static final String SQL_SELECT = "SELECT * FROM evaluacion";

    @Override
    public int insert(Evaluacion evaluacion) {

        int row = 0;
        Connection cn = null;
        PreparedStatement pst = null;
        try {
            cn = Conexion.getConnection();
            pst = cn.prepareStatement(SQL_INSERT);
            pst.setInt(1, evaluacion.getRecurso().getId());
            pst.setString(2, evaluacion.getAlumno().getMatricula());
            pst.setInt(3, evaluacion.getCalificacion());
            row = pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(pst);
            Conexion.close(cn);
        }
        return row;

    }

    @Override
    public int delete(Evaluacion evaluacion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Evaluacion selectById(Evaluacion evaluacion) {
        
        Evaluacion evaluacionBuscada = null;
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            cn = Conexion.getConnection();
            pst = cn.prepareStatement(SQL_SELECTBYID);
            pst.setInt(1, evaluacion.getId());
            rs = pst.executeQuery();
            while (rs.next()) {
                //pendiente a que se debe buscar el nombre del recurso mediante el id 
                //pero aun no tenemos la clase de RecursoDaoImp
            }

        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(pst);
            Conexion.close(cn);
        }
        return evaluacionBuscada;

    }

    

    @Override
    public List<Evaluacion> select() {
        
        List<Evaluacion> evaluaciones = new ArrayList();
         Evaluacion evaluacionBuscada = null;
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            cn = Conexion.getConnection();
            pst = cn.prepareStatement(SQL_SELECT);
            rs = pst.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int idRecurso = rs.getInt("id_recurso");
                String matricula = rs.getString("id_alumno");
                int calificacion = rs.getInt("calificacion");
                evaluacionBuscada = new Evaluacion(id, new Recurso(),calificacion); //agregar datos completos del recruso
                evaluaciones.add(evaluacionBuscada);
            }

        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(pst);
            Conexion.close(cn);
        }
        return evaluaciones;
    }

    @Override
    public int update(Evaluacion evaluacion) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
