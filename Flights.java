import java.io.*;
import java.util.*;
import java.util.Scanner;

public class Flights {
    public static boolean findPath(ArrayList<String> nodes, String src, String dst) {
        Stack<String> stack = new Stack<>();
        ArrayList<String> visited = new ArrayList<>();
        stack.push(src);
        visited.add(src);
        boolean found = false;
        while (!stack.empty() && !found) {
            src = stack.peek();
            // going over all possible paths
            boolean attempted = false;
            for (String node : nodes) {
                if (node.substring(0, 1).equals(src)) {
                    attempted = true;
                    String[] paths = node.split(" ");
                    // picking where we can go from src
                    int i = 1;
                    for (; i < paths.length; i++) {
                        // check if we found the path
                        if (paths[i].equals(dst)) {
                            // we found it!
                            stack.push(paths[i]);
                            found = true;
                            break;
                        }
                        // to avoid looping, ...
                        if (!visited.contains(paths[i])) {
                            visited.add(paths[i]);
                            stack.push(paths[i]);
                            break;
                        }
                    }
                    // we are stuck
                    if (i == paths.length) {
                        stack.pop();
                    }
                    break;
                }
            }
            if (!attempted) {
                stack.pop();
            }
        }
        if (found) {
            System.out.println(stack);
        }
        return found;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("flights_input.txt"));

        ArrayList<String> nodes = new ArrayList<>();

        while (sc.hasNext()) {
            String line = sc.nextLine();
            nodes.add(line);
        }

        // System.out.println(nodes);

        System.out.println(findPath(nodes, "S", "P"));
    }
}
