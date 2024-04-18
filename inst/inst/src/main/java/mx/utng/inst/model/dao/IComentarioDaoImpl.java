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
import mx.utng.inst.model.entity.Comentario;

@Repository
public class IComentarioDaoImpl implements IComentarioDao {
    @Autowired
private EntityManager em;


    @Override
    public List<Comentario> list() {
        
        return em.createQuery("from Comentario", Comentario.class).getResultList();
    }
    @Override
    public void save(Comentario comentario) {
        if(comentario.getId()!= null && comentario.getId()>0){

            em.merge(comentario);
        }else{
            em.persist(comentario);
        }
        
    }
    @Override
    public Comentario getById(Long id) {
        return em.find(Comentario.class, id);
    }
    @Override
    public void delete(Long id) {
        Comentario comentario = getById(id);
        em.remove(comentario);
    }
    
}
