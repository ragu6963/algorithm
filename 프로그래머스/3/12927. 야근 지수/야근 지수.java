import java.util.*;

class Solution {

    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int w : works) {
            priorityQueue.add(-w);
        }

        while (true) {
            if (priorityQueue.isEmpty()) {
                break;
            }
            if (n == 0) {
                break;
            }

            int top = priorityQueue.poll();
            if (top + 1 != 0) {
                priorityQueue.add(top + 1);

            }
            n--;
        }
        while (!priorityQueue.isEmpty()) {
            answer += Math.pow((double) priorityQueue.poll(), 2);
        }

        return answer;
    }
}
