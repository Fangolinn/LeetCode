import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    private List<Integer> getRow(int rowNo, List<Integer> prevRow){
        List<Integer> row = new ArrayList<>(rowNo);
        row.add(1);

        for (int i = 1; i < prevRow.size(); i++) {
            row.add(prevRow.get(i - 1) + prevRow.get(i));
        }

        row.add(1);

        return row;
    }
    
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = Arrays.asList(1);

        for (int i = 1; i <= rowIndex; i++) {
            result = getRow(i + 1, result);
        }

        return result;
    }
}
