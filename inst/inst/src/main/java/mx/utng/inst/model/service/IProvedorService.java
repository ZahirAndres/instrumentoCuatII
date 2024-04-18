package mx.utng.inst.model.service;
/**
 * @autor Zahir Andres Rodriguez Mora
 * @category GDS0622
 * @size 17/04/2024
 */
import java.util.List;

import mx.utng.inst.model.entity.Provedor;

public interface IProvedorService {
    List<Provedor> list();
    void save(Provedor provedor);
    Provedor getByID(Long id);
    void delete(Long id);
}
