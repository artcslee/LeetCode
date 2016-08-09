package com.arthur.problems;

import com.arthur.LeetCodeProblem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *  Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 *
 * For example, given the following matrix:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * Return 4.
 */
public class MaximumSquare extends LeetCodeProblem {
    @Override
    public Object setupProblem(String[] args) {
        ArrayList<String> arg = new ArrayList<>();
        for (int x=0; x<args.length; x++) {
            arg.add(args[x]);
        }
        return arg;
    }

    @Override
    public void solution(Object arg) {
        List<String> matrixStrings = (List<String>) arg;
        Iterator<String> args = (matrixStrings).iterator();

        char[][] matrix = new char[matrixStrings.size()][matrixStrings.get(0).length()];

        int row = 0;
        while(args.hasNext()) {
            int column = 0;
            String rowString = args.next();
            for (int col=0; col<rowString.length(); col++) {
                matrix[row][col] = rowString.charAt(col);
                System.out.print(matrix[row][col] + " ");
            }
            System.out.print("\n");
            row++;
        }

        int maxSquare = maximalSquare(matrix);
        System.out.println("Largest Square Size: [" + maxSquare + ']');
    }

    public int maximalSquare(char[][] matrix) {
        return 0;
    }
}
