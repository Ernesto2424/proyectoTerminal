/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package datos;

import domain.Usuario;
import java.util.List;

/**
 *
 * @author ernes
 */
public interface UsuarioDao {

    int insert(Usuario usuario);

    int delete(Usuario usuario);

    Usuario selectById(Usuario usuario);

    int update(Usuario usuario);

    List<Usuario> select();

}
