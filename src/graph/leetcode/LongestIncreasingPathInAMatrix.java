package graph.leetcode;

import java.util.Arrays;

public class LongestIncreasingPathInAMatrix {

    static int row;
    static int column;
    static int path;
    static int[][] increasingPathArray;

    static int answer;

    public static void main(String[] args) {

        int matrix[][] = {{9,9,4},{6,6,8},{2,1,1}};

        row = matrix.length;
        column = matrix[0].length;

        increasingPathArray = new int[row][column];

        // we need to run it for each cell
        for(int i = 0 ; i < row; i++){

            for(int j = 0 ; j < column ; j++) {
                path = 0;
                dfs(i,j,matrix,-1);
            }
        }

        System.out.println(answer);


    }

    public static int dfs(int i, int j, int[][] matrix, int previousValue) {
        if(i < 0 || j < 0) return 0;
        if(i >= row || j >= column) return 0;
        if(matrix[i][j] <= previousValue) return 0;
        if(increasingPathArray[i][j] != 0) return  increasingPathArray[i][j];

        path = 1;

     path = Math.max(path,1+dfs(i+1,j,matrix,matrix[i][j]));
     path = Math.max(path,1+dfs(i-1,j,matrix,matrix[i][j]));
     path = Math.max(path,1+dfs(i,j+1,matrix,matrix[i][j]));
     path = Math.max(path,1+dfs(i,j-1,matrix,matrix[i][j]));

     answer = Math.max(answer,path);
     return  increasingPathArray[i][j] = path;
    }
}
