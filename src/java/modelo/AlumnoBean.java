
package modelo;


public class AlumnoBean {
    private String id_alumno;
    private String id_persona;
    private String id_carrera;

    public AlumnoBean(String id_alumno) {
        this.id_alumno = id_alumno;
    }

    public AlumnoBean() {
    }

    public String getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(String id_alumno) {
        this.id_alumno = id_alumno;
    }

    public String getId_persona() {
        return id_persona;
    }

    public void setId_persona(String id_persona) {
        this.id_persona = id_persona;
    }

    public String getId_carrera() {
        return id_carrera;
    }

    public void setId_carrera(String id_carrera) {
        this.id_carrera = id_carrera;
    }
    
}
