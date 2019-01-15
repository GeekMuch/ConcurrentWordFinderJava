

import java.nio.file.Path;

/**
 * @author byteme
 */
public interface Result {
    /**
     * The file ({@link Path}) that the word occurs in.
     *
     * @return the file ({@link Path}) that the word occurrs in
     */
    public Path path();

    /**
     * The line at which the word occurs in the file.
     *
     * @return the line at which the word occurs in the file
     */

    public int line();
}
