package datos;

import domain.Alumno;

/**
 *
 * @author ernes
 */
public interface AlumnoDao {

    int insert(Alumno alumno);

    int delete(Alumno Alumno);

    Alumno selectById(Alumno alumno);

    int update(Alumno alumno);

}
