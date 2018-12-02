
package modelo;

public class CarreraBean {
    private String id_carrera;
    private String carrera;

    public CarreraBean(String id_carrera) {
        this.id_carrera = id_carrera;
    }

    public CarreraBean() {
    }

    public String getId_carrera() {
        return id_carrera;
    }

    public void setId_carrera(String id_carrera) {
        this.id_carrera = id_carrera;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
    
}
