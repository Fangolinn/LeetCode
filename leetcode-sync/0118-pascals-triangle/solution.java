import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

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

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(Arrays.asList(1));

        for (int i = 1; i < numRows; i++) {
            result.add(getRow(i, result.get(i - 1)));
        }

        return result;
    }
}

// class Solution {
//     // testing someone else's solution from Leetcode
//     public List<List<Integer>> generate(int numRows) {
//         List<List<Integer>> result = new ArrayList<>();
//         if (numRows == 0) {
//             return result;
//         }

//         if (numRows == 1) {
//             List<Integer> firstRow = new ArrayList<>();
//             firstRow.add(1);
//             result.add(firstRow);
//             return result;
//         }

//         result = generate(numRows - 1);
//         List<Integer> prevRow = result.get(numRows - 2);
//         List<Integer> currentRow = new ArrayList<>();
//         currentRow.add(1);

//         for (int i = 1; i < numRows - 1; i++) {
//             currentRow.add(prevRow.get(i - 1) + prevRow.get(i));
//         }

//         currentRow.add(1);
//         result.add(currentRow);

//         return result;
//     }
// }
