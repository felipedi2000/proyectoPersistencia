package uptc.frw.proyectofabrica.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uptc.frw.proyectofabrica.jpa.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
