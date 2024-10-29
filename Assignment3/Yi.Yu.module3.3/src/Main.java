import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static ArrayList<Node> graph;
    public static void main(String[] args) throws FileNotFoundException {
        setupTree();
        BFS();
    }

    private static void BFS() {
        Queue<Node> queue = new LinkedList<>();

        Node startNode = findNodeByKey(1);
        queue.add(startNode);
        startNode.setVisited(true);

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            System.out.print(currentNode.getKey() + " ");

            for (int neighborKey : currentNode.getNodes()) {
                Node neighbor = findNodeByKey(neighborKey);
                if (neighbor != null && !neighbor.isVisited()) {
                    queue.add(neighbor);
                    neighbor.setVisited(true);
                }
            }
        }
        resetVisitedStatus();
    }

    private static void setupTree() throws FileNotFoundException {
        graph = new ArrayList<>();
        Scanner scan = new Scanner(new File("tree.txt"));
        while (scan.hasNext()) {
            String line = scan.nextLine();
            parseLine(line);
        }
    }

    private static void parseLine(String line) {
        String[] keys = line.split(" ");
        int key = Integer.parseInt(keys[0]);
        ArrayList<Integer> points = new ArrayList<>();
        for (int i = 1; i < keys.length; i++) {
            points.add(Integer.parseInt(keys[i]));
        }
        graph.add(new Node(key, points));
    }

    private static Node findNodeByKey(int key) {
        for (Node node : graph) {
            if (node.getKey() == key) {
                return node;
            }
        }
        return null;
    }
    private static void resetVisitedStatus() {
        for (Node node : graph) {
            node.setVisited(false);
        }
    }
}
