
import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * @author byteme
 */
public class WordFinder {
    /**
     * Finds all the (case-sensitive) occurrences of a word in a directory.
     * Only text files should be considered (files ending with the .txt suffix).
     *
     * The word must be an exact match: it is case-sensitive and may contain punctuation.
     * See https://github.com/fmontesi/cp2016/tree/master/exam for more details.
     *
     * The search is recursive: if the directory contains subdirectories,
     * these are also searched and so on so forth (until there are no more
     * subdirectories).
     *
     * @param word the word to find (does not contain whitespaces or punctuation)
     * @param dir  the directory to search
     * @return a list of results ({@link Result}), which tell where the word was found
     * @throws java.io.IOException
     */
    public static List<Result> findAll(String word, Path dir) throws IOException {

        // illuminati: 1 line 1 && unity: 42 line 19
        int wLen = word.length();
        List<String> result = new ArrayList<>();
        int wordCntr = 0;
        int lineCntr = 0;
        boolean unity;

        // File reader
        FileInputStream fs = new FileInputStream(dir.toString());
        BufferedReader br = new BufferedReader(new InputStreamReader(fs));
        String iLine;
        while ((iLine = br.readLine()) != null) {
            lineCntr++;
            unity = iLine.toLowerCase().contains(word.toLowerCase());
            if (unity) {
                String[] lineWords = iLine.split("\\s+");
                {
                    for (String x : lineWords) {
                        if (x.length() >= wLen) {
                            String wordw = x.substring(0, wLen).trim();
                            if (word.equals(wordw)) {
                                result.add(word + " found in line " + lineCntr + " in this place " + dir.toString() + '\n');

                                wordCntr++;
                            }
                        }
                    }
                }
            }
        }
        System.out.print(result);
        throw new UnsupportedOperationException("Eat a goat");

    }

    /**
     * Finds an occurrence of a word in a directory and returns.
     *
     * This method searches only for one (any) occurrence of the word in the
     * directory. As soon as one such occurrence is found, the search can be
     * stopped and the method can return immediately.
     *
     * As for method {@code findAll}, the search is recursive.
     *
     * @param word
     * @param dir
     * @return
     */
    public static Result findAny(String word, Path dir) throws FileNotFoundException, IOException, UnsupportedOperationException {
        int wLen = word.length();
        List<String> result = new ArrayList<>();
        int wordCntr = 0;
        int lineCntr = 0;
        boolean unity;

        // File reader
        FileInputStream fs = new FileInputStream(dir.toString());
        BufferedReader br = new BufferedReader(new InputStreamReader(fs));
        String iLine;
        while ((iLine = br.readLine()) != null) {
            lineCntr++;
            unity = iLine.toLowerCase().contains(word.toLowerCase());
            if (unity) {
                String[] lineWords = iLine.split("\\s+");
                {
                    for (String x : lineWords) {
                        if (x.length() >= wLen) {
                            String wordw = x.substring(0, wLen).trim();
                            if (word.equals(wordw)) {
                                result.add(word + " found in line " + lineCntr + " in this place " + dir.toString());
                                wordCntr++;

                                break;


                            }
                        }
                    }
                }
            }
        }
        System.out.println(result);
        throw new UnsupportedOperationException();

    }

    /**
     * Computes overall statistics about the occurrences of words in a directory.
     * <p>
     * This method recursively searches the directory for all words and returns
     * a {@link Stats} object containing the statistics of interest. See the
     * documentation of {@link Stats}.
     *
     * @param dir the directory to search
     * @return the statistics of occurring words in the directory
     */
    public static Stats stats(Path dir) {
        throw new UnsupportedOperationException();
    }
}
