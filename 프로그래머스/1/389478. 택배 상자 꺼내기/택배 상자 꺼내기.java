
class Solution {

    public int solution(int n, int w, int num) {
        int answer = 0;
        int maxFloor = n / w + 1;
        int[][] board = new int[maxFloor][w];
        int i = 1;
        int y = 0, x = 0;
        int cx = -1;

        while (i <= n) {
            board[y][x] = i;
            if (i == num) {
                cx = x;
            }
            if (cx == x) {
                answer++;
            }
            if (y % 2 == 0) {
                x++;
            } else {
                x--;
            }
            if (x == w) {
                y++;
                x = w - 1;
            }
            if (x == -1) {
                y++;
                x = 0;
            }
            i++;
        }

        return answer;
    }
}