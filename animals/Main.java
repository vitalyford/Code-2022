package animals;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Animal> list = new ArrayList<>();
        list.add(new Cat());
        list.add(new Dog());
        list.add(new Parrot());

        for (Animal a : list) {
            a.getLegs();
            a.run();
            a.jump();
            a.sit();
        }
    }
}
