package uptc.frw.proyectofabrica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
@EnableElasticsearchRepositories(basePackages = "uptc.frw.proyectofabrica.jpa.repository")
public class ProyectoFabricaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProyectoFabricaApplication.class, args);
    }

}
