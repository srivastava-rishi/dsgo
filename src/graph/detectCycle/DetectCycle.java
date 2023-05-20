package graph.detectCycle;

import java.util.ArrayList;

public class DetectCycle {


    static ArrayList<ArrayList<Integer>> graph;
    static boolean visited[];


    public static boolean dfs(int source, int parent) {
        boolean loopExist = false;
        if (!visited[source]) {
            visited[source] = true;
            for (int i = 0; i < graph.get(source).size(); i++) {
                if (visited[graph.get(source).get(i)] && parent != graph.get(source).get(i)){
                    return true;
                }
                dfs(graph.get(source).get(i), source);
            }
        }
        return loopExist;
    }

    public static void main(String[] args) {

        /*
         it is also very simple
         we just need to find the if a cycle exist in the graph or not
        */

        int v = 8;
        int e = 7;
        int connection[][] = {{1, 2}, {1, 5}, {2, 3}, {2, 4}, {3, 5}, {3, 4}, {6, 7}};

        boolean cycleExist = false;

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
     /*
      remember this if the question doesn't say specifically the graph has no sub graph then only we will call the dfs for 1 node
       otherwise we will call it for every possible vertex
      */

        for (int i = 1; i <= v; i++) {
            if (!visited[i]) {
                if (dfs(i, 0)) {
                    cycleExist = true;
                }
            }
        }
        // return weather the cycle exist or not
        System.out.println(cycleExist);
    }
}
