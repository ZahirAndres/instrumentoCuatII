package mx.utng.inst.model.dao;
import java.util.List;

import mx.utng.inst.model.entity.Comentario;
/**
 * @autor Zahir Andres Rodriguez Mora
 * @category GDS0622
 * @size 17/04/2024
 */
public interface IComentarioDao {
    List<Comentario> list();
  void save(Comentario comentario);
  Comentario getById(Long id);
  void delete(Long id);
}
