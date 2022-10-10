import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// maze1 = [
//     [0, 0, 0, 0],
//     [0, 0, 1, 0],
//     [1, 1, 1, 0],
//     [1, 1, 1, 0]
// ]

// maze2 = [
//     [0, 0, 1, 0],
//     [0, 0, 1, 0],
//     [1, 0, 1, 0],
//     [1, 0, 0, 0]
// ]

// maze3 = [
//     [0, 0, 1, 0],
//     [0, 0, 1, 0],
//     [1, 0, 1, 0],
//     [1, 0, 1, 0]
// ]

// problem: create a function to assist a simple robot in navigating this maze.
// the maze is represented by a 2D array, where 0 represents a valid path and 1 represents a barrier.
// the robot starts a [0,0] and the end of the maze is at [N,M] (bottom right corner).
// the robot can only move right and down

// output: boolean of whether this maze is traversable

// Candidate notes below

public class Maze {
    public static int[][] maze1 = { { 0, 0, 0, 0, }, { 0, 0, 1, 0, }, { 1, 1, 1, 0, }, { 1, 1, 1, 0, } };
    public static int[][] maze2 = { { 0, 0, 1, 0, }, { 0, 0, 1, 0, }, { 1, 0, 1, 0, }, { 1, 0, 0, 0, } };
    public static int[][] maze3 = { { 0, 0, 1, 0, }, { 0, 0, 1, 0, }, { 1, 0, 1, 0, }, { 1, 0, 1, 0, } };
    public static int[][] maze4 = { { 0, 0, 0, 0, 0 },
                                    { 0, 0, 1, 1, 1 },
                                    { 1, 0, 0, 0, 0 },
                                    { 1, 0, 1, 0, 0 } };

    public static boolean helper(int[][] maze, int x, int y, ArrayList<String> pos) {
        // hella of a lines
        return (y == maze.length - 1 && x == maze[0].length - 1) ? true :
                (x + 1 != maze[0].length && maze[y][x + 1] == 0 && helper(maze, x + 1, y, pos) && pos.add((x + 1) + " " + y)) ? true :
                ((y + 1 != maze.length && maze[y + 1][x] == 0) && helper(maze, x, y + 1, pos) && pos.add(x + " " + (y + 1))) ? true : false;
        
        // if (y == maze.length - 1 && x == maze[0].length - 1) {
        //     return true;
        // }
        // boolean found = false;
        // if (x + 1 != maze[0].length && maze[y][x + 1] == 0) {
        //     found = helper(maze, x + 1, y, pos);
        //     if (found) {
        //         pos.add((x + 1) + " " + y);
        //     }
        // }
        // if (!found) {
        //     if (y + 1 != maze.length && maze[y + 1][x] == 0) {
        //         found = helper(maze, x, y + 1, pos);
        //         if (found) {
        //             pos.add(x + " " + (y + 1));
        //         }
        //     }
        // }
        // return found;
    }

    public static boolean solutionStack(int[][] maze) {
        Stack<Integer[]> stack = new Stack<Integer[]>();
        ArrayList<String> visit = new ArrayList<>();
        stack.push(new Integer[]{0,0});
        while(!stack.empty()){
            Integer[] curr = stack.peek();
            visit.add(Arrays.toString(curr));
            if((curr[0] + 1 < maze[0].length && maze[curr[1]][curr[0] + 1] == 0) && (!visit.contains(Arrays.toString(new Integer[]{curr[0] + 1, curr[1]}))) ){
                stack.push(new Integer[]{curr[0] + 1, curr[1]}); 
            }
            else if((curr[1] + 1 < maze.length && maze[curr[1] + 1][curr[0]] == 0) && (!visit.contains(Arrays.toString(new Integer[]{curr[0], curr[1] + 1}))) ){
                stack.push(new Integer[]{curr[0], curr[1] + 1});
            }
            else{
                stack.pop();
            }

            if(!stack.empty() && (stack.peek()[0] == maze[0].length - 1) && (stack.peek()[1] == maze.length - 1)){
                return true;
            }
        }
        return false;
    }


    public static boolean solution(int[][] maze) {
        ArrayList<String> pos = new ArrayList<>();
        boolean found = helper(maze, 0, 0, pos);
        for (String line : pos)
            System.out.println(line);
        return found;
    }

    public static void main(String[] args) {
        System.out.println(solutionStack(maze1));
        System.out.println(solutionStack(maze2));
        System.out.println(solutionStack(maze3));
        System.out.println(solutionStack(maze4));
    }
}
