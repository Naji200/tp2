package ma.naji.tp3;

import ma.naji.tp3.entities.Product;
import ma.naji.tp3.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Tp3Application implements CommandLineRunner {
    //pour utiliser l interface ProductRepo pour ajouter des objet a la base
    @Autowired
    private ProductRepo productRopo;



    public static void main(String[] args) {

        SpringApplication.run(Tp3Application.class, args);
    }
    // est une app spring boot cette app est une app java
    @Override
    public void run(String... args) throws Exception {
        //dans cette methode on fait la manip de la basse de donnee ajouter afficher sup
        productRopo.save(new Product( 0,"computer",5000,101));
        productRopo.save(new Product(0,"telephone",4500,101));
        productRopo.save(new Product(0,"television",5500,104));
        productRopo.save(new Product(0,"laptop",6000,104));
        List<Product> products = productRopo.findAll();
        products.forEach(p->{
                    System.out.println(p.toString());
                }
                );
        Product pro = productRopo.findById(Long.valueOf(1) ).get();
        System.out.println(pro);
        List<Product> productss = productRopo.findProductByNameContaining("te");
        productss.forEach(p->{
                    System.out.println(p.toString());
                }
        );





    }

}
