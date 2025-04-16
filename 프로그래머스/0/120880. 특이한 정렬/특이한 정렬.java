import java.util.*;
class Solution {
    public int[] solution(int[] numlist, int n) {
        int[] answer = new int[numlist.length];
        List<Integer> list = new ArrayList<>();
        for(int number: numlist) {
            list.add(number);
        }
        list.sort((a,b) -> {
            if (Math.abs(n-a) != Math.abs(n-b)) {
                return Math.abs(n-a) - Math.abs(n-b);
            } else {
                return b - a;
            }
            
        });
        
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}