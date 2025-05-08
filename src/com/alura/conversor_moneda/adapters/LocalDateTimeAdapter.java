package com.alura.conversor_moneda.adapters;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Adapter para serializar y deserializar LocalDateTime usando gson.
 * Gson no soporta directamente LocalDateTime (ni otras clases del paquete java.time) porque fueron introducidas en Java 8 y Gson fue diseñado antes de eso. Por eso, necesitas registrar adaptadores personalizados para serializar y deserializar correctamente objetos como LocalDateTime.
 */
public class LocalDateTimeAdapter extends TypeAdapter<LocalDateTime> {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    @Override
    public void write(JsonWriter out, LocalDateTime value) throws IOException {
        out.value(value.format(FORMATTER));
    }

    @Override
    public LocalDateTime read(JsonReader in) throws IOException {
        return LocalDateTime.parse(in.nextString(), FORMATTER);
    }
}
