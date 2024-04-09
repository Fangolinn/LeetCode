class Solution {
    public int v1(int[] tickets, int k) {
        // Straightforward solution, simulation

        int timeTaken = 0;

        for (int i = 0; tickets[k] > 0; i = ++i % tickets.length) {
            if (tickets[i] > 0) {
                tickets[i]--;
                timeTaken++;
            }
        }

        return timeTaken;
    }

    public int v2(int[] tickets, int k) {
        // Trying a more sophisticated solution

        int timeTaken = 0;

        for (int i = 0; i <= k; i++) {
            timeTaken += Math.min(tickets[i], tickets[k]);
        }

        for (int i = k + 1; i < tickets.length; i++) {
            timeTaken += Math.min(tickets[i], tickets[k] - 1);
        }

        return timeTaken;
    }
    
    public int timeRequiredToBuy(int[] tickets, int k) {
        return v2(tickets, k);
    }
}
