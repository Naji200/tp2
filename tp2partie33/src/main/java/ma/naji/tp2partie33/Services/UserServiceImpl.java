package ma.naji.tp2partie33.Services;


import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import ma.naji.tp2partie33.entities.Role;
import ma.naji.tp2partie33.entities.User;
import ma.naji.tp2partie33.repositories.RoleRepositery;
import ma.naji.tp2partie33.repositories.UserRepositery;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements IUserService {

    private UserRepositery userRepositery;
    private RoleRepositery roleRepositery;

    @Override
    public User addNewUser(User user) {
        user.setId(UUID.randomUUID().toString());
        return userRepositery.save(user);
    }

    @Override
    public Role addNewRole(Role role) {
        return roleRepositery.save(role);
    }

    @Override
    public User findUserByUserName(String userName) {
        return userRepositery.findByUsername(userName);
    }

    @Override
    public Role findRoleByRoleName(String roleName) {
        return roleRepositery.findByRoleName(roleName);
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
        User user=findUserByUserName(userName);
        Role role=findRoleByRoleName(roleName);
        if(user.getRoles()!=null){
            user.getRoles().add(role);
            role.getUsers().add(user);
        }

        userRepositery.save(user);
    }

    @Override
    public User authenticate(String userName, String password) {
        User userInfo=userRepositery.findUserByUsernameAndPassword(userName,password);
        if(userInfo==null) throw new RuntimeException("Bad credentials");
        return userInfo;
    }
}
