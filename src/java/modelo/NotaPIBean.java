package modelo;

public class NotaPIBean {

    private int id_notapi;
    private String id_pi;
    private int id_coleccion;
    private Double nota;
    
    public NotaPIBean(int id_notapi) {
        this.id_notapi = id_notapi;
    }

    public NotaPIBean() {
       
    }

    public int getId_notapi() {
        return id_notapi;
    }

    public void setId_notapi(int id_notapi) {
        this.id_notapi = id_notapi;
    }

    public String getId_pi() {
        return id_pi;
    }

    public void setId_pi(String id_pi) {
        this.id_pi = id_pi;
    }

    public int getId_coleccion() {
        return id_coleccion;
    }

    public void setId_coleccion(int id_coleccion) {
        this.id_coleccion = id_coleccion;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }
    
}
