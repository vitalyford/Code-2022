import java.util.*;
import java.io.*;

public class HashMapPlay {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("giant_text.txt"));
        /**
         * Key   - the morse code
         * Value - the corresponding English letter
         */
        // HashMap<String, String> hm = new HashMap<>();

        // while (sc.hasNextLine()) {
        //     String[] line = sc.nextLine().split(" ");
        //     hm.put(line[1], line[0]);
        // }

        // System.out.println(hm);

        // for (Map.Entry<String, String> entry : hm.entrySet()) {
        //     System.out.println(entry.getKey() + " and " + entry.getValue());
        // }

        // System.out.println(hm.get(".-."));
        // System.out.println(hm.containsKey(".-."));
        // System.out.println(hm.containsValue("W"));

        HashMap<String, Integer> hm = new HashMap<>();

        String input = sc.nextLine();

        String[] line = input.split(" ");

        for (String word : line) {
            if (!hm.containsKey(word)) {
                hm.put(word, 1);
            } else {
                hm.put(word, hm.get(word) + 1);
            }
        }

        System.out.println(hm.get("quis"));

        
    }
}