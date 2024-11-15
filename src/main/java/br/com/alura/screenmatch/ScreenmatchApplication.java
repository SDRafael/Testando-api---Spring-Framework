package br.com.alura.screenmatch;

import br.com.alura.screenmatch.interact.Menu;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Menu menu = new Menu();
		menu.exibeMenu();
//		List<DataSeason> temporadas = new ArrayList<>();
//		for (int i = 1; i <= dados.totalTemporadas(); i++){
//			json = consumoApi.obterDados("https://www.omdbapi.com/?t="+ serieNome+"&season="+i+"&apikey=533ccdd7");
//			DataSeason dadosTem = conversor.obterDados(json, DataSeason.class);
//			temporadas.add(dadosTem);
//
//		}
//		temporadas.forEach(System.out::println);

	}
}
