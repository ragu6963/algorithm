import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (a, b) -> {
            if(b.charAt(n) == a.charAt(n)) {
                return a.compareTo(b);
            } else{
                return a.charAt(n) -  b.charAt(n);
            }
            
        });
        
        return strings;
    }
}