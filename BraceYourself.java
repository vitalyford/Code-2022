import java.util.*;

public class BraceYourself {
    public static boolean isLegal(String input) {
        Stack<Character> stack = new Stack<>();

        for (Character c : input.toCharArray()) {
            if (c == '{') {
                stack.push(c);
            }
            else if (c == '}') {
                if (stack.empty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.empty();

        // int open = 0;
        // int closed = 0;
        // for (int i = 0; i < input.length(); i++) {
        //     if (input.charAt(i) == '{') {
        //         open++;
        //     }
        //     else if (input.charAt(i) == '}') {
        //         closed++;
        //         if (open < closed) {
        //             return false;
        //         }
        //     }
        // }
        // if (open != closed) {
        //     return false;
        // }
        // return true;
    }

    public static void main(String[] args) {
        System.out.println(isLegal("{anna{beta}gone}")); // true
        System.out.println(isLegal("{anna{{beta}gone}"));// false
        System.out.println(isLegal("{annabeta}gone}"));  // false
        System.out.println(isLegal("a{nnabeta}gone}"));  // false
        System.out.println(isLegal("a{{nnabeta}gone}")); // true
        System.out.println(isLegal("a}}nnabeta{gone{")); // false
        System.out.println(isLegal("a}{nnabeta{gone}")); // false
        System.out.println(isLegal("a{{{{{nnabeta}gone}}}}po")); // true
    }
}
