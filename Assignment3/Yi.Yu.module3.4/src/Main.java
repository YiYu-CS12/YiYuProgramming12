import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<PlayerBattingStats> players;

    public static void parseCSVData(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] splitter = line.split(",");
            String name = splitter[0];
            String team = splitter[1];
            int gamesPlayed = Integer.parseInt(splitter[2]);
            int atBats = Integer.parseInt(splitter[3]);
            int runs = Integer.parseInt(splitter[4]);
            int hits = Integer.parseInt(splitter[5]);
            int doubles = Integer.parseInt(splitter[6]);
            int triples = Integer.parseInt(splitter[7]);
            int homeRuns = Integer.parseInt(splitter[8]);
            int rbis = Integer.parseInt(splitter[9]);
            players.add(new PlayerBattingStats(name, team, gamesPlayed, atBats, runs, hits, doubles, triples, homeRuns, rbis));
        }
    }

    public static void main(String[] args) {
        players = new ArrayList<>();
        try {
            parseCSVData(new File("PlayerData.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }

        try (FileWriter writer = new FileWriter("SortedPlayerStats.txt")) {
            writer.write("Sorting by Games Played:\n");
            writeSortedPlayers(writer, PlayerSorter.sort(players, PlayerSorter.GAMESPLAYED));

            writer.write("\nSorting by At Bats:\n");
            writeSortedPlayers(writer, PlayerSorter.sort(players, PlayerSorter.ATBATS));

            writer.write("\nSorting by Runs:\n");
            writeSortedPlayers(writer, PlayerSorter.sort(players, PlayerSorter.RUNS));

            writer.write("\nSorting by Percent Runs:\n");
            writeSortedPlayers(writer, PlayerSorter.sort(players, PlayerSorter.PERCENTRUNS));

            writer.write("\nSorting by Percent On Base:\n");
            writeSortedPlayers(writer, PlayerSorter.sort(players, PlayerSorter.PERCENTONBASE));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeSortedPlayers(FileWriter writer, ArrayList<PlayerBattingStats> sortedPlayers) throws IOException {
        for (PlayerBattingStats player : sortedPlayers) {
            writer.write(player.toString() + "\n");
        }
    }
}
