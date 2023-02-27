package com.practica01.controller;

import com.practica01.dao.EstadoDao;
import com.practica01.domain.Estado;
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
    EstadoService EstadoService;
    
    @GetMapping("/")
    public String inicio(Model model) {
        log.info("Estamos Utilizando MVC");
        
        var estados = estadoDao.findAll();
        model.addAttribute("estados",estados);
        return "index";
    }
    
    @GetMapping("/nuevoEstado")
    public String nuevoEstado(Estado estado){
        EstadoService.save(estado);
        return "modificarEstado";
    }
    
    @PostMapping("/guardarEstado")
    public String guardarEstado(Estado estado){
        return "redirect:/";
    }
    
    @GetMapping("/modificarEstado/{idEstado}")
    public String modificarEstado(Estado estado, Model model){
        estado = EstadoService.getEstado(estado);
        model.addAttribute("estado", estado);
        return "modificarEstado";
    }
    
    @GetMapping("/eliminarEstado/{idEstado}")
    public String eliminarEstado(Estado estado){
        EstadoService.delete(estado);
        return "redirect:/";
    }
}
