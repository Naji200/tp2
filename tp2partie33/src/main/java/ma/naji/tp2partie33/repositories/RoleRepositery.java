package ma.naji.tp2partie33.repositories;
import ma.naji.tp2partie33.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepositery extends JpaRepository<Role,Long> {
    Role findByRoleName(String roleName);
}
