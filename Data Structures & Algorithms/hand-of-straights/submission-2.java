class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;

        Map<Integer, Integer> count = new HashMap<>();
        for (int card : hand) {
            count.put(card, count.getOrDefault(card, 0) + 1);
        }

        Arrays.sort(hand);

        for (int card : hand) {
            if (count.get(card) == 0) continue;

            for (int i = 0; i < groupSize; i++) {
                int nextCard = card + i;
                int currentCount = count.getOrDefault(nextCard, 0);

                if (currentCount == 0) return false;
                count.put(nextCard, currentCount - 1);
            }
        }

        return true;
    }
}