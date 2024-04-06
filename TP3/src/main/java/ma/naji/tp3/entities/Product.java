package ma.naji.tp3.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity
@Data
// en utilisant lombok @data est une anotation pour les seters et les geters x
@NoArgsConstructor
@AllArgsConstructor
// cette partie est pour les table dans la base de donne "entity framework en .net"
//ce connecter a la base cree les table tous se fait automatiquement
public class Product {
    @Id @GeneratedValue(strategy  = GenerationType.IDENTITY) //pour generer le id
   private long id;
    private String name;
    private double price;
    private int quantite;

}






