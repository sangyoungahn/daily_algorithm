package python_for_coding_test.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class implimentation_상하좌우 {
    static int[] dirX = {0,0,-1,1};     // L, R, U, D 순서
    static int[] dirY = {-1,1,0,0};
    static char[] moveTypes = {'L','R','U','D'};
    static int x = 1, y = 1;
    static int tempX = 1, tempY = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] dirs = br.readLine().split(" ");

        for(int i=0; i<dirs.length; i++) {
            char dir = dirs[i].charAt(0);
//            int nx = -1, ny = -1;
            for(int j=0; j<4; j++) {
                if(dir == moveTypes[j]) {
                    tempX += dirX[j];
                    tempY += dirY[j];
                }
            }
            // 범위 넘어가면 무시 - 범위넘어가면 아래에 x, y 값을 최신화 안시켜줌
            if(tempX<1 || N<tempX || tempY<1 || N<tempY) {
                continue;
            }
            // 다음 위치로 이동해야하므로 값을 바꿔줌
            x = tempX;
            y = tempY;
        }

        System.out.println(x + " " + y);
    }
}
