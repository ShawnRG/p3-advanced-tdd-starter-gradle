package be.kdg.tdd;

import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class UserManagement {
    private Set<User> users;

    public UserManagement() {
        this.users = new HashSet<>();
        addUser("root", "rootpasswd");
    }

    public void addUser(String username, String password) {
        users.add(new User(username, password));
    }

    public void removeUser(String username, String password) {
        users.remove(new User(username, password));
    }

    public boolean checkLogin(String username, String password) {
        return users.contains(new User(username, password));
    }
}
