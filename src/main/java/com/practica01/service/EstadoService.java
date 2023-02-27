package com.practica01.service;

import com.practica01.domain.estado;
import java.util.List;

public interface EstadoService {
    
    public List<estado> getEstados();
    
    public estado getEstado(estado estado);
    
    public void save(estado estado); //para insertar y modificar
   
    public void delete(estado estado);
}
