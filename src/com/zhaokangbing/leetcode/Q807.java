package com.zhaokangbing.leetcode;

public class Q807 {
    public static void main(String[] args) {
        Q807 test = new Q807();
        int[][] grid = {{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}};
        System.out.println(test.maxIncreaseKeepingSkyline(grid));
    }

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] maxLeftOrRight = new int[grid.length];
        int[] maxTopOrButtom = new int[grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            int maxInRow = 0;
            for (int j = 0; j < grid[0].length; j++) {
                maxInRow = maxInRow > grid[i][j] ? maxInRow : grid[i][j];
            }
            maxLeftOrRight[i] = maxInRow;
        }

        for (int i = 0; i < grid[0].length; i++) {
            int maxInCol = 0;
            for (int j = 0; j < grid.length; j++) {
                maxInCol = maxInCol > grid[j][i] ? maxInCol : grid[j][i];
            }
            maxTopOrButtom[i] = maxInCol;
        }

        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                //取较小值,
                int curTarget = maxLeftOrRight[i] < maxTopOrButtom[j] ? maxLeftOrRight[i] : maxTopOrButtom[j];
                sum += (curTarget - grid[i][j]);
            }

        }

        return sum;
    }
}
