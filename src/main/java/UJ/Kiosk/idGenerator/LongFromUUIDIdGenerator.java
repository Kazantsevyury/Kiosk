package UJ.Kiosk.idGenerator;

import java.util.UUID;

/**
 * A class that implements the IdGenerator interface and generates Long IDs from UUIDs.
 */
public class LongFromUUIDIdGenerator implements IdGenerator {

    /**
     * Generates a unique Long ID from a UUID.
     *
     * @return A unique Long ID.
     */
    @Override
    public Long generateLongId() {
        UUID uuid = generateUUIDId();
        long mostSignificantBits = uuid.getMostSignificantBits();
        long leastSignificantBits = uuid.getLeastSignificantBits();
        long id = (mostSignificantBits << 64) | leastSignificantBits;

        // Ensure the ID is positive
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
    public UUID generateUUIDId() {
        return UUID.randomUUID();
    }
}