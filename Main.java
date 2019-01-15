

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * This class is present only for helping you in testing your software.
 * It will be completely ignored in the evaluation.
 *
 * @author byteme
 */
public class Main {

    public static int visit(Path dir) {
        int total = 0;

        // Files is a very useful utility class
        try (
                DirectoryStream<Path> dirStream = Files.newDirectoryStream(dir)
        ) {
            for (Path path : dirStream) {
                if (Files.isDirectory(path)) {
                    total += visit(path);
                } else {
                    if (path.toString().endsWith(".txt")) {
                        System.out.println(path.toString());
                        // total += countWordsStream( path );

                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return total;
    }


    public static void main(String[] args) throws FileNotFoundException, IOException {
        String word = "unity"; // WORD TO SEARCH

        Path dir = Paths.get("/home/byteme/Desktop/blurp/unity.txt");
        System.out.println("SCANNING " + dir);


        WordFinder.findAll(word, dir);
        WordFinder.findAny(word, dir);

        Map<String, Integer> WC = new TreeMap<>();
        Scanner input = new Scanner(dir);


        // array of occ.
        while (input.hasNext()) {
            String next = input.next().toLowerCase();
            if (!WC.containsKey(next.split("\\s*"))) {
                WC.put(next, 1);
            } else {
                WC.put(next, WC.get(next) + 1);
            }
        }

        //Array view of occ.
        WC.entrySet().stream().forEach((entry) -> {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.printf("%s : %s\n", key, value);
        });
        //System.out.println("Words: " + word + "-> Total count for searched word : " + wordCntr + " Total lines: "+ lineCntr + WC.size() );
    }

} // end of main method


