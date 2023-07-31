
package domain;

/**
 *
 * @author ernes
 */
public class Alumno {
    
    private String matricula;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private String grupo;
    private String turno;
    
    public Alumno(){}

    public Alumno(String matricula, String nombre, String primerApellido, String segundoApellido, String grupo, String turno) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.grupo = grupo;
        this.turno = turno;
    }

    public Alumno(String nombre, String primerApellido, String segundoApellido, String grupo, String turno) {
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.grupo = grupo;
        this.turno = turno;
    }

    public Alumno(String matricula) {
        this.matricula = matricula;
    }
    
    

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Alumno{");
        sb.append("matricula=").append(matricula);
        sb.append(", nombre=").append(nombre);
        sb.append(", primerApellido=").append(primerApellido);
        sb.append(", segundoApellido=").append(segundoApellido);
        sb.append(", grupo=").append(grupo);
        sb.append(", turno=").append(turno);
        sb.append('}');
        return sb.toString();
    }
    
    

}
