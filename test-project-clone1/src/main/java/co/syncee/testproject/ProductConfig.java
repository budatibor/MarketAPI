package co.syncee.testproject;

import co.syncee.testproject.model.Product;
import co.syncee.testproject.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ProductConfig {
    @Bean
    CommandLineRunner commandLineRunner(ProductRepository repository){
        return args -> {
            Product coffee = new Product(
                    "coffee",
                    8
            );
            Product milk = new Product(
                    "milk",
                    5
            );
            Product caramel = new Product(
                    "caramel",
                    6
            );
            Product chocolate_cream = new Product(
                    "chocolate cream",
                    7
            );
            Product ice_cream = new Product(
                    "ice cream",
                    3
            );
            Product sugar = new Product(
                    "sugar",
                    9
            );
            Product sweetener = new Product(
                    "sweetener",
                    2
            );
            Product cinnamon = new Product(
                    "cinnamon",
                    6
            );

            repository.saveAll(
                    List.of(coffee, milk, caramel, chocolate_cream, ice_cream, sugar, sweetener, cinnamon)
            );
        };
    }
}
