import java.util.*;
import java.io.*;


public class Main {

    static BufferedReader br;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int[][] visited = new int[N][M];
        int[] dy = {0, 0, -1, 1};
        int[] dx = {-1, 1, 0, 0};

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int y = node[0];
            int x = node[1];

            for (int d = 0; d < 4; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];

                if (ny < 0 || ny >= N || nx < 0 || nx >= M) {
                    continue;
                }
                if (visited[ny][nx] != 0) {
                    continue;
                }
                if (map[ny][nx] != 1) {
                    continue;
                }

                queue.offer(new int[]{ny, nx});
                visited[ny][nx] = visited[y][x] + 1;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1 && visited[i][j] == 0) {
                    visited[i][j] = -1;
                }
                bw.write(visited[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}