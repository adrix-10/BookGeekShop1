/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.project.BookGeekShop.controller;

import com.project.BookGeekShop.service.LibroService;
import com.project.BookGeekShop.service.NovelaGraficaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class IndexController {
    @Autowired
    LibroService libroService;

    @Autowired
    NovelaGraficaService novelaGraficaService;

    @GetMapping("/")
    public String DespliegueDeArticulos(Model model) {
        var libros = libroService.getLibros();
        model.addAttribute("libros", libros);
        var novelasGraficas = novelaGraficaService.getNovelaGraficas();
        model.addAttribute("novelasGraficas", novelasGraficas);

        return "index";
    }
}

