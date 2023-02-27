package com.practica01.controller;

import com.practica01.dao.EstadoDao;
import com.practica01.domain.estado;
import com.practica01.service.EstadoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class IndexController {
    
    @Autowired
    EstadoDao estadoDao;
    
    @GetMapping("/")
    public String inicio(Model model) {
        log.info("Estamos Utilizando MVC");
        
        var estados = estadoDao.findAll();
        model.addAttribute("estados",estados);
        return "index";
    }
    
    @GetMapping("/nuevoEstado")
    public String nuevoEstado(estado estado){
        return "modificarEstado";
    }
    
    @PostMapping("/guardarEstado")
    public String guardarEstado(estado estado){
        EstadoService.save(estado);
        return "redirect:/";
    }
    
    @GetMapping("/modificarEstado/{idEstado}")
    public String modificarEstado(estado estado, Model model){
        estado = EstadoService.getEstado(estado);
        model.addAttribute("estado", estado);
        return "modificarEstado";
    }
    
    @GetMapping("/eliminarEstado/{idEstado}")
    public String eliminarEstado(estado estado){
        EstadoService.delete(cliente);
        return "redirect:/";
    }
}
