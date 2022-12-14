import java.util.Comparator;

class ComparePersonByFirstName implements Comparator<Person> {

    @Override
    public int compare(Person p1, Person p2) {
        return p1.firstName.compareTo(p2.firstName);
    }

}

class ComparePersonByLastName implements Comparator<Person> {
    
    @Override
    public int compare(Person p1, Person p2) {
        return p1.lastName.compareTo(p2.lastName);
    }

}

class ComparePersonByDoB implements Comparator<Person> {
    
    @Override
    public int compare(Person p1, Person p2) {
        return p1.dob.compareTo(p2.dob);
    }

}

public class Person {
    String firstName;
    String lastName;
    String dob;

    public Person(String fn, String ln, String dob) {
        this.firstName = fn;
        this.lastName = ln;
        this.dob = dob;
    }

    public String toString() {
        return firstName + " " + lastName + " " + dob;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Person)) {
            return false;
        }

        Person p = (Person)o;

        return this.firstName.equals(p.firstName) && this.lastName.equals(p.lastName);
    }

    @Override
    public int hashCode() {
        int hash = 3;

        if (firstName != null) {
            hash = hash * 17 + firstName.hashCode();
        }
        
        if (lastName != null) {
            hash = hash * 17 + lastName.hashCode();
        }

        // if (dob != null) {
        //     hash = hash * 17 + dob.hashCode();
        // }

        return hash;
    }
}
