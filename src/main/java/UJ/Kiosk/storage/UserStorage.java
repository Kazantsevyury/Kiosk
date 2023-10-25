package UJ.Kiosk.storage;

import UJ.Kiosk.model.User;

import java.util.Collection;
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
    User getUserById(Long id);

    /**
     * Deletes a user from the storage by their unique identifier.
     *
     * @param id The unique identifier of the user to be deleted.
     * @return true if the user was successfully deleted, otherwise false.
     */
    boolean deleteUserById(Long id);

    /**
     * Updates an existing user in the storage based on their unique identifier.
     * If a user with the specified identifier does not exist, the method may create a new user.
     *
     * @param id The unique identifier of the user to be updated.
     */
    void updateUser(User updatedUser);

    /**
     * Retrieves all users from the storage as a collection, typically for a Kiosk application.
     *
     * @return A collection of all users stored in the storage.
     */
    Collection<User> getAllUsers();

}
