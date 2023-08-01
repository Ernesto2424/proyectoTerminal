
package datos;

import domain.Recurso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ernes
 */
public class RecursoDaoImp implements RecursoDao{
    
    
    private static final String SQL_INSERT = "INSERT INTO recurso (nombre,descripcion,tipo) VALUES (?,?,?)";
    private static final String SQL_SELECTBYID = "SELECT * FROM recurso WHERE id = ?";
    private static final String SQL_UPDATE = "UPDATE recurso SET nombre = ?, descripcion = ?, tipo = ? WHERE id = ?";

    @Override
    public int insert(Recurso recurso) {
        int row = 0;
        Connection cn = null;
        PreparedStatement pst = null;
        try {
            cn = Conexion.getConnection();
            pst = cn.prepareStatement(SQL_INSERT);
           pst.setString(1,recurso.getNombre() );
           pst.setString(2,recurso.getDescripcion());
           pst.setString(3,recurso.getTipo());
            row = pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RecursoDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(pst);
            Conexion.close(cn);
        }
        return row;
    }

    @Override
    public int delete(Recurso recurso) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Recurso selectById(Recurso recurso) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int update(Recurso recurso) {
        int row = 0;
        Connection cn = null;
        PreparedStatement pst = null;

        try {
            cn = Conexion.getConnection();
            pst = cn.prepareStatement(SQL_UPDATE);
            pst.setString(1, recurso.getNombre());
            pst.setString(2, recurso.getDescripcion());
            pst.setString(3, recurso.getTipo());
            pst.setInt(4, recurso.getId());
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
