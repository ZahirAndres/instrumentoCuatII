package mx.utng.inst.model.service;
import java.util.List;
/**
 * @autor Zahir Andres Rodriguez Mora
 * @category GDS0622
 * @size 17/04/2024
 */
import mx.utng.inst.model.entity.Comentario;

public interface IComentarioService {
    List<Comentario> list();
    void save(Comentario comentario);
    Comentario getByID(Long id);
    void delete(Long id);
}
