import java.util.*;

public class Prog1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String answer = "";
            String line = sc.nextLine();
            if (line.equals("quit")) {
                break;
            }
            String[] nums = line.split(" ");
            for (int i = 0; i < nums.length - 1; i++) {
                int a = Integer.parseInt(nums[i]);
                int b = Integer.parseInt(nums[i + 1]);
                int c = a * b;
                if (c < 0) { // a possible zigzag
                    answer = "Yes";
                }
                else if (c > 0) { // no zigzag
                    answer = "No";
                    break;
                }
                else { // there is a zero detected!
                    answer = "Zero value";
                    break;
                }
            }
            System.out.println(answer);
        }
    }
}
