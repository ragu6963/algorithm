import java.util.Arrays;

class Solution {
    public int[] solution(int[] numlist, int n) {
        // int[]를 Integer[]로 변환
        Integer[] integerList = new Integer[numlist.length];
        for (int i = 0; i < numlist.length; i++) {
            integerList[i] = numlist[i]; // int 값을 Integer로 변환
        }

        // 정렬 기준을 위한 비교 함수 구현
        Arrays.sort(integerList, (a, b) -> {
            int diffA = Math.abs(a - n);
            int diffB = Math.abs(b - n);
            if (diffA == diffB) {
                return b - a; // 차이가 같으면 더 큰 수 우선
            } else {
                return diffA - diffB; // 차이 기준 오름차순
            }
        });

        // Integer[]를 다시 int[]로 변환
        int[] result = new int[integerList.length];
        for (int i = 0; i < integerList.length; i++) {
            result[i] = integerList[i]; // Integer 값을 int로 변환
        }

        return result;
    }
}
