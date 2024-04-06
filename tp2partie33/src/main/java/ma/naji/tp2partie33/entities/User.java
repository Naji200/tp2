package ma.naji.tp2partie33.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class User {

    @Id
    private String id;
    @Column(unique = true,length = 20)
    private String username;
    private String password;
    @ManyToMany(mappedBy = "users",fetch = FetchType.EAGER)
//    @JoinTable(name = "USERS_ROLES")
    private List<Role> roles=new ArrayList<>();
}
