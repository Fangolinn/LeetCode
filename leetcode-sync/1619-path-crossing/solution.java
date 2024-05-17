import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isPathCrossing(String path) {
        Set<Pair<Integer, Integer>> visited = new HashSet<>();
        visited.add(new Pair(0, 0));

        Integer x = 0;
        Integer y = 0;
        
        for (var c : path.toCharArray()) {
            switch (c) {
                case 'N':
                    y++;
                    break;
                case 'S':
                    y--;
                    break;
                case 'E':
                    x++;
                    break;
                case 'W':
                    x--;
                    break;
            }

            Pair<Integer, Integer> point = new Pair(x, y);

            if (visited.contains(point)) return true;

            visited.add(point);
        }

        return false;
    }
}
