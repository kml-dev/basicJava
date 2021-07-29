package z_exam;

import java.util.Scanner;

public class Exam_04 {
	public static void main(String[] args){
		// [4-2] 1~20까지 2,3의 배수가 아닌 수의 합
//		int result = 0;                        // 결괏값을 받을 변수 선언 및 초기화
//		for (int i = 1; i <= 20; i++){         // 1~20까지의 수를 표현할 변수 i, 20과 같아질 때까지 증가
//			if(i % 2 != 0 && i % 3 != 0){	   // i가 2로 나눈 나머지 값이 0이 아닌경우와 3으로 나눈 나머지 값이 0이 아닌경우 &결합 
//				result += i;				   // 조건을 통과한 i만 변수에 누적
//			}
//		}
//		System.out.println(result);
		
		// [4-3]for문 while문으로 변경, 구구단 출력.
//		int dan = 2;												// 단을 표현할 변수 dan선언 및 초기화 (2단부터 시작)
//		int gob = 0;												// 1~9까지 곱하기 위한 gob선언 및 초기화
//		while(dan <= 9){											// 9단이 넘어가면 반복이 끝나는 while문
//			gob++;													// 1~9까지 곱하기 위해 gob연산후 1씩 증가
//			System.out.println(dan + "*" + gob + "=" + dan*gob);	// 단 * 곱 = 결과를 출력
//			if(gob==9){												// 만약 gob이 9가 되면 실행될 조건문
//				gob = 0;											// gob이 9일때 다시 0으로 초기화
//				dan++;												// 9까지 곱하고 dan이 1증가
//			}	
//		}															// dan이 9가 되어 while문 종료 
		
		// [4-4] 두 개의 주사위를 던졌을 때 , 눈의 합이 6이 되는 모든 경우의 수 출력.
//		for(int i = 1; i <= 6; i++){ 								// 주사위1의 눈을 표현하기 위한 변수 i 선언, 눈은 6까지
//			for(int j = 1; j <= 6; j++){							// 주사위2의 눈을  표현하기 위한 변수 j 선언, 눈은 6까지
//				if(i+j==6){											// 주사위1+주사위2 눈의 합이 6일 경우 if문 실행
//					System.out.println("주사위 1 : "+ i + " " + "주사위 2 : " + j ); // 경우의 수 출력
//				}
//			}
//		}
		
		// [4-5] 방정식 2x + 4y = 10의 모든 해를 구하시오. 0 <= x <= 10, 0 <= y <= 10.
//		for(int x = 0; x <= 10; x++){								// x는 0~10까지의 수를 표현, x가 10이 될 때까지 반복
//			for(int y = 0; y <= 10; y++){							// y는 0~10까지의 수를 표현 , y가 10이 될 때까지 반복
//				if(2*x+4*y==10){									// 2*x + 4*y == 10인 경우 if문 실행
//					System.out.print("x="+x+" ");					// x가 조건에 맞는 경우 출력
//					System.out.println("y="+y);						// y가 조건에 맞는 경우 출력
//				}
//			}
//		}
		
		// [4-6] 사용자로부터 두개의 정수(시작,끝)를 입력받아 시작(포함)에서 끝(포함)까지의 곱을 출력하는 프로그램.
//		Scanner sc = new Scanner(System.in);						//수를 입력 받기위한 클래스 Scanner 호출 
//		
//		System.out.println("첫번째 숫자 입력 : ");						// 첫번째 숫자 입력 받음
//		int num1 = sc.nextInt();									// ..
//		System.out.println("두번째 숫자 입력 : ");						// 두번째 숫자 입력 받음
//		int num2 = sc.nextInt();									// .. 
//		long result = 1L;											// 두 정수의 범위를 모르기 때문에 정수형 중 가장 큰 long 선언
//		while(num1 <= num2){										// 첫번째 숫자가 두번째 숫자보다 작거나 같을 때까지 반복
//			result *= num1++;										// 첫번째 숫자가 1씩 증가하면서 곱셈을 수행하면서 result에 누적										
//		}
//		System.out.println(result);									// 결괏값 출력
		
		// [4-7] 1 + (1+2) + (1+2+3) ... (1+2+3...+10)의 결과
//		int result1 = 0;
//	    int result2 = 0;
//	    for(int i = 1; i <= 10; i++ ){
//	       result1 += i;
//	       int sum = 0;
//	       if(result1 != 1){
//	          System.out.print("(");
//	       }
//	       for(int j = 1; sum < result1; j++){
//	          sum += j;
//	          System.out.print(j);
//	          if(sum != result1){
//	             System.out.print("+");
//	          }
//	       }
//	       switch(i){
//	          case 1:
//	             System.out.print("+");
//	             break;
//	          case 10:
//	             System.out.print(")");
//	             break;
//	          default:
//	             System.out.print(")" + "+");
//	       }
//	       result2 += result1;
//	    }   
//	       System.out.print(" = "+result2);
		
		//[4-8] 1 + (-2) + 3 + (-4).... 몇까지 더해야 합이 100?
//	    int result = 0;
//	    int i = 0;
//	      
//	    while(true){
//	    	i++;
//	    	if(i % 2 != 0){
//	          result += i;
//	       }else{
//	          result += i * -1;
//	       }
//	    	if(result == 100){
//	    		break;
//	    	}
//	    }
//	    System.out.println(i);								// 반복 횟수 출력
		
		// [4-9] 사용자로 부터 입력 받은 값의 각 자리 수 합
//		Scanner sc = new Scanner(System.in);						// 스캐너 호출
//		System.out.println("숫자를 입력하세요: ");
//		int input = sc.nextInt();									// 숫자를 입력 받기 위한 input 
//		int result = 0;												// 결과를 누적하기 위한 result 
//		
//		while(input != 0){											// input이 0이 아닌 동안만 수행되는 while문
//			result += input%10;										// 10으로 나눈 나머지 값을 result에 누적
//			input /= 10;											// input을 10으로 나눈값을 다시 input에 저장(int형이 몫만 저장 됨) 
//		}
//		System.out.println(result);									//결과 출력
		
//		// [4-10] 피보나치 수열은 앞의 두 수를 더해서 다음수를 만들어감. 1,1로 시작하는 피보나치수열의 10번째 수.
//		int num1 = 1;												// 첫번째 수를 표현할 변수 num1
//		int num2 = 1;												// 두번째 수를 표현할 변수 num2
//		
//		for(int i = 1; i < 11; i++){								// 10번째 수이기 때문에 10번 반복하기 위한 for문
//			int nextNum = 0;										// 다음 숫자를 담기위한 변수 nextNum
//			nextNum += num1+num2;									// 첫번째수와 두번째수를 더해 다음 숫자를 구함
//			num1 = num2;											// 두번째 수가 다음에 올 첫째수 이기 때문에 num1에 num2를 넣음 
//			num2 = nextNum;											// 다음에 올 둘째수가 nextNum이기 때문에 num2에 다시 저장
//		}	
//		System.out.println(num2);									// 반복이 끝난 후 마지막 숫자가 10번째 수
		
		//[4-11] 문자열이 숫자인지 판별하는 프로그램.
//		String value = "12o34";
//		char ch = ' ';
//		boolean isNumber = true;
//		for(int i = 0; i < value.length(); i++){
//			if('0' <= value.charAt(i) && value.charAt(i) <= '9'){
//				isNumber = true;
//			}else{
//				isNumber = false;
//			}
//		}
//		if(isNumber){
//			System.out.println("숫자입니다.");
//		}else{
//			System.out.println("숫자가 아닙니다.");
//		}
		
	
		//[추가 문제] 사용자가 입력한 수가 펠린드롬인지 판단하라.
		// 문자열 받아서 푸는 방법
//	    Scanner sc = new Scanner(System.in);
//	    System.out.println("숫자를 입력하세요 : ");
//	    String input = sc.next();
//	    boolean result = true;
//	      
//	    for(int i = 0; i < input.length(); i++){
//	       if(input.charAt(i)==input.charAt(input.length()-(i+1))){
//	          result = true;
//	       }else{
//	          result = false;
//	       }
//	    }
//	    if(result == true){
//	       System.out.println("펠린드롬입니다.");
//	    }else{
//	       System.out.println("펠린드롬이 아닙니다.");
//	    }
		
		// 정수 받아서 푸는 방법
//		Scanner sc = new Scanner(System.in);
//	    System.out.println("숫자를 입력하세요 : ");
//		int input = sc.nextInt();
//		int result = 0;
//		int temp1 = (input+"").length();
//		int temp2 = input;
//		
//		for(int i = 0; i < temp1; i++){
//			result += input % 10;
//			result *= 10;
//			input /= 10;
//		}
//		
//		if(result==temp2*10){
//			System.out.println("펠린드롬입니다");
//		}else{
//			System.out.println("펠린드롬이 아님");
//		}
		
		
	
	}	
}
