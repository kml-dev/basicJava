package b_operation;

import java.util.Scanner;

public class Operation_04 {
	public static void main(String[] args){
		/*
		 1. 삼항연산자
		   - 세 개의 피 연산자를 필요로 하기 때문에 삼항 연산자라고 하다.
		   - 삼항연산자의 조건식에는 여산결과가 true 또는 false인 식이 사용되어야 한다.
		   - 기본 구조
		     (조건식)? true:false
		 */
//		int x = -10;
//		int absx = x > 0 ? x:-x; //절댓값 구하는 코드
//		
//		// 1. 변수  k를 선언하고 50의 값으로 초기화하여라.
//		int k = 50;
//		// 2. 변수 k의 값이 0보다 크면 "양수", 0보다 작으면 "음수",0이면 "0"의 결과를 re에 저장해주세요.
//		String re = k > 0 ? "양수": k < 0? "음수" : "0";
//		System.out.println(re);
//		
//		/*
//		 2. 대입연산자(=, op=)
//		   - 변수에 값 또는 수식의 연산결과를 변수에 저장하는데 사용한다.
//		   - 연산 우선순위가 가장 낮다.
//		 */
//		int i = 0;
//		i = i + 3;
//		i += 3;
//		
//		char c = 'A';
//		c += 3;   // 자신의 타입을 유지함
//		System.out.println(c);
//		
//		// 1. 반올림
//		double d = 3.141592;
//		//  (1) d*1000 => 3141.592
//		//	(2) +0.5 => 3142.092
//		//	(3) (int) => 3142
//		//  (4) /1000f => 3.142
//		
//		float result = (int)(d*1000 + 0.5)/1000f;
//		System.out.println(result);
//		
//		// 2. Math.random()     // default는 0 <= Math.random() < 1 로 되어있음 
//		// ex) 47(포함) ~ 314(포함)
//		// 47 - 315 => *268, +47
//		// (int)(Math.random()*(num2+1-num1)+num1
//		// ex) 47(초과) ~ 314(미만)
//		// (int)(Math.random()*(num2-num1)+num1+1
//		// ex) 47(포함) ~ 314(미만)
//		// (int)(Math.random()*(num2-num1)+num1
//		// ex) 47(초과) ~ 314(포함)
//		// (int)(Math.random()*(num2+1-num1)+num1+1
//		
//		
//		// 주사위
//		// 1~6
//		int dice = (int)(Math.random()*6+1);
//		System.out.println(dice);
//		
//		//1~25사이의 임의의 정수값
//		int num = (int)(Math.random()*25+1);
//		System.out.println(num);
//		
//		// 1. 변수 x를 선언하고 0이상 100미만 사이의 임의의 정수 값으로 초기화 하여라.
//		int x = (int)(Math.random()*100);
//		// 2. x에 저장된 값을 출력 하여라.
//		System.out.println(x);
//		// 3. 변수 x2를 선언하고 43초과 375미만 사이의 임의의 정수 값으로 초기화 하여라.
//		// 44 - 375 => 331, 44
//		int x2 = (int)(Math.random()*331+44);
//		// 4. x2에 저장된 값을 출력 하여라.
//		System.out.println(x2);
		
		// 3. 사용자로부터 입력받기
		Scanner sc = new Scanner(System.in);  // 환경조성
//		System.out.println("첫번째 문자 입력: ");
//		String input1 = sc.next();            // 받아오기
//		System.out.println("두번째 문자 입력: ");
//		String input2 = sc.next();
//		System.out.println(input1+input2);    // 출력
		
		System.out.println("첫번째 숫자 입력: ");
		int num1 = sc.nextInt();
		System.out.println("두번째 숫자 입력: ");
		int num2 = sc.nextInt();
		System.out.println("두 수의 합계는 "+(num1+num2));
	}
}
