package graph.representation;

import java.util.Arrays;

public class GraphAdjacencyMatrixRepresentation {
    public static void main(String[] args)
    {

        /*
         this is for an undirected graph
         here we are using adjacency matrix to represent this
        */
        int v = 6;
        int e = 9;
        int connection[][] = {{1,3},{1,5},{3,5},{3,4},{3,6},{3,2},{2,6},{4,6},{5,6}};


        //  create a matrix of v X v
        // here because we are using 1 based indexing we will make v+1 X v+1

        int graph[][] = new int[v+1][v+1];

         for (int i = 0 ; i < e ; i++ ) {

             // here we are basically getting the connected vertices
             int v1 = connection[i][0];
             int v2 = connection[i][1];

             // if v1 and v2 is connected
              graph[v1][v2] = 1;
              // then v2 and v1 should also connect
              graph[v2][v1] = 1;
         }

        // Print the matrix row by row
        for (int i = 0; i < graph.length; i++) {
            System.out.println(Arrays.toString(graph[i]));
        }
    }
}