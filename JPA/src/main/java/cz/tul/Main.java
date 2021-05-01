package cz.tul;


import cz.tul.service.CountryService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("cz.tul.repositories")
public class Main {

    @Bean
    public CountryService countryService(){
        return new CountryService();
    }



    public static void main(String[] args){
        SpringApplication app = new SpringApplication(Main.class);
        ApplicationContext context = app.run(args);
    }
}
