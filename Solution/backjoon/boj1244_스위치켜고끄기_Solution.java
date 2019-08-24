import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj1244_스위치켜고끄기_보충 {
	static int[] datas;		//중요!!!
	static int size;
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		size = Integer.parseInt(reader.readLine());
		datas = new int[size+1];	//0을 버리기위해 하나 배열크기 +1
		String[] srr = reader.readLine().split(" ");
		for(int i=0;i<srr.length;i++) {
			datas[i+1] = Integer.parseInt(srr[i]);
		}
		int cnt=Integer.parseInt(reader.readLine());
		for(int i=0;i<cnt;i++) {
			srr = reader.readLine().split(" ");
			if(srr[0].equals("1")) {
				//남자
				doMan(Integer.parseInt(srr[1]));	//두번째 숫자(전구 번호)를 넘겨줌
			}else if(srr[0].equals("2")) {
				//여자
				doWoman(Integer.parseInt(srr[1]));
			}
		}
		//		출력
		for(int i=1;i<datas.length;i++) {
			System.out.print(datas[i] + " ");
			if(i%20==0) {
				System.out.println();
			}
		}
	}

	static void doMan(int num) {
		for(int i=num;i<datas.length;i+=num) {		//i+=num 중요!!(배열 인덱스를 배수로 만들기)
			if(datas[i] == 0) {
				datas[i] = 1;
			}else {
				datas[i] = 0;
			}
		}
	}
	
	static void doWoman(int num) {
		int start = num-1;	//중요
		int end = num+1;	//중요
		while(true) {
			//배열 구간 넘어가면 종료
			if(start < 1 || end > size) {
				break;
				}
			//종료 조건
			if(datas[start] != datas[end]) {
				break;
				}
			//같지 않으면 다시 증가시켜주고 처리해줌
			start--;
			end++;
			}
		start++;
		end--;
		for(int i=start;i<=end;i++) {	//i<=end????
			if(datas[i] == 0) {
				datas[i] = 1;
			}else {
			datas[i] = 0;
			}
		}
	}
}

