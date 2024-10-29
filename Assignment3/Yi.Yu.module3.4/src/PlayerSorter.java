import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PlayerSorter {

    public static final int GAMESPLAYED = 0;
    public static final int ATBATS = 1;
    public static final int RUNS = 2;
    public static final int PERCENTRUNS = 3; // Calculated by: runs/atBats
    public static final int PERCENTONBASE = 4; // Calculated by (hits + doubles + triples) / atBats

    public static ArrayList<PlayerBattingStats> sort(ArrayList<PlayerBattingStats> list, int sortType) {
        ArrayList<PlayerBattingStats> sortedList = new ArrayList<>(list);
        switch (sortType) {
            case GAMESPLAYED:
                mergeSort(sortedList, Comparator.comparingInt(PlayerBattingStats::getGames).reversed());
                break;
            case ATBATS:
                mergeSort(sortedList, Comparator.comparingInt(PlayerBattingStats::getAtBats).reversed());
                break;
            case RUNS:
                mergeSort(sortedList, Comparator.comparingInt(PlayerBattingStats::getRuns).reversed());
                break;
            case PERCENTRUNS:
                mergeSort(sortedList, Comparator.comparingDouble(PlayerBattingStats::getPercentRuns).reversed());
                break;
            case PERCENTONBASE:
                mergeSort(sortedList, Comparator.comparingDouble(PlayerBattingStats::getPercentOnBase).reversed());
                break;
        }
        return sortedList;
    }

    private static void mergeSort(List<PlayerBattingStats> list, Comparator<PlayerBattingStats> comparator) {
        if (list.size() <= 1) return;

        int midpoint = list.size() / 2;
        List<PlayerBattingStats> left = new ArrayList<>(list.subList(0, midpoint));
        List<PlayerBattingStats> right = new ArrayList<>(list.subList(midpoint, list.size()));

        mergeSort(left, comparator);
        mergeSort(right, comparator);

        merge(list, left, right, comparator);
    }

    private static void merge(List<PlayerBattingStats> list, List<PlayerBattingStats> left, List<PlayerBattingStats> right, Comparator<PlayerBattingStats> comparator) {
        int leftPointer = 0, rightPointer = 0, resultPointer = 0;

        while (leftPointer < left.size() || rightPointer < right.size()) {
            if (leftPointer < left.size() && rightPointer < right.size()) {
                if (comparator.compare(left.get(leftPointer), right.get(rightPointer)) <= 0) {
                    list.set(resultPointer++, left.get(leftPointer++));
                } else {
                    list.set(resultPointer++, right.get(rightPointer++));
                }
            } else if (leftPointer < left.size()) {
                list.set(resultPointer++, left.get(leftPointer++));
            } else if (rightPointer < right.size()) {
                list.set(resultPointer++, right.get(rightPointer++));
            }
        }
    }
}
