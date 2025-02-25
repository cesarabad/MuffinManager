package tfg.muffinmanager.api.rest_service.modelo.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "caja")
public class Caja {

    @Id
    @Column(length = 20)
    private String env;
    @Column(length = 80, nullable = false)
    private String descripcion;
    @Column(name = "baseeuropeo")
    private Integer baseEuropeo;
    @Column(name = "baseamericano")
    private Integer baseAmericano;
    @Column(name = "alturadefecto")
    private Integer alturaDefecto;

    public Caja() {
    }

    public Caja(String env, String descripcion, int baseEuropeo, int baseAmericano, int alturaDefecto) {
        this.env = env;
        this.descripcion = descripcion;
        this.baseEuropeo = baseEuropeo;
        this.baseAmericano = baseAmericano;
        this.alturaDefecto = alturaDefecto;
    }

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getBaseEuropeo() {
        return baseEuropeo;
    }

    public void setBaseEuropeo(int baseEuropeo) {
        this.baseEuropeo = baseEuropeo;
    }

    public int getBaseAmericano() {
        return baseAmericano;
    }

    public void setBaseAmericano(int baseAmericano) {
        this.baseAmericano = baseAmericano;
    }

    public int getAlturaDefecto() {
        return alturaDefecto;
    }

    public void setAlturaDefecto(int alturaDefecto) {
        this.alturaDefecto = alturaDefecto;
    }
}
