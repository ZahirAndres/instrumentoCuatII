package mx.utng.inst.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
/**
 * @autor Zahir Andres Rodriguez Mora
 * @category GDS0622
 * @size 17/04/2024
 */
import jakarta.persistence.EntityManager;
import mx.utng.inst.model.entity.Provedor;
@Repository
public class IProvedorDaoImpl implements IProvedorDao{
@Autowired
private EntityManager em;


    @Override
    public List<Provedor> list() {
        
        return em.createQuery("from Provedor", Provedor.class).getResultList();
    }
    @Override
    public void save(Provedor provedor) {
        if(provedor.getId()!= null && provedor.getId()>0){
            em.merge(provedor);
        }else{
            em.persist(provedor);
        }
        
    }
    @Override
    public Provedor getById(Long id) {
        return em.find(Provedor.class, id);
    }
    @Override
    public void delete(Long id) {
        Provedor provedor = getById(id);
        em.remove(provedor);
    }
    
}
