import java.util.Arrays;

class Solution {
    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);

        int change = money - (prices[0] + prices[1]);
        return change >= 0 ? change : money;
    }
}
