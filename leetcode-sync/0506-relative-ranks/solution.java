import java.util.Comparator;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.Map.Entry;

class Solution {
    private String placeToRank(int place){
        switch (place) {
            case 1:
                return "Gold Medal";
            case 2:
                return "Silver Medal";
            case 3:
                return "Bronze Medal";
            default:
                return Integer.toString(place);
        }
    }

    public String[] findRelativeRanks(int[] score) {
        SortedMap<Integer, String> scorePlaceMap = new TreeMap<>(Comparator.reverseOrder());

        for (int i : score) {
            scorePlaceMap.put(i, null);
        }

        int placeNo = 1;
        for (Integer key : scorePlaceMap.keySet()) {
            scorePlaceMap.put(key, placeToRank(placeNo++));
        }

        String[] result = new String[score.length];
        for (int i = 0; i < score.length; i++) {
            result[i] = scorePlaceMap.get(score[i]);
        }

        return result;
    }
}
