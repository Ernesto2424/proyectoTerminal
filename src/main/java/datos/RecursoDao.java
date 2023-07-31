package datos;

import domain.Recurso;

/**
 *
 * @author ernes
 */
public interface RecursoDao {

    int insert(Recurso recurso);

    int delete(Recurso recurso);

    Recurso selectById(Recurso recurso);

    int update(Recurso recurso);

    
}
