package com.alura.conversor_moneda.model.dto;

import com.alura.conversor_moneda.model.enums.Moneda;
import com.google.gson.annotations.SerializedName;

public class MonedaConversionDTO {
    @SerializedName("result")
    private String estado;
    @SerializedName("base_code")
    private Moneda monedaActual;
    @SerializedName("target_code")
    private Moneda monedaDestino;

    @SerializedName("conversion_rate")
    private double valorConversion;
    private double montoOriginal;

    public MonedaConversionDTO(String estado, Moneda monedaActual, Moneda monedaDestino, double valorConversion, double montoOriginal) {
        this.estado = estado;
        this.monedaActual = monedaActual;
        this.monedaDestino = monedaDestino;
        this.valorConversion = valorConversion;
        this.montoOriginal = montoOriginal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Moneda getMonedaActual() {
        return monedaActual;
    }

    public void setMonedaActual(Moneda monedaActual) {
        this.monedaActual = monedaActual;
    }

    public Moneda getMonedaDestino() {
        return monedaDestino;
    }

    public void setMonedaDestino(Moneda monedaDestino) {
        this.monedaDestino = monedaDestino;
    }

    public double getValorConversion() {
        return valorConversion;
    }

    public void setValorConversion(double valorConversion) {
        this.valorConversion = valorConversion;
    }

    public double getMontoOriginal() {
        return montoOriginal;
    }

    public void setMontoOriginal(double montoOriginal) {
        this.montoOriginal = montoOriginal;
    }

    public double convertirMonto(){
        return this.montoOriginal * valorConversion;
    }

    @Override
    public String toString() {
        return
                "Monto original = $" + montoOriginal + " "+ monedaActual.getDescripcion() + "("+ monedaActual + ")" +
                "\nMonto convertido = $" + convertirMonto() + " " + monedaDestino.getDescripcion() + "("+ monedaDestino +")" +
                "\nValor de conversión del "+ monedaDestino.getDescripcion() +" = $" + valorConversion
                ;
    }
}
