package br.com.alura.screenmatch;

import br.com.alura.screenmatch.models.DataEpisode;
import br.com.alura.screenmatch.models.DataSeason;
import br.com.alura.screenmatch.models.DataSerie;
import br.com.alura.screenmatch.service.ConsumoAPI;
import br.com.alura.screenmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*
		IMPLEMENTANDO SCANNER

		 */
		Scanner busca = new Scanner(System.in);
		String serieNome = busca.nextLine();
		ConsumoAPI consumoApi = new ConsumoAPI();
		String json = consumoApi.obterDados("https://www.omdbapi.com/?t="+serieNome+"&apikey=533ccdd7");
		ConverteDados conversor = new ConverteDados();
		DataSerie dados = conversor.obterDados(json, DataSerie.class);



		List<DataSeason> temporadas = new ArrayList<>();
		for (int i = 1; i <= dados.totalTemporadas(); i++){
			json = consumoApi.obterDados("https://www.omdbapi.com/?t="+ serieNome+"&season="+i+"&apikey=533ccdd7");
			DataSeason dadosTem = conversor.obterDados(json, DataSeason.class);
			temporadas.add(dadosTem);

		}
		temporadas.forEach(System.out::println);

	}
}
