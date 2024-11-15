package br.com.alura.screenmatch.interact;

import br.com.alura.screenmatch.models.DataSeason;
import br.com.alura.screenmatch.models.DataSerie;
import br.com.alura.screenmatch.service.ConsumoAPI;
import br.com.alura.screenmatch.service.ConverteDados;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private static final String MAIN_URL = "https://www.omdbapi.com/?t=";
    private static final String API_KEY = "&apikey=533ccdd7";

    private Scanner busca = new Scanner(System.in);
    private ConsumoAPI consumoApi = new ConsumoAPI();
    private ConverteDados conversor = new ConverteDados();
    public void exibeMenu(){
        System.out.println("Digite o nome da série: ");

        String serieNome = busca.nextLine();
        String json = consumoApi.obterDados(MAIN_URL+serieNome.replace(" ","+")+API_KEY);
        DataSerie dados = conversor.obterDados(json, DataSerie.class);
        System.out.println(dados);
        List<DataSeason> temporadas = new ArrayList<>();
        for (int i = 1; i <= dados.totalTemporadas(); i++){
            json = consumoApi.obterDados(MAIN_URL+serieNome.replace(" ", "+")+"&season="+i+API_KEY);
            DataSeason dadosTem = conversor.obterDados(json, DataSeason.class);
            temporadas.add(dadosTem);

        }
        temporadas.forEach(System.out::println);
    }
}
