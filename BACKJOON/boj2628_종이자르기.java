package day06.boj2628;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class boj2628_종이자르기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//전체 가로, 세로 크기 입력
		String[] srr=br.readLine().split(" ");
		int garoTotal=Integer.parseInt(srr[0]);		//10
		int seroTotal=Integer.parseInt(srr[1]);		//8

		//점선의 개수
		int num=Integer.parseInt(br.readLine());

		//각각의 가로, 세로 크기 입력
		int[] dir = new int[num];	//가로 or 세로
		int[] size = new int[num];	//가로 크기 or 세로크기
		for(int i=0;i<num;i++) {
			String[] srr2=br.readLine().split(" ");
			dir[i]=Integer.parseInt(srr2[0]);
			size[i]=Integer.parseInt(srr2[1]);
		}

		//가로인지 세로인지 판별해서 가로, 세로 인덱스 배열에 저장(앞쪽부터 들어가는 거 주의!!)
		ArrayList<Integer> sero=new ArrayList<>();
		ArrayList<Integer> garo=new ArrayList<>();
		for(int i=0;i<num;i++) {
			if(dir[i]==0) {		//0 -> 세로(3,2)
				sero.add(size[i]);
			} else {			//1 -> 가로(4)
				garo.add(size[i]);
			}
		}
		
		//세로, 가로 ArrayList 내림차순 정리
		Collections.sort(sero);
		Collections.reverse(sero);
		
		Collections.sort(garo);
		Collections.reverse(garo);

		//세로 출력테스트
		System.out.print("세로인덱스들 : ");
		for(int i=0;i<sero.size();i++) {
			System.out.print(sero.get(i)+", ");
		}
		System.out.println();

		//가로 출력테스트
		System.out.print("가로인덱스들 : ");
		for(int i=0;i<garo.size();i++) {
			System.out.print(garo.get(i)+", ");
		}
		System.out.println();

		//세로 길이 저장
		int seroSizeNum = sero.size()+1;	//3=2+1
		int[] seroSize = new int[seroSizeNum];
		int seroMax=1;
		
		if(sero.size() != 0) {
			seroSize[0]=sero.get(sero.size()-1)-0;	//첫번째 세로크기 저장
			seroSize[seroSizeNum-1]=seroTotal-sero.get(0);	//마지막 세로크기 저장
			
			//첫번째,마지막 세로크기 중에 큰 걸 max에 저장해놓음
			if(seroSize[0]>seroSize[seroSizeNum-1])		seroMax=seroSize[0];
			else	seroMax=seroSize[seroSizeNum-1];
			
			//seroSize배열에 넣으면서 가장 큰 값을 max에 넣어줌
			for(int i=1;i<seroSizeNum-1;i++) {
				seroSize[i]=sero.get(i-1)-sero.get(i);
				if(seroSize[i]>seroMax)		seroMax=seroSize[i];
			}
		}else {
			seroMax=seroTotal;
		}
		
		
		//세로사이즈 출력테스트
		System.out.println("전체 세로크기 : "+seroTotal);
		System.out.print("seroSize배열 값 : ");
		for(int i=0;i<seroSize.length;i++) {
			System.out.print(seroSize[i]+", ");
		}
		System.out.println();
		
		
		//가로 길이 저장
		int garoSizeNum = garo.size()+1;	//3=2+1
		int[] garoSize = new int[garoSizeNum];
		int garoMax=1;
		
		if(garo.size() != 0) {
			garoSize[0]=garo.get(garo.size()-1)-0;	//첫번째 가로크기 저장
			garoSize[garoSizeNum-1]=garoTotal-garo.get(0);	//마지막 가로크기 저장
			
			//첫번째,마지막 가로크기 중에 큰 걸 max에 저장해놓음
			if(garoSize[0]>garoSize[garoSizeNum-1])		garoMax=garoSize[0];
			else	garoMax=garoSize[garoSizeNum-1];
			
			//garoSize배열에 넣으면서 가장 큰 값을 max에 넣어줌
			for(int i=1;i<garoSizeNum-1;i++) {
				garoSize[i]=garo.get(i-1)-garo.get(i);
				if(garoSize[i]>garoMax)		garoMax=garoSize[i];
			}
		}else {
			garoMax=garoTotal;
		}

		//가로사이즈 출력테스트
		System.out.println("전체 가로크기 : "+garoTotal);
		System.out.print("garoSize배열 값 : ");
		for(int i=0;i<garoSize.length;i++) {
			System.out.print(garoSize[i]+", ");
		}
		System.out.println();

		int maxArea=garoMax*seroMax;
		System.out.println("seroMax : "+seroMax);
		System.out.println("garoMax : "+garoMax);
		System.out.println(maxArea);
	}

}
