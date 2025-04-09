
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
        while (true) {
            String line = br.readLine();
            if (line.equals(".")) {
                break;
            }
            if (is_valid(line)) {
                bw.write("yes\n");
            } else {
                bw.write("no\n");
            }
            bw.flush();
        }
        bw.close();
    }

    public static boolean is_valid(String line) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : line.toCharArray()) {
            if (ch == '[' || ch == '(') {
                stack.push(ch);
            } else if (ch == ']' || ch == ')') {
                if (stack.isEmpty()) {
                    return false;
                } else if (ch == ']' && stack.peek() == '(') {
                    return false;
                } else if (ch == ')' && stack.peek() == '[') {
                    return false;
                } else {
                    stack.pop();
                }
            }

        }
        return stack.isEmpty();
    }
}
