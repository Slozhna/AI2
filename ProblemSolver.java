
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProblemSolver {

    public static boolean is_solution_available(int[] check_array) {
        int inv = 0;

        for (int i = 0; i < 9; i++) {
            if (check_array[i] > 0) {
                for (int j = 0; j < i; j++) {
                    if (check_array[j] > check_array[i]) {
                        inv += 1;
                    }
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            if (check_array[i] == 0) {
                inv += 1 + i / 3;
            }
        }

        if (inv % 2 != 0) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println("This lab is done by Kaporin (is3406) and Korobova (is3206)");
        System.out.println("Choose algorithm:\n\r 1.BFS\n\r 2.ASO\n\r 3.ASM\n\r");
        // Numbers to be adjusted if the debug toggle is present, as components
        // of args will be in different locations if it is.
        int searchTypeDebug = 0;
        //int eightPuzzleDebug = 1;
        int eightPuzzleDebug = 0;
        int i = 0;
        boolean debug = false;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            i = Integer.parseInt(br.readLine());
        } catch (NumberFormatException nfe) {
            System.err.println("Invalid Format!");
        }
        //String searchType = args[searchTypeDebug].toLowerCase();
        int searchType = i;

        int[] startingStateBoard = dispatchEightPuzzle(args,
                eightPuzzleDebug);

        if (is_solution_available(startingStateBoard)) {
            System.out.println("Solution is available for inputed array!");
        } else {
            System.out.println("Solution isn't (!!!) available for inputed array!");
            return;
        }
        
        if (searchType == 1) // Use BFSearch.java
        {
            BFSearch.search(startingStateBoard, debug);
        } // Use AStarSearch.java with number out of place
        else if (searchType == 2) {
            AStarSearch.search(startingStateBoard, debug, 'o');
        } // Use AStarSearch.java with Manhattan Distance
        else if (searchType == 3) {
            AStarSearch.search(startingStateBoard, debug, 'm');
        }
    }

    // Helper method to build our initial 8puzzle state passed in through args
    private static int[] dispatchEightPuzzle(String[] a, int d) {
        int[] initState = new int[9];
        // i -> loop counter
        for (int i = d; i < a.length; i++) {
            initState[i - d] = Integer.parseInt(a[i]);
        }
        return initState;
    }
}
