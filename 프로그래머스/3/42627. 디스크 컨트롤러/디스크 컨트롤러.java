
import java.util.*;

class Solution {

    public int solution(int[][] jobs) {
        Arrays.sort(jobs, Comparator.comparingInt(o -> o[0]));

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            Comparator.comparingInt(o -> o[1])); // 소요 시간 기준

        int sum = 0;
        int t = 0;
        int i = 0;
        int count = 0;

        while (count < jobs.length) {
            while (i < jobs.length && jobs[i][0] <= t) {
                pq.offer(jobs[i]);
                i++;
            }

            if (!pq.isEmpty()) {
                int[] job = pq.poll();
                int requestTime = job[0];
                int taskTime = job[1];

                t += taskTime;
                sum += t - requestTime;
                count++;
            } else {
                t = jobs[i][0];
            }
        }

        return sum / jobs.length;
    }
}
