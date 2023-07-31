package domain;

/**
 *
 * @author ernes
 */
public class Usuario {

  private int id;
  private int tipo;
  private Alumno alumno;
  private String password;

    public Usuario(int id, int tipo, Alumno alumno, String password) {
        this.id = id;
        this.tipo = tipo;
        this.alumno = alumno;
        this.password = password;
    }

    public Usuario(int tipo, Alumno alumno, String password) {
        this.tipo = tipo;
        this.alumno = alumno;
        this.password = password;
    }

    
    public Usuario(Alumno alumno, String password) {
        this.alumno = alumno;
        this.password = password;
    }
    
    
  
  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
  
  

}
