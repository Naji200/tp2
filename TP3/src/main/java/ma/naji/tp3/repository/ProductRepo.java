package ma.naji.tp3.repository;

import ma.naji.tp3.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
// cette heritage est pour utiliser spring data

public interface ProductRepo extends JpaRepository<Product,Long> {
    List<Product> findProductByNameContaining(String mc );
}
