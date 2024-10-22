import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        TreeSet<Word> uniqueWords = new TreeSet<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("illiad.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    String normalizedWord = normalizeWord(word);
                    if (!normalizedWord.isEmpty()) {
                        uniqueWords.add(new Word(normalizedWord));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Output the number of unique words
        System.out.println("Number of unique words: " + uniqueWords.size());

        // Optionally print all unique words
        for (Word word : uniqueWords) {
            System.out.println(word);
        }
    }

    private static String normalizeWord(String word) {
        return word.toLowerCase().replaceAll("[^a-z]", "");
    }
}