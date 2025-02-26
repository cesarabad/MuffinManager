package tfg.muffinmanager.api.rest_service.servicios.interfaces;

import java.util.ArrayList;

import tfg.muffinmanager.api.rest_service.modelo.dto.ProductoDTO;
import tfg.muffinmanager.api.rest_service.modelo.entidades.Producto;

public interface ProductoServicio {

    public ProductoDTO guardarProducto(ProductoDTO producto);
    public Producto obtenerProductoPorReferencia(String referencia);
    public ArrayList<ProductoDTO> obtenerProductos();
}
