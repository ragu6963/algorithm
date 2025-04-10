
import java.util.*;
import java.io.*;


public class Main {

    static BufferedReader br;

    public static void main(String[] args) throws Exception {
//        br = new BufferedReader(new FileReader("src/input.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        int answer = 0;
        int start = 1;

        Set<Integer> visit = new HashSet<>();
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(start);
        visit.add(start);

        while (!stack.isEmpty()) {
            int node = stack.pop();

            for (int next : graph.get(node)) {
                if (visit.contains(next)) {
                    continue;
                }
                answer++;
                stack.push(next);
                visit.add(next);
            }
        }
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
