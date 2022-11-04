import java.util.*;

public class DB {
    public static void main(String[] args) {
        //  
        Map<Person, Data> hm = new HashMap<>();
        
        hm.put(new Person("Alissa", "Cielecki", "45/45/45"), new Data("Hacking (Ethical)", "34534534534", "34 kjshdfjs 252"));

        hm.put(new Person("Alissa", "Cielecki", "11/23/1945"), new Data("Hacking (Ethical)", "34534534534", "34 kjshdfjs 252"));

        System.out.println(hm);


        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(5);
        pq.add(345);
        pq.add(-5234);
        pq.add(565);
        pq.add(2345);
        pq.add(-75);
        pq.add(5);

        System.out.println(pq);

        while (!pq.isEmpty()) {
            System.out.print(pq.poll() + " ");
        }

    }
}
