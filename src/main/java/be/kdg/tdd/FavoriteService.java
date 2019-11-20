package be.kdg.tdd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FavoriteService {
    private UserManagement userManagement;

    @Autowired
    public FavoriteService(UserManagement userManagement) {
        this.userManagement = userManagement;
    }

    public void addUser(String root, String rootpasswd, String validUsername, String validPassword) {
        if ("root".equals(root) && "rootpasswd".equals(rootpasswd))
            userManagement.addUser(validUsername, validPassword);
    }

    public void removeUser(String root, String rootpasswd, String validUsername, String validPassword) {
        if ("root".equals(root) && "rootpasswd".equals(rootpasswd))
            userManagement.removeUser(validUsername, validPassword);
    }

    public boolean checkLogin(String validUsername, String validPassword) {
        return userManagement.checkLogin(validUsername, validPassword);
    }
}
