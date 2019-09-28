import java.util.Scanner;
import java.util.Stack;
  
public class SW1223_계산기2 {
  
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
  
        for(int t=0; t<10; t++) {        //테스트케이스
            int num = sc.nextInt();     //문자열의 길이를 입력
            String str = sc.next();     //문자열을 입력
  
            String postOrder = doPostOrder(str);
            int calcValue = doCalc(postOrder);      //후위 표기식을 계산
            System.out.println("#" + (t+1) + " " + calcValue);
        }
    }
     
    //후위 연산자를 계산하는 함수
    static int doCalc(String s) {
        char[] srr = s.toCharArray();
        Stack<Integer> stack = new Stack<Integer>();
        int num1, num2, num3 = 0;
        for(char ch : srr) {
            if(ch >= '0' && ch <= '9') {
                stack.push(new Integer(ch+""));     //ch-'0'
            }else {
                num2 = stack.pop();
                num1 = stack.pop();
                num3 = calc(ch, num1, num2);
                stack.push(num3);
            }
        }
        return num3;
    }
 
    static int calc(char ch, int num1, int num2) {
        int result = 0;
        switch(ch) {
        case '+':
            result = num1 + num2;
            break;
        case '-':
            result = num1 - num2;
            break;
        case '*':
            result = num1 * num2;
            break;
        case '/':
            result = num1 / num2;
            break;
        }
        return result;
    }
     
    //중위표기식을 후위표기식으로 변환
    static String doPostOrder(String s) {
        String result = "";
        char[] srr = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        char temp;
         
        for(char ch : srr) {
            if(ch == '(') {
                stack.push(ch);
            }else if(ch >= '0' && ch <= '9') {
                result += ch;
            }else if(ch == ')') {
                while(!stack.isEmpty() && ((temp = stack.pop()) != '(')) {
                    result += temp;
                }
 
            }else { //연산자라면
                //stack이 비어있지 않고, 현재 우선순위가 stack의 우선순위보다 높으면
                while(!stack.isEmpty() && getPrioirty(ch) <= getPrioirty(stack.peek())) {
                    result += stack.pop();
                }
                stack.push(ch);
            }
        }
        //마지막에 남아있는 연산자까지 pop해줘야 됨
        while(!stack.isEmpty()) {
            result += stack.pop();
        }
         
        return result;
    }
     
    //우선순위 정하는 함수
    static int getPrioirty(char ch) {
        int result = 0;
        switch(ch) {
        case '*':   case '/':
            result = 2;
            break;
        case '+':   case '-':
            result = 1;
            break;
        }
  
        return result;
    }
}