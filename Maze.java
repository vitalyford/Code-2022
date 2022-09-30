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

    public static boolean solution(int[][] maze) {
        ArrayList<String> pos = new ArrayList<>();
        boolean found = helper(maze, 0, 0, pos);
        for (String line : pos)
            System.out.println(line);
        return found;
    }

    public static void main(String[] args) {
        System.out.println(solution(maze1));
        System.out.println(solution(maze2));
        System.out.println(solution(maze3));
        System.out.println(solution(maze4));
    }
}
