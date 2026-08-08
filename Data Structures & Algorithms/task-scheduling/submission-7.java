

class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (n == 0) return tasks.length;

        int[] alph = new int[26];
        for (char c : tasks) alph[c - 'A']++;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int count : alph) {
            if (count > 0) pq.offer(count);
        }

        int maxFreq = pq.poll();

        int sameMaxCount = 1;
        while (!pq.isEmpty() && pq.peek() == maxFreq) {
            pq.poll();
            sameMaxCount++;
        }

        int frameSize = (maxFreq-1) * (n + 1) + sameMaxCount;

        return Math.max(frameSize, tasks.length);
        }
}