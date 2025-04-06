import java.util.*;

class Solution {

    public int solution(int[] citations) {
        int answer = 0;
        citations = Arrays.stream(citations)
            .boxed()
            .sorted(Collections.reverseOrder())
            .mapToInt(Integer::intValue)
            .toArray();

        int h = citations[0];
        while (true) {
            int count = 0;

            for (int citation : citations) {
                if (citation >= h) {
                    count++;
                } else {
                    break;
                }

            }

            if (count >= h) {
                answer = h;
                break;
            }
            h--;
        }

        return answer;
    }
}