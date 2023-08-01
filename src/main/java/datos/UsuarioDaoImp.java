
package datos;

import domain.Alumno;
import domain.Usuario;
import java.sql.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ernes
 */
public class UsuarioDaoImp implements UsuarioDao{
    
    private static final String SQL_INSERT = "INSERT INTO usuario (tipo,id_alumno,password) VALUES (?,?,?)";
    private static final String SQL_SELECTBYID = "SELECT * FROM usuario WHERE id_alumno = ?";
    private static final String SQL_UPDATE = "UPDATE usuario SET password = ? WHERE id_alumno=?";
    


    @Override
    public int insert(Usuario usuario) {
        
        int row = 0;
        Connection cn = null;
        PreparedStatement pst = null;
        try {
            cn = Conexion.getConnection();
            pst = cn.prepareStatement(SQL_INSERT);
            pst.setInt(1, usuario.getTipo());
            pst.setString(2, usuario.getAlumno().getMatricula());
            pst.setString(3, usuario.getPassword());
           
            row = pst.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(pst);
            Conexion.close(cn);
        }
        return row;
    }

    @Override
    public int delete(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Usuario selectById(Usuario usuario) {
          Usuario usuarioBuscado = null;
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            cn = Conexion.getConnection();
            pst = cn.prepareStatement(SQL_SELECTBYID);
            pst.setString(1, usuario.getAlumno().getMatricula());
            rs = pst.executeQuery();
            
            rs.next(); 
            String password = rs.getString("password");
            usuarioBuscado =new Usuario(new Alumno(usuario.getAlumno().getMatricula()), password);

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(rs);
            Conexion.close(pst);
            Conexion.close(cn);
        }
        return usuarioBuscado;
    }

    @Override
    public int update(Usuario usuario) {
        int row = 0;
        Connection cn = null;
        PreparedStatement pst = null;

        try {
            cn = Conexion.getConnection();
            pst = cn.prepareStatement(SQL_UPDATE);
            pst.setString(1, usuario.getPassword());
            pst.setString(6, usuario.getAlumno().getMatricula());
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
    public List<Usuario> select() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
