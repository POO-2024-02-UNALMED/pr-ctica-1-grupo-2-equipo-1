package gestorAplicacion.inscripcion;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TiendaEscuela implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private List<ArticuloTiendaEscuela> articulos;

    public TiendaEscuela() {
        this.articulos = new ArrayList<>();
    }

    public void agregarArticulo(ArticuloTiendaEscuela articulo) {
        articulos.add(articulo);
    }

    public void eliminarArticulo(int idArticulo) {
        articulos.removeIf(art -> art.getIdArticulo() == idArticulo);
    }

    public List<ArticuloTiendaEscuela> listarArticulos() {
        return articulos;
    }

    public ArticuloTiendaEscuela buscarArticuloPorId(int id) {
        for (ArticuloTiendaEscuela articulo : articulos) {
            if (articulo.getIdArticulo() == id) {
                return articulo;
            }
        }
        return null;
    }
}
