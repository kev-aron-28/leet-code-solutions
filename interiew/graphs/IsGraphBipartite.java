package graphs;

public class IsGraphBipartite {
    public boolean solution(int graph[][]) {
        int n = graph.length;
        int color[] = new int[n];

        for(int i = 0; i < n; i++) {
            if(color[i] == 0) {
                if(!dfs(i, 1, color, graph)) return false;
            }
        }

        return true;
    }

    private boolean dfs(int node, int currentColor, int color[], int graph[][]) {

        color[node] = currentColor;

        for(int n : graph[node]) {
            if(color[n] == 0) {
                if(!dfs(n, -currentColor, color, graph)) return false;
            } else if(color[n] == currentColor) {
                return false;
            }
        }

        return true;
    }
}
