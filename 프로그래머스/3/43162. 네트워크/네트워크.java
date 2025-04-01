import java.util.*;

class Solution {

    int[] visited;

    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new int[n];

        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                answer++;
                bfs(i, computers);
            }
        }

        return answer;
    }

    public void bfs(int i, int[][] computers) {
        Queue<Integer> queue = new LinkedList<>();
        visited[i] = 1;
        queue.add(i);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next = 0; next < computers[cur].length; next++) {
                if (cur == next) {
                    continue;
                }
                if (visited[next] == 0 && computers[cur][next] == 1) {
                    visited[next] = 1;
                    queue.add(next);
                }
            }
        }
    }
}