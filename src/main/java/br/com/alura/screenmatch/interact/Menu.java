package br.com.alura.screenmatch.interact;

import br.com.alura.screenmatch.models.DataSeason;
import br.com.alura.screenmatch.models.DataSerie;
import br.com.alura.screenmatch.models.Serie;
import br.com.alura.screenmatch.repository.SerieRepository;
import br.com.alura.screenmatch.service.ConsumoAPI;
import br.com.alura.screenmatch.service.ConverteDados;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
import java.util.stream.Collectors;

public class Menu {
    private static final String MAIN_URL = "https://www.omdbapi.com/?t=";
    private static final String API_KEY = "&apikey=533ccdd7";

    private Scanner busca = new Scanner(System.in);
    private ConsumoAPI consumoApi = new ConsumoAPI();
    private ConverteDados conversor = new ConverteDados();
    private String json;
    private List<DataSerie> serieList = new ArrayList<>();


    private SerieRepository repositorio;

    public Menu(SerieRepository repositorio) {
        this.repositorio = repositorio;
    }

    public void exibeMenu() {
        String opcao = "";
        while(!opcao.equals("0")){
            String menu = """
                    1 - Buscar séries
                    2 - Buscar episódios
                    3 - Listar series buscadas
                    
                    0 - Sair
                    """;
            System.out.println(menu);
            opcao = busca.nextLine();

            switch (opcao) {
                case "1":
                    searchSerie();
                    break;
                case "2":
                    searchEpisode();
                    break;
                case "3":
                    listSearchedSeries();
                    break;
                case "0":
                    System.out.println("Saindo...");

                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
//



    }

    private void listSearchedSeries() {
        List<Serie> series = repositorio.findAll();
        series.stream().sorted(Comparator.comparing(Serie::getGenero))
                .forEach(System.out::println);
    }

    private  DataSerie getDataSerie() {
        System.out.println("Digite o nome da série: ");
        String serieName = busca.nextLine();
        json = consumoApi.obterDados(MAIN_URL+serieName.replace(" ","+")+API_KEY);
        DataSerie data = conversor.obterDados(json, DataSerie.class);
        return data;
    }

    private void searchSerie() {
        DataSerie data = getDataSerie();
        Serie serie= new Serie(data);
        //serieList.add(data);
        repositorio.save(serie);
        System.out.println(data);
    }
    private void searchEpisode() {
        DataSerie dataSerie = getDataSerie();
        List<DataSeason> season = new ArrayList<>();

        for(int i = 1; i < dataSerie.totalTemporadas(); i++) {
            json = consumoApi.obterDados(MAIN_URL+dataSerie.titulo().replace(" ","+")+"&season="+i+API_KEY);
            DataSeason dataSeason = conversor.obterDados(json, DataSeason.class);
            season.add(dataSeason);
        }
        season.forEach(System.out::println);
    }



}
