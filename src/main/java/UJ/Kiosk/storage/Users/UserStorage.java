package UJ.Kiosk.storage.Users;

import UJ.Kiosk.model.User;

import java.util.List;
import java.util.Map;

/**
 * The UserStorage interface defines a contract for classes responsible for
 * managing a storage of user-related data, typically for a Kiosk application.
 */
public interface UserStorage {

    /**
     * Saves a user in the storage.
     *
     * @param user The user to be saved.
     * @return The saved user.
     */
    User saveUser(User user);

    /**
     * Retrieves a user by their unique identifier.
     *
     * @param id The unique identifier of the user.
     * @return The user with the specified identifier or null if the user is not found.
     */
    User getUserById(Integer id);

    /**
     * Deletes a user from the storage by their unique identifier.
     *
     * @param id The unique identifier of the user to be deleted.
     * @return true if the user was successfully deleted, otherwise false.
     */
    boolean deleteUserById(Integer id);

    /**
     * Updates an existing user in the storage based on their unique identifier.
     *
     * @param updatedUser  The unique identifier of the user to be updated.
     */
    void updateUser(User updatedUser);

    /**
     * Retrieves all users from the storage as a List.
     *
     * @return A List of all users stored in the storage.
     */
    List<User> retrieveAllUsers();
    /**
     * Retrieves all users from the storage as a Map.
     *
     * @return A  Map<Integer, User>  of all users stored in the storage.
     */
    Map<Integer, User> retrieveUserMap();

}
