package tfg.muffinmanager.api.rest_service.modelo.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "impresion_paquete")
public class ImpresionPaquete {

    @Id
    @Column(length = 12)
    private String abreviatura;
    @Column(length = 255, nullable = false)
    private String descripcion;

    public ImpresionPaquete() {
    }

    public ImpresionPaquete(String abreviatura, String descripcion) {
        this.abreviatura = abreviatura;
        this.descripcion = descripcion;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
