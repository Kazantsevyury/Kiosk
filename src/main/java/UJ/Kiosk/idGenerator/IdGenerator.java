package UJ.Kiosk.idGenerator;
import java.util.UUID;

/**
 * This interface defines methods for generating IDs.
 */
public interface IdGenerator {

    /**
     * Generates a unique ID as a Long, positive.
     *
     * @return A unique Long ID, positive.
     */
    static Long generateId() {
        UUID uuid = generateUUIDId();
        long mostSignificantBits = uuid.getMostSignificantBits();
        long leastSignificantBits = uuid.getLeastSignificantBits();
        long id = (mostSignificantBits << 64) | leastSignificantBits;

        if (id < 0) {
            id = Math.abs(id);
        }

        return id;
    }

    /**
     * Generates a unique UUID (Universally Unique Identifier).
     *
     * @return A unique UUID.
     */
    static UUID generateUUIDId() {
        return UUID.randomUUID();
    }
}