package graphs;

import java.util.HashMap;
import java.util.Map;

public class CloneGraph {
    Map<Node, Node> map = new HashMap<>();

    public Node solution(Node node) {
        if(node == null) return null;

        return dfs(node);
    }

    private Node dfs(Node node) {
        if(map.containsKey(node)) {
            return map.get(node);
        }

        Node copy = new Node(node.val);

        map.put(node, copy);

        for(Node n : node.neighbors) {
            copy.neighbors.add(dfs(n));
        }

        return copy;
    }
}
