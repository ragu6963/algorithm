import java.util.*;

class Solution {

    int[] dy = {0, 0, -1, 1};
    int[] dx = {-1, 1, 0, 0};

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for (int i = 0; i < places.length; i++) {
            answer[i] = check(places[i]);
        }

        return answer;
    }

    public int check(String[] room) {

        char[][] grid = new char[5][5];
        List<int[]> people = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                grid[i][j] = room[i].charAt(j);
                if (grid[i][j] == 'P') {
                    people.add(new int[]{i, j});
                }
            }
        }

        for (int[] p : people) {
            if (!isValid(grid, p[0], p[1])) {
                return 0;
            }
        }

        return 1;
    }

    private boolean isValid(char[][] grid, int y, int x) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{y, x, 0});
        boolean[][] visited = new boolean[5][5];
        visited[y][x] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cy = cur[0];
            int cx = cur[1];
            int dist = cur[2];

            if (dist >= 2) {
                continue;
            }
            for (int d = 0; d < 4; d++) {
                int ny = cy + dy[d];
                int nx = cx + dx[d];

                if (ny < 0 || ny > 4 || nx < 0 || nx > 4) {
                    continue;
                }
                if (visited[ny][nx]) {
                    continue;
                }
                if (grid[ny][nx] == 'X') {
                    continue;
                }
                if (grid[ny][nx] == 'P') {
                    return false;
                }
                queue.offer(new int[]{ny, nx, dist + 1});
                visited[ny][nx] = true;
            }

        }
        return true;
    }
}
