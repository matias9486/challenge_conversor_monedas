package com.alura.conversor_moneda.service;

import com.alura.conversor_moneda.model.enums.Moneda;
import com.alura.conversor_moneda.model.dto.MonedaConversionDTO;
import com.alura.conversor_moneda.model.exception.ExchangeRateException;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangeRateService {
    private String apiKey = System.getenv("ExchangeApiKey");
    private String urlBase = "https://v6.exchangerate-api.com/v6/"+ apiKey;
    private HttpClient client;
    public ExchangeRateService() {
        this.client = HttpClient.newHttpClient();
    }

    public MonedaConversionDTO obtenerValorMoneda(Moneda monedaActual, Moneda monedaConversion, double montoOriginal) throws IOException, InterruptedException {
        URI direccion = URI.create(urlBase + "/pair/" + monedaActual + "/" + monedaConversion);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        //Conversión a JSON
        JsonElement elemento = JsonParser.parseString(response.body());
        JsonObject objectRoot = elemento.getAsJsonObject();
        //Accediendo a JsonObject
        String estado = objectRoot.get("result").getAsString();

        if (estado.equals("error"))
            throw new ExchangeRateException(objectRoot.get("error-type").getAsString());

        //MonedaConversionDTO montoConvertido = new Gson().fromJson(response.body(), MonedaConversionDTO.class);
        MonedaConversionDTO montoConvertido = new Gson().fromJson( elemento, MonedaConversionDTO.class);
        montoConvertido.setMontoOriginal(montoOriginal);

        return montoConvertido;
    }
}