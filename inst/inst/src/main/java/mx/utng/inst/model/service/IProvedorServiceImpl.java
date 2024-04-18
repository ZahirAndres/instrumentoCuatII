package mx.utng.inst.model.service;
/**
 * @autor Zahir Andres Rodriguez Mora
 * @category GDS0622
 * @size 17/04/2024
 */
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.utng.inst.model.dao.IProvedorDao;
import mx.utng.inst.model.entity.Provedor;

@Service
public class IProvedorServiceImpl implements IProvedorService{

    @Autowired
    private IProvedorDao dao;

    @Transactional(readOnly = true)
    @Override
    public List<Provedor> list() {
        return dao.list();
    }
    @Transactional
    @Override
    public void save(Provedor provedor) {
    dao.save(provedor);    
    }
    @Transactional(readOnly = true)
    @Override
    public Provedor getByID(Long id) {
        return dao.getById(id);
    }
    @Transactional
    @Override
    public void delete(Long id) {
        dao.delete(id);
    }
}
