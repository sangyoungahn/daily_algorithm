import java.util.Calendar;
import java.util.Date;

public class day07_2 {

	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date()); // date 객체의 날짜와 시간 정보를 현재 객체로 생성

		int year = calendar.get(Calendar.YEAR); // 현재 년도를 가져옴
		int month = calendar.get(Calendar.MONTH); // 현재 월을 가져옴
		int[] dayCnt = {
				31, ((year % 4 == 0) && (year % 100 != 0) || (year % 400) == 0) ? 29 : 28,
				31, 30,
				31, 30,
				31, 30,
				31, 30,
				31, 30 };
		
		System.out.println("현재 달 >> " + (month+1));
		System.out.println("현재 달의 날수 >> " + dayCnt[month] + " days");
	}

}
