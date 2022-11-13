import java.util.*;

public class Solution {
    private static boolean checkApplesColCut(String[] pizza, int sR, int sC, int eR, int eC, int col) {
        // Checking the top part
        boolean leftCheck = false;
        for (int r = sR; r <= eR; r++) {
            for (int c = sC; c < col; c++) {
                if (pizza[r].charAt(c) == 'A') {
                    leftCheck = true;
                    break;
                }
            }
            if (leftCheck) {
                break;
            }
        }

        // Checking the bottom part
        boolean rightCheck = false;
        for (int r = sR; r <= eR; r++) {
            for (int c = col; c <= eC; c++) {
                if (pizza[r].charAt(c) == 'A') {
                    rightCheck = true;
                    break;
                }
            }
            if (rightCheck) {
                break;
            }
        }

        return leftCheck && rightCheck;
    }

    private static boolean checkApplesRowCut(String[] pizza, int sR, int sC, int eR, int eC, int row) {
        // Checking the top part
        boolean topCheck = false;
        for (int r = sR; r < row; r++) {
            for (int c = sC; c <= eC; c++) {
                if (pizza[r].charAt(c) == 'A') {
                    topCheck = true;
                    break;
                }
            }
            if (topCheck) {
                break;
            }
        }

        // Checking the bottom part
        boolean bottomCheck = false;
        for (int r = row; r <= eR; r++) {
            for (int c = sC; c <= eC; c++) {
                if (pizza[r].charAt(c) == 'A') {
                    bottomCheck = true;
                    break;
                }
            }
            if (bottomCheck) {
                break;
            }
        }

        return topCheck && bottomCheck;
    }

    // memoization
    private static long helper(String[] pizza, int k, int sR, int sC, int eR, int eC, Map<String, Long> memo) {
        String s = sR + " " + sC + " " + k;
        if (memo.containsKey(s)) {
            return memo.get(s);
        }

        if (k == 1) {
            return 1; // it's one way to cut a pizza into k pieces
        }
        long totalWays = 0;
        // Cutting horizontally
        for (int row = sR + 1; row <= eR; row++) {
            if (checkApplesRowCut(pizza, sR, sC, eR, eC, row)) {
                totalWays += helper(pizza, k - 1, row, sC, eR, eC, memo) % (long)(1E9 + 7);
            }
        }

        // Cutting vertically
        for (int col = sC + 1; col <= eC; col++) {
            if (checkApplesColCut(pizza, sR, sC, eR, eC, col)) {
                totalWays += helper(pizza, k - 1, sR, col, eR, eC, memo) % (long)(1E9 + 7);
            }
        }

        memo.put(s, totalWays % (long)(1E9 + 7));

        return totalWays % (long)(1E9 + 7);
    }

    public static int ways(String[] pizza, int k) {
        // ["A..","AAA","..."]
        /* charAt()
        A . .
        A A A
        . . .
        */
        return (int)helper(pizza, k, 0, 0, pizza.length - 1, pizza[0].length() - 1, new HashMap<>());
    }

    public static void main(String[] args) {
        String[] pizza = {"A..","AAA","..."};
        int k = 3;
        System.out.println(ways(pizza, k));
    }
}