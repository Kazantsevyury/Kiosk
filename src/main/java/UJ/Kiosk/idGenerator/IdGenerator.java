package UJ.Kiosk.idGenerator;
import java.util.UUID;

/**
 * An interface that defines methods for generating Long and UUID IDs.
 */
public interface IdGenerator {

    /**
     * Generates a unique Integer ID.
     *
     * @return A unique Integer ID.
     */
    public Integer generateIntegerId();

    /**
     * Generates a unique UUID (Universally Unique Identifier).
     *
     * @return A unique UUID.
     */
    public UUID generateUUIDId();
}