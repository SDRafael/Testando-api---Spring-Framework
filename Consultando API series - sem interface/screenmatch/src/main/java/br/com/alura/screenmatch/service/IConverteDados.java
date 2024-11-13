package br.com.alura.screenmatch.service;
//essa interface recebe um json e uma classe, ambos genéricos, sem tipo especificado
public interface IConverteDados {
    //abaixo o timo de metodo que retorna um tipo de dado genérico, quando eu não sei o tipo de dados que vai ser recebido
    <T> T obterDados(String json, Class<T> classe);
}
