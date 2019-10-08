import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class SW7701_염라대왕의이름정렬 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			TreeSet<String> tree = new TreeSet<>(new Comp());
			for(int n=0; n<N; n++) {
				//입력되는 문자열을 넣을 떄마다 정렬해서 넣음
				tree.add(br.readLine());
			}//full
			
			System.out.println("#"+tc);
			//treeset output
			Iterator<String> iter = tree.iterator();
			while(iter.hasNext()) {
				System.out.println(iter.next());
			}
		}
	}

}

class Comp implements Comparator<String> {
	
	@Override
	public int compare(String o1, String o2) {
		//문자열의 길이가 같지 않으면 길이순 정렬
		if(o1.length() != o2.length()) {
			return o1.length() - o2.length();
		}
		//문자열의 길이가 같으면 문자열 순서 비교해서 정렬
		else {
			return o1.compareTo(o2);	
		}
	}
	

//	@Override
//	public int compare(String o1, String o2) {
//		return o1 > o2 ? -1 : (o1 == o2 ? 0 : 1);
//	}
	
}
