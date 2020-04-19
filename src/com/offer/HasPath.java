package com.offer;

/**
 * @program: datastructure
 * @description: 矩阵中的路径
 * @author: Mr.Wang
 * @create: 2020-04-19 11:26
 **/
public class HasPath {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        boolean[] visitFlags = new boolean[matrix.length];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (helper(matrix, rows, cols, row, col, str, 0, visitFlags)) {
                    return true;
                }
            }
        }
        return true;
    }

    private boolean helper(char[] matrix, int rows, int cols, int row, int col, char[] str, int k, boolean[] visitFlags) {
        int index = row * cols + col;
        if (row < 0 || row >= rows || col < 0 || col >= cols || visitFlags[index] || matrix[index] != str[k]) {
            return false;
        }
        visitFlags[index] = true;

        if (k == str.length - 1) {
            return true;
        }
        k++;
        if (helper(matrix, rows, cols, row-1, col, str, 0, visitFlags) ||
                helper(matrix, rows, cols, row+1, col, str, 0, visitFlags) ||
                helper(matrix, rows, cols, row, col-1, str, 0, visitFlags) ||
                helper(matrix, rows, cols, row, col+1, str, 0, visitFlags)) {
            return true;
        }
        visitFlags[index]=false;
        return false;
    }
}
