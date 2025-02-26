package tfg.muffinmanager.api.rest_service.modelo.entidades.ids;

import java.util.Objects;

public class MarcaId {

    private String idMarca;
    private int version;

    public MarcaId() {
    }

    public MarcaId(String idMarca, int version) {
        this.idMarca = idMarca;
        this.version = version;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MarcaId other = (MarcaId) obj;
        return idMarca != null && idMarca.equals(other.idMarca) && version == other.version;
            
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMarca, version);
    }

    public String getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(String idMarca) {
        this.idMarca = idMarca;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
