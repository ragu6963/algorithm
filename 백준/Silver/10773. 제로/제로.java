import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < K; i++) {
			int n = Integer.parseInt(br.readLine());
			if (n != 0) {
				stack.push(n);
			} else if (n == 0 && !stack.isEmpty()) {
				stack.pop();
			}
		}
		int answer = 0;
		while (!stack.isEmpty()) {
			answer += stack.pop();
		}
		System.out.println(answer);
	}
}
