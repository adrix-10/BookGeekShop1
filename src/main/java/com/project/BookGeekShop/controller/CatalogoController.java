package com.project.BookGeekShop.controller;

import com.project.BookGeekShop.service.LibroService;
import com.project.BookGeekShop.service.NovelaGraficaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/catalogo")
public class CatalogoController {

    @Autowired
    LibroService libroService;

    @Autowired
    NovelaGraficaService novelaGraficaService;

    @GetMapping("CatalogoLibros")
    public String catalogoLibros(Model model) {
        var libros = libroService.getLibros();
        model.addAttribute("libros", libros);

        return "/catalogo/CatalogoLibros.html";
    }

    @GetMapping("CatalogoNovelasGraficas")
    public String catalogoNovelasGraficas(Model model) {
        var novelasGraficas = novelaGraficaService.getNovelaGraficas();
        model.addAttribute("novelasGraficas", novelasGraficas);

        return "/catalogo/CatalogoNovelasGraficas.html";

    }
}
