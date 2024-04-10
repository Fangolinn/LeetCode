import java.util.Arrays;
import java.util.ArrayDeque;

class Solution {
    public int[] v1(int[] deck) {
        // Simplistic and slow solution
        Arrays.sort(deck);
        ArrayDeque<Integer> result = new ArrayDeque<>();

        for (int i = deck.length - 1; i >= 0; i--) {
            Integer lastElement = result.pollLast();
            if (lastElement != null) {
                result.offerFirst(lastElement);
            }

            result.offerFirst(deck[i]);
        }

        deck = result.stream().mapToInt(i -> i).toArray();

        return deck;
    }

    public int[] v2(int[] deck) {
        ArrayDeque<Integer> indexQueue = new ArrayDeque<>();

        int[] result = new int[deck.length];
        Arrays.sort(deck);

        for (int i = 0; i < result.length; i++) {
            indexQueue.offer(i);
        }

        for (int card : deck) {
            result[indexQueue.poll()] = card;

            if (indexQueue.peek() != null){
                indexQueue.offer(indexQueue.poll());
            }
        }

        return result;
    }

    public int[] deckRevealedIncreasing(int[] deck) {
        return v2(deck);
    }
}
