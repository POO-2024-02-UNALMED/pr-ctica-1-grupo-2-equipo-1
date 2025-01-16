package gestorAplicacion.servicios;

import java.util.ArrayList;
import java.util.List;

public class TiendaEscuela {
    public List<ArticuloTiendaEscuela> articulos;

    // Constructor
    public TiendaEscuela() {
        this.articulos = new ArrayList<>();
    }

    // Métodos para gestión de artículos
    public void agregarArticulo(ArticuloTiendaEscuela articulo) {
        articulos.add(articulo);
    }

    public void eliminarArticulo(int idArticulo) {
        articulos.removeIf(articulo -> articulo.getIdObjeto() == idArticulo);
    }

    public List<ArticuloTiendaEscuela> listarArticulos() {
        return articulos;
    }

    // Buscar artículo por ID
    public ArticuloTiendaEscuela buscarArticuloPorId(int id) {
        for (ArticuloTiendaEscuela articulo : articulos) {
            if (articulo.getIdObjeto() == id) {
                return articulo;
            }
        }
        return null; // No encontrado
    }
}