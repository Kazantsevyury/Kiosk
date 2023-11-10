package UJ.Kiosk.storage.Users;

import UJ.Kiosk.model.User;

import java.util.*;

public class InMemoryUserStorage implements UserStorage{
    private final Map<Integer, User> users = new HashMap<>();

    @Override
    public User saveUser(User user) {
        users.put(user.getId(), user);
        return users.get(user.getId());
    }

    @Override
    public User getUserById(Integer id) {
        return users.get(id);
    }

    @Override
    public boolean deleteUserById(Integer id) {
        User removedUser = users.remove(id);
        return removedUser != null;
    }

    @Override
    public void updateUser(User updatedUser) {
        users.put(updatedUser.getId(), updatedUser);
    }

    @Override
    public List<User> retrieveAllUsers() {
        List<User> usersList = new ArrayList<>(users.values());
        return usersList;
    }

    @Override
    public Map<Integer, User> retrieveUserMap() {
        return users;
    }
}
