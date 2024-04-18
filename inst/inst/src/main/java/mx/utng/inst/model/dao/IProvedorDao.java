package mx.utng.inst.model.dao;
import java.util.List;

import mx.utng.inst.model.entity.Provedor;
/**
 * @autor Zahir Andres Rodriguez Mora
 * @category GDS0622
 * @size 17/04/2024
 */
public interface IProvedorDao {

  List<Provedor> list();
  void save(Provedor provedor);
  Provedor getById(Long id);
  void delete(Long id);
  
} 