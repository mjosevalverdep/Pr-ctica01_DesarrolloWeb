package com.practica01.controller;

import com.practica01.dao.EstadoDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
    
}
