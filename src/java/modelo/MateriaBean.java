
package modelo;


public class MateriaBean {
    private String id_materia;
    private String materia;
    private String id_catedratico;

    public MateriaBean() {
    }

    public MateriaBean(String id_materia) {
        this.id_materia = id_materia;
    }

    public String getId_materia() {
        return id_materia;
    }

    public void setId_materia(String id_materia) {
        this.id_materia = id_materia;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getId_catedratico() {
        return id_catedratico;
    }

    public void setId_catedratico(String id_catedratico) {
        this.id_catedratico = id_catedratico;
    }

      
    
}
