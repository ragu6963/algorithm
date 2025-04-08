
import java.util.*;

class Solution {

    public int solution(int[][] routes) {
        // 진출 지점 기준 오름차순 정렬
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));

        int cameraCount = 0;
        int lastCameraPosition = -30001;

        for (int[] route : routes) {
            // 현재 차량이 마지막 카메라 위치를 지나지 않았다면 새 카메라 설치
            if (route[0] > lastCameraPosition) {
                cameraCount++;
                lastCameraPosition = route[1];
            }
        }

        return cameraCount;
    }
}