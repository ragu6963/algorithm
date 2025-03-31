class Solution {

    public int solution(int[][] board) {
        int answer = 0;
        int n = board.length;
        int m = board[0].length;
        int[] dy = new int[]{0, 0, -1, 1, 1, 1, -1, -1};
        int[] dx = new int[]{1, -1, 0, 0, -1, 1, -1, 1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1) {
                    for (int k = 0; k < 8; k++) {
                        int ny = i + dy[k];
                        int nx = j + dx[k];
                        if (ny > -1 && ny < n && nx > -1 && nx < m && board[ny][nx] == 0) {
                            board[ny][nx] = -1;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0) {
                    answer++;
                }
            }
        }
        return answer;
    }
}
