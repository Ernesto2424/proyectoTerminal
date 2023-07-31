
package datos;

import domain.Evaluacion;
import java.util.List;

/**
 *
 * @author ernes
 */
public interface EvaluacionDao {
    
    int insert(Evaluacion evaluacion);

    int delete(Evaluacion evaluacion);

    Evaluacion selectById(Evaluacion evaluacion);

    int update(Evaluacion evaluacion);

    List<Evaluacion> select();

}
