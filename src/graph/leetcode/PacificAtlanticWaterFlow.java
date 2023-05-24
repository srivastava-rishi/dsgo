package graph.leetcode;

import java.util.ArrayList;

public class PacificAtlanticWaterFlow {

    static int row;
    static int column;


    private static void dfs(int i, int j , int[][] height , int previousHeight , boolean[][] visitedArray) {
        
        if (i < 0 || j < 0) return;
        if (i >= row || j >= column) return;
        if (height[i][j] < previousHeight) return;
        if(visitedArray[i][j]) return;

        visitedArray[i][j] = true;
        // reAssigned it
        previousHeight = height[i][j];

        dfs(i + 1, j, height,previousHeight,visitedArray);
        dfs(i - 1, j, height,previousHeight,visitedArray);
        dfs(i, j + 1, height,previousHeight,visitedArray);
        dfs(i, j - 1, height,previousHeight,visitedArray);

    }

    public static void main(String[] args) {

        int heights[][] = {{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}};

        ArrayList<ArrayList<Integer>> answer = new ArrayList<>();

        row = heights.length;
        column = heights[0].length;

        // initially  we will transverse only for them
        boolean[][] pacificOceanVisitedArray = new boolean[row][column];
        boolean[][] atlanticOceanVisitedArray = new boolean[row][column];


        // top and bottom
        for (int j = 0; j < column; j++) {
            dfs(0,j,heights,heights[0][j],pacificOceanVisitedArray);
            dfs(row-1,j,heights,heights[row-1][j],atlanticOceanVisitedArray);
        }
        // left and right
        for (int i = 0; i < row; i++) {
            dfs(i,0,heights,heights[i][0],pacificOceanVisitedArray);
            dfs(i,column-1,heights,heights[i][column-1],atlanticOceanVisitedArray);
        }


        // answer

        for(int k = 0 ; k < row ; k++) {
            //
            for(int l = 0 ; l < column ; l++){

                if (pacificOceanVisitedArray[k][l] && atlanticOceanVisitedArray[k][l]){
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(k);
                    temp.add(l);
                    answer.add(temp);
                }

            }
        }


        System.out.println(answer);
    }
}
