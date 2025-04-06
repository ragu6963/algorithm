import java.util.*;

class Solution {

    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int sumNumber = Arrays.stream(number).sum();

        HashMap<String, Integer> wantMap = new HashMap<>();

        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }

        for (int start = 0; start < discount.length + 1 - sumNumber; start++) {
            int end = start + sumNumber;

            HashMap<String, Integer> discountMap = new HashMap<>();

            for (String w : want) {
                discountMap.put(w, 0);
            }

            for (int i = start; i < end; i++) {
                String p = discount[i];
                discountMap.put(p, discountMap.getOrDefault(p, 0) + 1);
            }
            if (wantMap.equals(discountMap)) {
                answer++;
            }
        }
        return answer;
    }
}
