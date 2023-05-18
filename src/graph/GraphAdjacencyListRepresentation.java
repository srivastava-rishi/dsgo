package graph;

import java.util.ArrayList;
public class GraphAdjacencyListRepresentation {

    public static void main(String[] args) {

        /*
         this is for an undirected graph
         here we are using adjacency list to represent this
        */

        int v = 6;
        int e = 9;
        int connection[][] = {{1,3},{1,5},{3,5},{3,4},{3,6},{3,2},{2,6},{4,6},{5,6}};

        // list
        ArrayList<ArrayList<Integer>>  adjacencyList = new ArrayList<>();

        // fill the list with some initial value
        for(int i = 0 ; i <= v ; i++){
            adjacencyList.add(new ArrayList<>());
        }

        // putting the data
        for (int j = 0 ; j < e ; j++ ) {
            // here we are basically getting the connected vertices
            int v1 = connection[j][0];
            int v2 = connection[j][1];

            // if v1 and v2 is connected
             adjacencyList.get(v1).add(v2);
            // then v2 and v1 should also connect
            adjacencyList.get(v2).add(v1);
        }

        // Print the matrix row by row
        System.out.println(adjacencyList);

    }

}
