package br.com.alura.screenmatch.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

// Cada serviço é implementado como uma nova classe, dentro do pacote referente
public class ConverteDados implements IConverteDados {
    private ObjectMapper mapear = new ObjectMapper();

    @Override
    //em metodos genéricos devemos usar os parametros de tipo entre <>
    public <T> T obterDados(String json, Class<T> classe) {
        try {
            return mapear.readValue(json, classe);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
