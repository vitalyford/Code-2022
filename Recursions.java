import java.util.*;

public class Recursions {

    public static void hanoi(int n, String src, String dst, String spare, java.util.LinkedList<String> out) {
        if (n == 1) {
            out.add("Move from " + src + " to " + dst);
        }
        else {
            hanoi(n - 1, src, spare, dst, out);
            hanoi(1, src, dst, spare, out);
            hanoi(n - 1, spare, dst, src, out);
        }
    }

    public static int rabbits(int m) {
        return (m <= 2) ? 1 : rabbits(m - 1) + rabbits(m - 2);
    }

    public static String reverseString(String input) {
        // char temp = input.charAt(input.length()-1);
        // input = input.substring(0, input.length()-1);
        // if (input.length() > 0) {
        // return temp + reverseString(input);
        // } else {
        // return temp + "";
        // }
        return (input.length() > 0)
                ? input.charAt(input.length() - 1) + reverseString(input.substring(0, input.length() - 1))
                : "";
    }

    public static int factorial(int n) {

        // int facVal = 1;
        // for(int i = 1; i < n + 1; i++)
        // {
        // facVal *= i;

        // }
        // return 1;

        // base case
        // if (n > 0) {
        // return n * factorial(n - 1);
        // } else {
        // return 1;
        // }

        return ((n > 0) ? n * factorial(n - 1) : 1);
    }

    public static int binarySearch(ArrayList<Integer> list, int target, int low, int high) {
        // One-liner solution - it works!
        // return (list.get((int)((high + low) / 2)) == target) ? (int)((high + low) /
        // 2) :
        // (list.get((int)((high + low) / 2)) < target) ? binarySearch(list, target,
        // (int)((high + low) / 2) + 1, high) :
        // binarySearch(list, target, low, (int)((high + low) / 2) - 1);

        int mid = (int) ((high + low) / 2);
        if (list.get(mid) == target) {
            return mid;
        }
        if (list.get(mid) < target) {
            return binarySearch(list, target, mid + 1, high);
        }
        return binarySearch(list, target, low, mid - 1);
    }

    public static int search(ArrayList<Integer> list, int target, int index) {
        // One-liner solution
        // return (index == list.size()) ? -1 :
        // ((list.get(index) == target) ? index :
        // search(list, target, ++index));

        if (index == list.size())
            return -1;
        if (list.get(index) == target)
            return index;
        else {
            // do the same thing recursively
            return search(list, target, ++index);
        }
    }

    public static void main(String[] args) {
        Integer[] data = { 1, 3, 5, 6, 6, 7, 34, 4, 42, 23, 3, 423, 24, 23, 4, 234, 234, 234, 234, 63 };
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(data));
        Collections.sort(list);
        // System.out.println(binarySearch(list, 23, 0, list.size() - 1));

        // System.out.println(factorial(10));

        // System.out.println(reverseString("A Santa lived as a devil at NASA"));

        // System.out.println(rabbits(100));
        java.util.LinkedList<String> out = new java.util.LinkedList<>();
        hanoi(64, "A", "B", "C", out);
        System.out.println(out.size());
    }
}

