package domain;

/**
 *
 * @author ernes
 */
public class Evaluacion {

    private int id;
    private Recurso recurso;
    private Alumno alumno;
    private int calificacion;

    public Evaluacion() {
    }

    public Evaluacion(int id, Recurso recurso, Alumno alumno, int calificacion) {
        this.id = id;
        this.recurso = recurso;
        this.alumno = alumno;
        this.calificacion = calificacion;
    }

    public Evaluacion(int id, Recurso recurso, int calificacion) {
        this.id = id;
        this.recurso = recurso;
        this.calificacion = calificacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Recurso getRecurso() {
        return recurso;
    }

    public void setRecurso(Recurso recurso) {
        this.recurso = recurso;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Evaluacion{");
        sb.append("id=").append(id);
        sb.append(", recurso=").append(recurso);
        sb.append(", alumno=").append(alumno);
        sb.append(", calificacion=").append(calificacion);
        sb.append('}');
        return sb.toString();
    }

}
