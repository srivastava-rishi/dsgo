package graph.connectedComponents;

import java.util.ArrayList;

public class ConnectedComponents {


    static ArrayList<ArrayList<Integer>> graph;
    static boolean visited[];


    private static void dfs(int source) {

        if (!visited[source]){
            visited[source] = true;
            for (int i = 0 ; i < graph.get(source).size() ; i++){
                dfs(graph.get(source).get(i));
            }
        }

    }

    public static void main(String[] args) {

         /*
         Actually it is very simple
         we just need to find the total number of connected components in the graph
        */

        int v = 8;
        int e = 5;
        int connection[][] = {{1, 2}, {2, 3}, {2, 4}, {3, 5}, {6,7}};
        int answer =  0;

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


        // Now , we just need to call dfs

        for (int i = 1 ; i <= v  ; i++) {
            if (!visited[i]){
                answer = answer + 1;
                dfs(i);
            }
        }

        System.out.println(answer);

    }

}
