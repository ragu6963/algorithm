import java.util.*;

class Solution {

    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++) {
            pq.offer(scoville[i]);
        }
        int sum = 0;

        while (pq.size() != 1 && pq.peek() < K ) {
            sum = 0;
            int first = pq.poll();
            int second = pq.poll();
            sum = first + (second * 2);
            pq.offer(sum);
            answer++;
        }
        if (pq.peek() < K){
            answer = -1;
        }
        return answer;
    }
}
