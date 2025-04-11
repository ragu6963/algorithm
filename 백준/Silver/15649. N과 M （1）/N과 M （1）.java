import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br;
    static BufferedWriter bw;
    static int N;
    static int M;
    static int[] result;
    static HashSet<Integer> visited;

    public static void main(String[] args) throws Exception {
//        br = new BufferedReader(new FileReader("input.txt"));
        br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        result = new int[M];
        visited = new HashSet<>();
        dfs(0);

    }

    public static void dfs(int depth) {
        if (depth == M) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < M; i++) {
                sb.append(result[i]);
                sb.append(" ");
            }
            System.out.println(sb);
            return;
        }

        for (int i = 1; i < N + 1; i++) {
            if (!visited.contains(i)) {
                result[depth] = i;
                visited.add(i);
                dfs(depth + 1);
                visited.remove(i);
            }
        }
    }
}
