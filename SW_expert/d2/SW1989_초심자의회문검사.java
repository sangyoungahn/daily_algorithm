package day03.sw1989;

import java.util.Scanner;

public class SW1989_초심자의회문검사 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T=sc.nextInt();
		for(int t=1;t<=T;t++) {
			String s = sc.next();
			char[] ch = s.toCharArray();
			int size = ch.length;
			int mid = size/2;
			
			System.out.print("#"+t+" ");
			for(int i=0;i<mid;i++) {
				if(ch[i]==ch[size-1] && ch[i+1]==ch[size-2]) {
					System.out.println(1);
					break;
				} else {
					System.out.println(0);
					break;
					}
			}
		}
	}

}
