package com.alura.conversor_moneda.model.enums;

public enum Moneda {
    ARS("Peso argentino"),
    BOB("Boliviano boliviano"),
    BRL("Real brasileño"),
    CLP("Peso chileno"),
    COP("Peso colombiano"),
    USD("Dólar");

    private final String descripcion;

    Moneda(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
