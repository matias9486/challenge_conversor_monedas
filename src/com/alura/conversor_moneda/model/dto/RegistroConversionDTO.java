package com.alura.conversor_moneda.model.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RegistroConversionDTO {
    private LocalDateTime fechaRegistro;
    private MonedaConversionDTO registroConversion;

    public RegistroConversionDTO(LocalDateTime fechaRegistro, MonedaConversionDTO registroConversion) {
        this.fechaRegistro = fechaRegistro;
        this.registroConversion = registroConversion;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(LocalDateTime fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public MonedaConversionDTO getRegistroConversion() {
        return registroConversion;
    }

    public void setRegistroConversion(MonedaConversionDTO registroConversion) {
        this.registroConversion = registroConversion;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return "%s. Se convirtió $%.2f %s(%s)  a $%.2f %s(%s). Valor de conversión: %f".formatted(
                this.fechaRegistro.format(formatoFecha),
                this.registroConversion.getMontoOriginal(),
                this.registroConversion.getMonedaActual().getDescripcion(),
                this.registroConversion.getMonedaActual(),
                this.registroConversion.convertirMonto(),
                this.registroConversion.getMonedaDestino().getDescripcion(),
                this.registroConversion.getMonedaDestino(),
                this.registroConversion.getValorConversion()
                );
    }
}
