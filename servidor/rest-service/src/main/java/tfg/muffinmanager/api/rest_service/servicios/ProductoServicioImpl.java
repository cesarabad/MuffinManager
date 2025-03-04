package tfg.muffinmanager.api.rest_service.servicios;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tfg.muffinmanager.api.rest_service.modelo.dto.ProductoDTO;
import tfg.muffinmanager.api.rest_service.modelo.entidades.Producto;
import tfg.muffinmanager.api.rest_service.repositorios.ArticuloRepositorio;
import tfg.muffinmanager.api.rest_service.repositorios.CajaRepositorio;
import tfg.muffinmanager.api.rest_service.repositorios.ProductoRepositorio;
import tfg.muffinmanager.api.rest_service.servicios.interfaces.ProductoServicio;
import tfg.muffinmanager.api.rest_service.servicios.interfaces.UsuarioServicio;

@Service
public class ProductoServicioImpl implements ProductoServicio{
    @Autowired
    ProductoRepositorio productoRepositorio;
    @Autowired
    CajaRepositorio cajaRepositorio;
    @Autowired
    ArticuloRepositorio articuloRepositorio;
    @Autowired
    UsuarioServicio usuarioServicio;

    @Override
    public ProductoDTO guardarProducto(ProductoDTO producto) {

        return productoRepositorio.save(new Producto(producto.getReferencia()
        ,cajaRepositorio.findByEnv(producto.getCaja())
        ,articuloRepositorio.findByReferencia(producto.getArticulo())
        ,producto.getArticulosPorCaja()
        ,producto.getEan14()
        ,producto.getVersion()
        ,Timestamp.valueOf(producto.getFechaCreacion())
        ,producto.getFechaFin() != null ? Timestamp.valueOf(producto.getFechaFin()) : null
        ,producto.isActivo()
        ,usuarioServicio.obtenerEntidadPorDni(producto.getResponsable()))).toDto();
    }

    @Override
    public Producto obtenerProductoPorReferencia(String referencia) {
        return productoRepositorio.findByReferencia(referencia);
    }

    @Override
    public ArrayList<ProductoDTO> obtenerProductos() {
        ArrayList<ProductoDTO> productos = new ArrayList<>();
        productoRepositorio.findAll().forEach(producto -> productos.add(producto.toDto()));
        return productos;
    }


}
