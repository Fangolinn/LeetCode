import java.util.function.Predicate;

class Solution {
    public int checkRecordV1(int n) {
        // Backtracking, TLE
        return (int) (viableRecords(new StringBuilder(), n) % (Math.pow(10, 9) + 7));
    }

    private long viableRecords(StringBuilder history, int recordLength) {
        System.out.println(history);

        if (history.length() == recordLength)
            return 1;

        long result = 0;

        history.append('P');
        result += viableRecords(history, recordLength);
        history.deleteCharAt(history.length() - 1);

        if (!history.toString().contains("A")) {
            history.append('A');
            result += viableRecords(history, recordLength);
            history.deleteCharAt(history.length() - 1);
        }

        if (history.length() < 2 || !history.substring(history.length() - 2, history.length()).equals("LL")) {
            history.append('L');
            result += viableRecords(history, recordLength);
            history.deleteCharAt(history.length() - 1);
        }

        return result;
    }

    private static final int MOD = 1000000000 + 7;

    // Code stolen from LeetCode solutions, I don't understand this
    public int checkRecord(int n) {
        int[][] prevDP = new int[2][3];
        prevDP[0][0] = 1;
        prevDP[0][1] = 1;
        prevDP[0][2] = 1;
        prevDP[1][0] = 1;
        prevDP[1][1] = 1;
        prevDP[1][2] = 1;
        
        for(int i = 1; i <= n; i++){
            int[][] newDP = new int[2][3];
            for(int a = 0; a < 2; a++){
                for(int l = 0; l < 3; l++){
                    //Pick P
                    newDP[a][l] += prevDP[a][2];
                    if(a > 0){
                        //Pick A
                        newDP[a][l] += prevDP[a - 1][2];
                        newDP[a][l] %= MOD;
                    }
                    if(l > 0){
                        // Pick L
                        newDP[a][l] += prevDP[a][l - 1];
                        newDP[a][l] %= MOD;
                    }
                }
            }
            prevDP = newDP;
        }
        
        return prevDP[1][2];
    }
}
