package tfg.muffinmanager.api.rest_service.modelo.entidades.ids;

public class ProductoId {

    private String referencia;
    private int version;

    public ProductoId() {
    }

    public ProductoId(String referencia, int version) {
        this.referencia = referencia;
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
        ProductoId other = (ProductoId) obj;
        return referencia != null && referencia.equals(other.referencia) && version == other.version;
            
    }

    @Override
    public int hashCode() {
        return referencia.hashCode() + version;
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

    public void setVersion(int version) {
        this.version = version;
    }
}
