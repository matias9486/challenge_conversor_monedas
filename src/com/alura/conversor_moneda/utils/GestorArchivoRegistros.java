package com.alura.conversor_moneda.utils;

import com.alura.conversor_moneda.adapters.LocalDateTimeAdapter;
import com.alura.conversor_moneda.model.dto.RegistroConversionDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GestorArchivoRegistros {
    private static final String ARCHIVO = "Historial_conversiones.json";
    private final Gson gson = new GsonBuilder()
            //agregado el adapter para que gson pueda des/serializar LocalDateTime
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
            .setPrettyPrinting()
            .create();

    // Cargar registros desde archivo
    public List<RegistroConversionDTO> cargarRegistros() {
        File archivo = new File(ARCHIVO);
        if (!archivo.exists()) {
            return new ArrayList<>();
        }

        try (Reader lector = new FileReader(archivo)) {
            Type tipoLista = new TypeToken<List<RegistroConversionDTO>>() {}.getType();
            List<RegistroConversionDTO> registros = gson.fromJson(lector, tipoLista);
            return registros != null ? registros : new ArrayList<>();
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("\n❌ Se ha producido un error. " + e.getMessage() +"\n");
            return new ArrayList<>();
        }
    }

    // Guardar lista completa de registros en archivo
    public void guardarRegistros(List<RegistroConversionDTO> registros) {
        try (Writer escritor = new FileWriter(ARCHIVO)) {
            gson.toJson(registros, escritor);
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("\n❌ Se ha producido un error. " + e.getMessage() +"\n");
        }
    }
}
