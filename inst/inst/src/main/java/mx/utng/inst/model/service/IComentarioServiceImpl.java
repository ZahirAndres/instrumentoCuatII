package mx.utng.inst.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.utng.inst.model.dao.IComentarioDao;
import mx.utng.inst.model.entity.Comentario;
/**
 * @autor Zahir Andres Rodriguez Mora
 * @category GDS0622
 * @size 17/04/2024
 */
@Service
public class IComentarioServiceImpl implements IComentarioService{

    @Autowired
    private IComentarioDao dao;

    @Transactional(readOnly = true)
    @Override
    public List<Comentario> list() {
        return dao.list();
    }
    @Transactional
    @Override
    public void save(Comentario comentario) {
    dao.save(comentario);    
    }
    @Transactional(readOnly = true)
    @Override
    public Comentario getByID(Long id) {
        return dao.getById(id);
    }
    @Transactional
    @Override
    public void delete(Long id) {
        dao.delete(id);
    }
    
}
