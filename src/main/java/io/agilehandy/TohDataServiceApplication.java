package io.agilehandy;

import io.agilehandy.heroes.Hero;
import io.agilehandy.heroes.HeroRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.stream.Stream;

@SpringBootApplication
public class TohDataServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TohDataServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(HeroRepository repository) {
		return strings -> {
			Stream.of("Haytham", "Eyman", "Ahmed", "Monira", "Akram", "Mariam", "Ibrahim", "Mahmoud", "Mohamed")
					.forEach(name -> repository.save(new Hero(name)));
		};
	}

    @Bean
    public CorsFilter corsFilter() {

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true); // you USUALLY want this
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("DELETE");
        config.addAllowedMethod("POST");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
