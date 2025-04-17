import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.offer(i);          // 카드 1 ~ N 삽입
        }

        while (q.size() > 1) {
            q.poll();            // ① 맨 앞 카드 버리기
            q.offer(q.poll());   // ② 다음 카드를 맨 뒤로 이동
        }

        System.out.println(q.peek()); // 마지막 카드 출력
    }
}