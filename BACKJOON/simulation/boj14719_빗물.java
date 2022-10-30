package backjoon.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
1. 현재 인덱스 기준으로 왼쪽, 오른쪽에 블록이 존재하는지 확인(왼쪽, 오른쪽에 블록이 존재해야 빗물이 고일수 있음)
2. 현재 인덱스 기준으로 왼쪽에서 가장 높은 블럭, 오른쪽에서 가장 높은 블럭을 구한뒤, 둘다 현재 블럭보다 높은지 확인
3. 현재 인덱스에서 쌓인 빗물 = 왼쪽, 오른쪽 블럭 중에 더 낮은 블록 높이 - 현재 블럭 높이
 */
public class boj14719_빗물 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] srr = br.readLine().split(" ");
        int h = Integer.parseInt(srr[0]);
        int w = Integer.parseInt(srr[1]);

        srr = br.readLine().split(" ");
        int[] heights = new int[w];
        for(int i=0; i<w; i++) {
            heights[i] = Integer.parseInt(srr[i]);
        }

        int result = 0;
        for(int idx=1; idx<w-1; idx++) {  // 첫번쨰, 마지막은 제외(빗물이 고일수 없음)
            int left = 0;
            int right = 0;
            // 현재 위치 기준, 왼쪽에서 가장 높은 블럭 찾기
            for(int i=0; i<idx; i++) {
                left = Math.max(heights[i], left);
            }
            // 현재 위치 기준, 오른쪽에서 가장 높은 블럭 찾기
            for(int i=idx+1; i<w; i++) {
                right = Math.max(heights[i], right);
            }
            // 현재 인덱스에서 쌓인 빗물 = 왼쪽, 오른쪽 블럭 중에 더 낮은 블록 높이 - 현재 블럭 높이
            if(heights[idx]<left && heights[idx]<right)
                result += (Math.min(left, right) - heights[idx]);
        }

        System.out.println(result);
    }
}
