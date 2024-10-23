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
                    String normalizedWord = word.toLowerCase().replaceAll("[^a-z]", "");
                    if (!normalizedWord.isEmpty()) {
                        uniqueWords.add(new Word(normalizedWord));
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error when reading file");
        }

        System.out.println("Number of unique words: " + uniqueWords.size());
        for (Word word : uniqueWords) {
            System.out.println(word);
        }
    }
}