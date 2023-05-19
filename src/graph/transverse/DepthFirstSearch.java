package graph.transverse;

import java.util.ArrayList;
import java.util.Arrays;

public class DepthFirstSearch {

    static ArrayList<ArrayList<Integer>> graph;
    static boolean visited[];

    public static void dfs(int source) {

        if (!visited[source]) {
            visited[source] = true;
            for (int i = 0; i < graph.get(source).size(); i++) {
                dfs(graph.get(source).get(i));
            }
        }
    }

    public static void main(String[] args) {

          /*
         this is for an undirected graph
         here we are using dfs to transverse it
        */

        int v = 6;
        int e = 9;
        int connection[][] = {{1, 3}, {1, 5}, {3, 5}, {3, 4}, {3, 6}, {3, 2}, {2, 6}, {4, 6}, {5, 6}};

        // initiate list
        graph = new ArrayList<>();
        visited = new boolean[v + 1];

        // fill the list with some initial value
        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }
        // creating the actual graph
        for (int j = 0; j < e; j++) {
            // here we are basically getting the connected vertices
            int v1 = connection[j][0];
            int v2 = connection[j][1];

            // if v1 and v2 is connected
            graph.get(v1).add(v2);
            // then v2 and v1 should also connect
            graph.get(v2).add(v1);
        }

        // Print the matrix row by row
        System.out.println(graph);
        dfs(1);
        System.out.println(Arrays.toString(visited));

    }


}

