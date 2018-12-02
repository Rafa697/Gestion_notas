
package modelo;

public class CicloBean {
    private String id_ciclo;
    private String ciclo;

    public CicloBean(String id_ciclo) {
        this.id_ciclo = id_ciclo;
    }

    public CicloBean() {
    }

    public String getId_ciclo() {
        return id_ciclo;
    }

    public void setId_ciclo(String id_ciclo) {
        this.id_ciclo = id_ciclo;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }
    
}
