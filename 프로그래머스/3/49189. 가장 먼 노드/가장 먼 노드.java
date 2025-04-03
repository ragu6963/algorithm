import java.util.*;

class Solution {
	boolean[] visited;
	List<List<Integer>> graph;

	public int solution(int n, int[][] edge) {
		int answer = 0;
		int start = 1;

		visited = new boolean[n + 1];
		graph = new ArrayList<>();

		for (int i = 0; i < n + 1; i++) {
			graph.add(new ArrayList<>());
		}

		for (int[] e : edge) {
			int a = e[0];
			int b = e[1];
			graph.get(a).add(b);
			graph.get(b).add(a);
		}

		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{start, 1});
		visited[start] = true;
		List<int[]> result = new ArrayList<>();

		int MAX_COUNT = 0;

		while (!queue.isEmpty()) {
			int[] node = queue.poll();
			int curr = node[0];
			int count = node[1];
			MAX_COUNT = Math.max(MAX_COUNT, count);

			for (int next : graph.get(curr)) {

				if (!visited[next]) {
					queue.add(new int[]{next, count + 1});
					visited[next] = true;
					result.add(new int[]{next, count + 1});
				}
			}
		}

		for (int[] r : result) {
			if (r[1] == MAX_COUNT) {
				answer++;
			}
		}
		return answer;
	}
}