import java.util.*;

public class DB {
    public static void main(String[] args) {

        Map<Person, Data> hm = new HashMap<>();
        
        hm.put(new Person("Alissa", "Cielecki", "45/45/45"), new Data("Hacking (Ethical)", "34534534534", "34 kjshdfjs 252"));

        hm.put(new Person("Alissa", "Cielecki", "11/23/1945"), new Data("Hacking (Ethical)", "34534534534", "34 kjshdfjs 252"));

        System.out.println(hm);

        PriorityQueue<Person> pq = new PriorityQueue<>(new Comparator<Person>() {

            @Override
            public int compare(Person o1, Person o2) {
                // TODO Auto-generated method stub
                return 0;
            }

        });

        pq.add(new Person("Alice", "Alice", "2423423"));
        pq.add(new Person("Bob", "Bob", "14"));
        pq.add(new Person("Eve", "Eve", "234"));
        pq.add(new Person("John", "John", "6547"));
        pq.add(new Person("Zach", "Zach", "23460"));
        
        ArrayList<Person> temp = new ArrayList<>();

        while (!pq.isEmpty()) {
            temp.add(pq.poll());
        }

        Collections.sort(temp, new ComparePersonByDoB());
        System.out.println(temp);

        Collections.sort(temp, new ComparePersonByFirstName());
        System.out.println(temp);

        Collections.sort(temp, new ComparePersonByLastName());
        System.out.println(temp);

    }
}
