package tfg.muffinmanager.api.rest_service.modelo.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "permiso")
public class Permiso {

    public static final String CREAR_PRODUCTO = "crear_producto";

    @Id
    @Column(length = 20)
    private String nombre;

    public Permiso() {
    }
    public Permiso(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
