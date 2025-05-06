package com.alura.conversor_moneda.model.exception;

public class ExchangeRateException extends RuntimeException {
    private String mensaje;

    public ExchangeRateException(String mensaje) {
        this.mensaje = "Se ha producido un error al consultar API: " + mensaje;
    }

    @Override
    public String getMessage() {
        return this.mensaje;
    }
}
