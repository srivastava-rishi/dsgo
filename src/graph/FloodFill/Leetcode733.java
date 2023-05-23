package graph.FloodFill;

import java.util.Arrays;

public class Leetcode733 {


    public static void dfs(int[][] result,int i, int j,int initialColor, int color) {

        int row = result.length;
        int column = result[0].length;

        if(i < 0 || j < 0 ) return;
        if(i >= row || j >= column) return;
        if(result[i][j] != initialColor) return;

        result[i][j] = color;

        dfs(result,i+1,j,initialColor,color);
        dfs(result,i-1,j,initialColor,color);
        dfs(result,i,j-1,initialColor,color);
        dfs(result,i,j+1,initialColor,color);

    }


    public static void main(String[] args) {

        int sr = 1;
        int sc = 1;
        int color = 2;

       int image[][] = {{1,1,1},{1,1,0},{1,0,1}};

        int initialColor = image[sr][sc];
        // call your dfs
        dfs(image,sr,sc,initialColor,color);
        System.out.println(Arrays.deepToString(image));
    }
}
