public class Pi {
    public double sum(int k) {
        return (k < 0) ? 0 : Math.pow(-1.0, k) / ((2*k + 2) * (2*k + 3) * (2*k + 4)) + sum(k - 1);
    }    
    public static void main(String[] args) {
        Pi p = new Pi();
        System.out.println(3 + 4 * p.sum(10000));
    }
}