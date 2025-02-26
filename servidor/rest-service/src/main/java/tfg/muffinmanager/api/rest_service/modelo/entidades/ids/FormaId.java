package tfg.muffinmanager.api.rest_service.modelo.entidades.ids;

import java.util.Objects;

public class FormaId {

    private String idForma;
    private int version;

    public FormaId() {
    }

    public FormaId(String idForma, int version) {
        this.idForma = idForma;
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
        FormaId other = (FormaId) obj;
        return idForma != null && idForma.equals(other.idForma) && version == other.version;
            
    }

    @Override
    public int hashCode() {
        return Objects.hash(idForma, version);
    }

    public String getIdForma() {
        return idForma;
    }

    public void setIdForma(String idForma) {
        this.idForma = idForma;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
