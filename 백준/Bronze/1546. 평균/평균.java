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
        int N = Integer.parseInt(br.readLine());
        double[] scores = new double[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int i = 0;
        while (st.hasMoreTokens()) {
            double num = Double.parseDouble(st.nextToken());
            scores[i] = num;
            i++;
        }
        double M = Arrays.stream(scores).max().getAsDouble();

        for (int j = 0; j < scores.length; j++) {
            scores[j] = scores[j] / M * 100;
        }
        double sum = Arrays.stream(scores).sum();

        bw.write(String.valueOf(sum / scores.length));
        bw.flush();
        bw.close();
    }
}