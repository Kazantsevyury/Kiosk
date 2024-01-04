package UJ.Kiosk.idGenerator;

import java.util.UUID;

/**
 * A class that implements the IdGenerator interface and generates Integer IDs from UUIDs.
 */
public class IntegerFromUUIDIdGenerator implements IdGenerator {

    /**
     * Generates a unique Integer ID from a UUID.
     *
     * @return A unique Integer ID.
     */
    @Override
    public Integer generateIntegerId() {
        UUID uuid = generateUUIDId();
        Long mostSignificantBits = uuid.getMostSignificantBits();
        Long leastSignificantBits = uuid.getLeastSignificantBits();
        Integer id = Math.toIntExact((mostSignificantBits << 64) | leastSignificantBits);

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