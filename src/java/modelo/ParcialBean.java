package modelo;

public class ParcialBean {

    private String id_parcial;
    private String nombre;
    
    public ParcialBean(String id_parcial) {
        this.id_parcial = id_parcial;
    }

    public ParcialBean() {
       
    }

    public String getId_parcial() {
        return id_parcial;
    }

    public void setId_parcial(String id_parcial) {
        this.id_parcial = id_parcial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
