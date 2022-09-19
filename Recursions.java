import java.util.*;

public class Recursions {
    public static int binarySearch(ArrayList<Integer> list, int target, int low, int high) {
        // One-liner solution - it works!
        // return (list.get((int)((high + low) / 2)) == target) ? (int)((high + low) / 2) :
        //     (list.get((int)((high + low) / 2)) < target) ? binarySearch(list, target, (int)((high + low) / 2) + 1, high) :
        //         binarySearch(list, target, low, (int)((high + low) / 2) - 1);
        
        int mid = (int)((high + low) / 2);
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
        //    ((list.get(index) == target) ? index : 
        //        search(list, target, ++index));
        
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
        Integer[] data = {1,3,5,6,6,7,34,4,42,23,3,423,24,23,4,234,234,234,234,63};
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(data));
        Collections.sort(list);
        System.out.println(binarySearch(list, 23, 0, list.size() - 1));
    }
}
