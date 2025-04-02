import java.util.*;

class Solution {
	public int solution(int[][] maps) {
		int answer = -1;
		int n = maps.length;
		int m = maps[0].length;
		int[] dy = new int[]{0, 0, 1, -1};
		int[] dx = new int[]{-1, 1, 0, 0};

		Queue<int[]> queue = new LinkedList<>();
		boolean[][] visited = new boolean[n][m];

		visited[0][0] = true;
		queue.add(new int[]{0, 0, 1});

		while (!queue.isEmpty()) {
			int[] node = queue.poll();
			int cy = node[0];
			int cx = node[1];
			int count = node[2];

			if (cy == n - 1 && cx == m - 1) {
				answer = count;
				break;
			}

			for (int d = 0; d < 4; d++) {
				int ny = cy + dy[d];
				int nx = cx + dx[d];

				if (ny < 0 || ny >= n || nx < 0 || nx >= m) {
					continue;
				}

				if (visited[ny][nx]) {
					continue;
				}
				if (maps[ny][nx] == 1) {
					queue.add(new int[]{ny, nx, count + 1});
					visited[ny][nx] = true;
				}
			}

		}

		return answer;
	}
}
