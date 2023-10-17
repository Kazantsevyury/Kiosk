package UJ.Kiosk.idGenerator;
import java.util.UUID;

/**
 * An interface that defines methods for generating Long and UUID IDs.
 */
public interface IdGenerator {

    /**
     * Generates a unique Long ID.
     *
     * @return A unique Long ID.
     */
    public Long generateLongId();

    /**
     * Generates a unique UUID (Universally Unique Identifier).
     *
     * @return A unique UUID.
     */
    public UUID generateUUIDId();
}