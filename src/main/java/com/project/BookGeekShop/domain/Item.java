package com.project.BookGeekShop.domain;

import lombok.Data;

@Data
public class Item extends Libro{
    private int cantidad; //Almacenar la cantidad de items de un articulo

    public Item() {
    }

    public Item(Libro libro) {
        super.getIdLibro(libro.getIdLibro());
        super.getAutor(libro.getAutor());
        super.setDescripcion(articulo.getDescripcion());
        super.setDetalle(articulo.getDetalle());
        super.setPrecio(articulo.getPrecio());
        super.setExistencias(articulo.getExistencias());
        super.setActivo(articulo.isActivo());
        super.setImagen(articulo.getImagen());
        this.cantidad = 0;
    }
}
