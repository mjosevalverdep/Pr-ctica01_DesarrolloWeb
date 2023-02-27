package com.practica01.service;

import com.practica01.dao.EstadoDao;
import com.practica01.domain.estado;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EstadoServiceImpl implements EstadoService {

    @Autowired
    EstadoDao estadoDao;

    @Override
    @Transactional(readOnly = true)
    public List<estado> getEstados() {
        return (List<estado>) estadoDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public estado getEstado(estado estado) {
        return estadoDao.findById(estado.getIdEstado()).orElse(null);
    }

    @Override
    public void save(estado estado) {
        estadoDao.save(estado);
    }

    @Override
    @Transactional
    public void delete(estado estado) {
        estadoDao.deleteById(estado.getIdEstado());
    }
}
