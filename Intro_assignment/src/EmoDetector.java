import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class EmoDetector {
    private static int count(String str, String Str) {
        int count = 0;
        int index = 0;

        while ((index = str.indexOf(Str, index)) != -1) {
            count++;
            index += Str.length();
        }
        return count;
    }

    public static void main(String[] args) {
        try {
            Scanner fileScanner = new Scanner(new File("happyorsad.txt"));

            if (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();

                int happyCount = count(line, ":-)");
                int sadCount = count(line, ":-(");

                if (happyCount == 0 && sadCount == 0) {
                    System.out.println("none");
                } else if (happyCount == sadCount) {
                    System.out.println("unsure");
                } else if (happyCount > sadCount) {
                    System.out.println("happy");
                } else {
                    System.out.println("sad");
                }
            } else {
                System.out.println("none");
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not Found");
        }
    }
}