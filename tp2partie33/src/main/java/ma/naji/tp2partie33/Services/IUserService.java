package ma.naji.tp2partie33.Services;


import ma.naji.tp2partie33.entities.Role;
import ma.naji.tp2partie33.entities.User;
import ma.naji.tp2partie33.entities.Role;
import ma.naji.tp2partie33.entities.User;

public interface IUserService {

    User addNewUser(User user);
    Role addNewRole(Role role);
    User findUserByUserName(String userName);
    Role findRoleByRoleName(String roleName);
    void addRoleToUser(String userName,String roleName);
    User authenticate(String userName,String password);

}
