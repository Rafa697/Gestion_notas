
package modelo;


public class CatedraticoBean {
    private String id_catedratico;
    private String id_persona;
    private String titulo;

    public CatedraticoBean(String id_catedratico) {
        this.id_catedratico = id_catedratico;
    }

    public CatedraticoBean() {
    }

    public String getId_catedratico() {
        return id_catedratico;
    }

    public void setId_catedratico(String id_catedratico) {
        this.id_catedratico = id_catedratico;
    }

    public String getId_persona() {
        return id_persona;
    }

    public void setId_persona(String id_persona) {
        this.id_persona = id_persona;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    
}
