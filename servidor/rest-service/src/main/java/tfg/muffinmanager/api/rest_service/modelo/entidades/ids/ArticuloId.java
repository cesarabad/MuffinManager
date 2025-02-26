package tfg.muffinmanager.api.rest_service.modelo.entidades.ids;

import java.io.Serializable;
import java.util.Objects;

public class ArticuloId implements Serializable {
    
    private String referencia;
    private int version;

    public ArticuloId() {
    }

    public ArticuloId(String referencia, int versior) {
        this.referencia = referencia;
        this.version = versior;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ArticuloId other = (ArticuloId) obj;
        return referencia != null && referencia.equals(other.referencia) && version == other.version;
            
    }

    @Override
    public int hashCode() {
        return Objects.hash(referencia, version);
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int versior) {
        this.version = versior;
    }
}
