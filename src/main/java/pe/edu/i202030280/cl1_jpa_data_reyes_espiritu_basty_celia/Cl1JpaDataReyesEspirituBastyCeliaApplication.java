package pe.edu.i202030280.cl1_jpa_data_reyes_espiritu_basty_celia;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pe.edu.i202030280.cl1_jpa_data_reyes_espiritu_basty_celia.entity.Country;
import pe.edu.i202030280.cl1_jpa_data_reyes_espiritu_basty_celia.repository.CountryRepository;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class Cl1JpaDataReyesEspirituBastyCeliaApplication implements CommandLineRunner {

	@Autowired
	private CountryRepository countryRepository;

	public static void main(String[] args) {
		SpringApplication.run(Cl1JpaDataReyesEspirituBastyCeliaApplication.class, args);
	}

	@Transactional
	@Override
	public void run(String... args) {
		// Intentando obtener los idiomas de Argentina
		System.out.println("Consultando idiomas de Argentina o Perú...");

		Optional<Country> argentina = countryRepository.findById("ARG");

		// Si Argentina está presente, mostrar idiomas, sino, buscar en Perú
		argentina.ifPresentOrElse(
				this::imprimirIdiomas,
				() -> {
					Optional<Country> peru = countryRepository.findById("PER");
					peru.ifPresent(this::imprimirIdiomas);
				}
		);

		// Eliminando los países "COL" y "ARG" con eliminación en cascada
		System.out.println("\nProcediendo con la eliminación de Colombia y Argentina...");
		countryRepository.deleteAllById(List.of("COL", "ARG"));
		System.out.println("Países eliminados: Colombia y Argentina (incluyendo sus ciudades e idiomas).");
	}

	private void imprimirIdiomas(Country country) {
		System.out.println("Idiomas hablados en " + country.getName() + ":");
		country.getLanguages().forEach(System.out::println);
	}
}
