
import java.util.*;

class Solution {

    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> list = new ArrayList<>();

        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < progresses.length; i++) {
            int remain = 100 - progresses[i];
            int days = (int) Math.ceil((double) remain / speeds[i]);
            queue.offer(days);
        }

        while (!queue.isEmpty()) {
            int top = queue.poll();
            int count = 1;

            while (!queue.isEmpty() && top >= queue.peek()) {
                queue.poll();
                count++;
            }
            list.add(count);
        }

        int[] answer = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}