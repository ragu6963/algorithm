
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        Queue<long[]> queue = new ArrayDeque<>();
        queue.offer(new long[]{A, 1});

        Set<Long> visited = new HashSet<>();
        visited.add(A);

        long answer = -1;

        while (!queue.isEmpty()) {
            long[] node = queue.poll();
            long value = node[0];
            long count = node[1];

            if (value > B) {
                continue;
            }
            if (value == B) {
                answer = count;
                break;
            }

            long nextValue = value * 2L;

            if (nextValue <= Math.pow(10, 9) + 1 && !visited.contains(nextValue)) {
                queue.offer(new long[]{nextValue, count + 1});
                visited.add(nextValue);
            }

            nextValue = Long.parseLong(value + "1");
            if (nextValue <= Math.pow(10, 9) && !visited.contains(nextValue)) {
                queue.offer(new long[]{nextValue, count + 1});
                visited.add(nextValue);
            }
        }
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
