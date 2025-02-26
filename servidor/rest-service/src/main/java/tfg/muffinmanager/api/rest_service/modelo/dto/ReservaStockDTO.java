package tfg.muffinmanager.api.rest_service.modelo.dto;

import java.time.LocalDateTime;

public class ReservaStockDTO extends MovimientoStockDTO{

    private String destino;

    public ReservaStockDTO() {
    }

    public ReservaStockDTO(String tipo, int numero, String producto, String lote, String impresionPaquete, String responsable,
            LocalDateTime fechaYHora, int unidades, String observaciones, String destino) {
        super(tipo, numero, producto, lote, impresionPaquete, responsable,fechaYHora, unidades, observaciones);
        this.destino = destino;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }
}
