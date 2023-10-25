package UJ.Kiosk.storage;

import UJ.Kiosk.model.Task;
import UJ.Kiosk.model.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class InMemoryUserStorage implements UserStorage{
    private final Map<Long, User> users = new HashMap<>();

    @Override
    public User saveUser(User user) {
        users.put(user.getId(), user);
        return users.get(user.getId());
    }

    @Override
    public User getUserById(Long id) {
        return users.get(id);
    }

    @Override
    public boolean deleteUserById(Long id) {
        User removedUser = users.remove(id);
        return removedUser != null;
    }

    @Override
    public void updateUser(User updatedUser) {
        Long idToUpdate = updatedUser.getId();

        if (users.containsKey(idToUpdate)) {
            users.put(idToUpdate, updatedUser);
        } else {

        }
    }

    @Override
    public Collection<User> getAllUsers() {
        return users.values();
    }
}
