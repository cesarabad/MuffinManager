package tfg.muffinmanager.api.rest_service.servicios;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tfg.muffinmanager.api.rest_service.modelo.dto.ArticuloDTO;
import tfg.muffinmanager.api.rest_service.modelo.entidades.Articulo;
import tfg.muffinmanager.api.rest_service.repositorios.ArticuloRepositorio;
import tfg.muffinmanager.api.rest_service.servicios.interfaces.ArticuloServicio;
import tfg.muffinmanager.api.rest_service.servicios.interfaces.FormaServicio;
import tfg.muffinmanager.api.rest_service.servicios.interfaces.MarcaServicio;
import tfg.muffinmanager.api.rest_service.servicios.interfaces.UsuarioServicio;

@Service
public class ArticuloServicioImpl implements ArticuloServicio {

    @Autowired
    ArticuloRepositorio articuloRepositorio;
    @Autowired
    UsuarioServicio usuarioServicio;
    @Autowired
    FormaServicio formaServicio;
    @Autowired
    MarcaServicio marcaServicio;

    @Override
    public ArticuloDTO guardarArticulo(ArticuloDTO articuloDTO) {
        return articuloRepositorio.save(new Articulo(articuloDTO.getReferencia()
                                ,marcaServicio.obtenerPorId(articuloDTO.getMarca())
                                ,formaServicio.obtenerPorId(articuloDTO.getForma())
                                ,articuloDTO.getDescripcion()
                                ,articuloDTO.getPeso()
                                ,articuloDTO.getUnidadesPorArticulo()
                                ,articuloDTO.getEan13()
                                ,articuloDTO.getLineaProduccion()
                                ,articuloDTO.getVersion()
                                ,Timestamp.valueOf(articuloDTO.getFechaCreacion())
                                ,articuloDTO.getFechaFin() != null ? Timestamp.valueOf(articuloDTO.getFechaFin()) : null
                                ,articuloDTO.isActivo()
                                ,usuarioServicio.dtoToUsuario(usuarioServicio.obtenerPorDni(articuloDTO.getResponsable())))).toDto();
        
    }

    @Override
    public ArrayList<ArticuloDTO> obtenerArticulos() {
        ArrayList<ArticuloDTO> articulos = new ArrayList<>();
        articuloRepositorio.findAll().forEach(articulo -> articulos.add(articulo.toDto()));
        return articulos;
    }


}
