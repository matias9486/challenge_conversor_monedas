package com.alura.conversor_moneda.service;

import com.alura.conversor_moneda.model.dto.RegistroConversionDTO;

import java.util.ArrayList;
import java.util.List;

public class RegistroConversionService {
    private List<RegistroConversionDTO> registros;

    public RegistroConversionService() {
        this.registros = new ArrayList<>();
    }
    public void agregarRegistro(RegistroConversionDTO registro){
        this.registros.add(registro);
    }

    public void agregarRegistros(List<RegistroConversionDTO> registros){
        this.registros.addAll(registros);
    }

    public List<RegistroConversionDTO> obtenerRegistros(){
        return this.registros;
    }
}
