
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int V = Integer.parseInt(br.readLine()); // 정점(Vertex) 수
		StringTokenizer st = new StringTokenizer(br.readLine());

		int start = Integer.parseInt(st.nextToken()); // 출발 정점
		int end = Integer.parseInt(st.nextToken()); // 도착 정점

		int E = Integer.parseInt(br.readLine()); // 간선(Edge) 수

		// 인접 리스트
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

		for (int i = 0; i < V + 1; i++) {
			adj.add(new ArrayList<>());
		}

		// 간선 입력 (무방향 그래프)
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			adj.get(u).add(v);
			adj.get(v).add(u);
		}

		// 방문 배열 생성
		boolean[] visited = new boolean[V + 1];
		visited[start] = true;

		// 큐 생성
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[]{start, 0});

		int answer = -1;
		while (!q.isEmpty()) {
			int[] node = q.poll();
			int cur = node[0];
			int d = node[1];

			if (cur == end) {
				answer = d;
				break;
			}

			for (int next : adj.get(cur)) {
				if (!visited[next]) {
					visited[next] = true;
					q.offer(new int[]{next, d + 1});
				}
			}
		}
		System.out.println(answer);

	}
}