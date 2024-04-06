package ma.naji.tp2partie33.repositories;
import ma.naji.tp2partie33.entities.User;
import ma.naji.tp2partie33.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositery extends JpaRepository<User,String> {
    User findByUsername(String username);
    User findUserByUsernameAndPassword(String username, String password);
}
