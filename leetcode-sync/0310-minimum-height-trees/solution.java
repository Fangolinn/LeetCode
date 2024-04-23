import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.Queue;
import java.util.ArrayDeque;

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n == 1) return Collections.singletonList(0);
        
        int[] ind = new int[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] edge: edges) {
            ind[edge[0]]++;
            ind[edge[1]]++;
            map.computeIfAbsent(edge[0], key -> new ArrayList<>()).add(edge[1]);
            map.computeIfAbsent(edge[1], key -> new ArrayList<>()).add(edge[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<ind.length;i++) {
            if(ind[i] == 1) {
                queue.add(i);
            }
        }

        int processed = 0;
        while(n - processed > 2) {
            int size = queue.size();
            processed += size;
            for(int i=0;i<size;i++) {
                int poll = queue.poll();
                for(int adj: map.get(poll)) {
                    if(--ind[adj] == 1) {
                        queue.add(adj);
                    }
                }
            }
        }

        return new ArrayList<>(queue);
    }


    public List<Integer> findMinHeightTrees_v2(int n, int[][] edges) {
        // My solution, doesn't work (it's too slow)
        if (n == 1)
            return Collections.singletonList(0);

        Map<Integer, Set<Integer>> outgoingEdges = new HashMap<>(n);
        for (int[] edge : edges) {
            outgoingEdges.computeIfAbsent(edge[0], key -> new HashSet<>()).add(edge[1]);
            outgoingEdges.computeIfAbsent(edge[1], key -> new HashSet<>()).add(edge[0]);
        }

        Set<Integer> removedNodes = new HashSet<>();
        Set<Integer> toRemove = new HashSet<>();

        while (outgoingEdges.size() > 2){
            toRemove.clear();
            for (Map.Entry<Integer, Set<Integer>> entry : outgoingEdges.entrySet()) {
                entry.getValue().removeAll(removedNodes);
                if (entry.getValue().size() == 1) {
                    toRemove.add(entry.getKey());
                }
            }
            
            for (Integer node : toRemove) {
                outgoingEdges.remove(node);
            }

            removedNodes.addAll(toRemove);
        }

        return new ArrayList<>(outgoingEdges.keySet());
    }
    
    private int min = Integer.MAX_VALUE;

    public List<Integer> findMinHeightTrees_v1(int n, int[][] edges) {
        // This solution works but is slow
        Map<Integer, List<Integer>> outgoingEdges = new HashMap<>(n);
        for (int[] edge : edges) {
            outgoingEdges.computeIfAbsent(edge[0], key -> new ArrayList<>()).add(edge[1]);
            outgoingEdges.computeIfAbsent(edge[1], key -> new ArrayList<>()).add(edge[0]);
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int dijkstra = heightDijkstra(i, outgoingEdges);
            if (dijkstra < min) {
                min = dijkstra;
                result.clear();
            }

            if (dijkstra == min) {
                result.add(i);
            }
        }

        return result;
    }

    private int heightDijkstra(int root, Map<Integer, List<Integer>> edges) {
        Map<Integer, Integer> distance = new HashMap<>();
        Queue<Integer> queue = new ArrayDeque<>();

        distance.put(root, 0);
        queue.offer(root);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            int nodeDistance = distance.get(node);

            if (nodeDistance > min) {
                return nodeDistance;
            }

            for (Integer child : edges.getOrDefault(node, new ArrayList<>())) {
                if (!distance.containsKey(child)) {
                    distance.put(child, nodeDistance + 1);
                    queue.offer(child);
                }
            }
        }

        return Collections.max(distance.values());
    }
}
