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
        int n = Integer.parseInt(br.readLine());
        boolean flag = false;
        for (int i = 1; i < n; i++) {
            char[] digits = String.valueOf(i).toCharArray();
            int sum = i;

            for (char ch : digits) {
                sum += ch - '0';
            }
            if (sum == n) {
                System.out.println(i);
                flag = true;
                break;
            }

        }
        if (!flag) {
            System.out.println(0);
        }
    }
}