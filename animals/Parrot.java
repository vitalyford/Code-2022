package animals;

public class Parrot implements Animal {

    @Override
    public void getLegs() {
        // TODO Auto-generated method stub
        System.out.println("2");
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        System.out.println("Nope");
        
    }

    @Override
    public void sit() {
        // TODO Auto-generated method stub
        System.out.println("Rarely, typically flies");
        
    }

    @Override
    public void jump() {
        // TODO Auto-generated method stub
        System.out.println("In Tennessee, everything jumps");
        
    }
    
}
