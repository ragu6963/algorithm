
class Solution {

    public int solution(int a, int b, int c) {
        int answer = 0;
        if (a == b && a == c) {
            answer =
                (a + b + c) * ((int) Math.pow(a, 2) + (int) Math.pow(b, 2) + (int) Math.pow(c, 2))
                    * ((int) Math.pow(a, 3) + (int) Math.pow(b, 3) + (int) Math.pow(c, 3));
        } else if (a != b && a != c && b != c) {
            answer = a + b + c;
        } else if (a == b && a != c && b != c) {
            answer =
                (a + b + c) * ((int) Math.pow(a, 2) + (int) Math.pow(b, 2) + (int) Math.pow(c, 2));
        } else if (a == c && a != b && b != c) {
            answer =
                (a + b + c) * ((int) Math.pow(a, 2) + (int) Math.pow(b, 2) + (int) Math.pow(c, 2));
        } else if (b == c && b != a && c != a) {
            answer =
                (a + b + c) * ((int) Math.pow(a, 2) + (int) Math.pow(b, 2) + (int) Math.pow(c, 2));
        }

        return answer;
    }
}