import java.util.HashSet;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Set;

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        HashMap<Integer, Set<Integer>> outgoingEdges = new HashMap<>(n);

        for (int[] edge : edges) {
            if (!outgoingEdges.containsKey(edge[0])) {
                outgoingEdges.put(edge[0], new HashSet<>());
            }

            outgoingEdges.get(edge[0]).add(edge[1]);

            if (!outgoingEdges.containsKey(edge[1])) {
                outgoingEdges.put(edge[1], new HashSet<>());
            }

            outgoingEdges.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> queue = new ArrayDeque<>(n);
        Set<Integer> visited = new HashSet<>(n);

        queue.add(source);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (visited.contains(current)) {
                continue;
            }

            if (current == destination){
                return true;
            }

            visited.add(current);

            for (Integer node : outgoingEdges.getOrDefault(current, new HashSet<>())) {
                queue.offer(node);
            }
        }

        return false;
    }
}
