
class Solution {

    public int[] solution(int n) {
        // 삼각형을 저장할 2차원 리스트 생성
        int[][] triangle = new int[n][n];

        // 방향 설정 (아래 -> 오른쪽 -> 대각선 위)
        int[] dy = {1, 0, -1};
        int[] dx = {0, 1, -1};

        int x = 0, y = 0, num = 1; // 초기 위치 및 숫자
        int maxNum = n * (n + 1) / 2; // 마지막 숫자
        int dir = 0;

        while (num <= maxNum) {
            triangle[y][x] = num++; // 현재 위치에 숫자 채우기

            // 다음 위치 계산
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            // 범위를 벗어나거나 이미 값이 채워져 있다면 방향 전환
            if (nx >= n || ny >= n || nx < 0 || ny < 0 || triangle[ny][nx] != 0) {
                dir = (dir + 1) % 3;
                nx = x + dx[dir];
                ny = y + dy[dir];
            }

            // 이동
            x = nx;
            y = ny;
        }

        // 결과를 1차원 배열로 변환
        int[] answer = new int[maxNum];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[index++] = triangle[i][j];
            }
        }

        return answer;
    }
}