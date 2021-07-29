package e_oop;

import java.util.Scanner;

public class CalcTest {
	public static void main(String[] args) {
		//기본 계산기
		boolean running = true;
		
		while(running){
		//5. 사용자로부터 정수를 입력 받아 변수 firstNum에 저장 하여라.
			Scanner sc = new Scanner(System.in);
			System.out.println("첫번째 숫자 입력 : ");
			int firstNum = sc.nextInt();	
			
	    //6. 사용자로부터 부호를 입력 받아 변수 buho에 저장 하여라.
			System.out.println("부호 입력 :");
			String buho = sc.next();	
			
	    //7. 사용자로부터 정수를 입력 받아 변수 secondNum에 저장 하여라.
			System.out.println("두번째 숫자 입력 : ");
			int secondNum = sc.nextInt();
			
	    //8. buho에 저장된 값이 '+'이면 add메서드, '-'이면 subtract메서드
	    //  '*'이면 multiply메서드, '/'이면 divide메서드를 호출하고 결과를 출력하여라.
	    //   단. buho의 저장된 값이 위의 4가지 경우가 아니라면 '연산종료'를 출력하여라.
			Calc num = new Calc();
			
			if("+".equals(buho)){
				int result = num.add(firstNum, secondNum);
				System.out.println(result);
			}else if("-".equals(buho)){
				int result = num.subtract(firstNum, secondNum);
				System.out.println(result);
			}else if("*".equals(buho)){
				long result = num.multiply(firstNum, secondNum);
				System.out.println(result);
			}else if("/".equals(buho)){
				float result = num.divide(firstNum, secondNum);
				System.out.println(result);
			}else{
				running = false;
				System.out.println("연산종료");
			}
//			switch(buho){
//				case "+":
//					int res = num.add(firstNum, secondNum);
//					System.out.println(res);
//					break;
//				case "-":
//					int res2 = num.subtract(firstNum, secondNum);
//					System.out.println(res2);
//					break;
//				case "*":
//					long res3 = num.multiply(firstNum, secondNum);
//					System.out.println(res3);
//					break;
//				case "/":
//					float res4 = num.divide(firstNum, secondNum);
//					System.out.println(res4);
//					break;
//				default:
//					System.out.println("연산종료");
//					running = false;
//					break;
//			}
		}
	}
}
		
		// 누적 계산기 
//		boolean running = true;
//		Scanner sc = new Scanner(System.in);
//		
//		int firstNum = sc.nextInt();
//		while(running){
//			System.out.print(firstNum);
//			
//			String buho = sc.next();	
//			System.out.print(" " + buho + " ");
//				 
//			int secondNum = sc.nextInt();
//			System.out.print(secondNum + " = ");	
//			
//			Calc num = new Calc();
//			float nextNum = firstNum;
//			
//			switch(buho){
//				case "+":
//					nextNum = num.add(nextNum, secondNum);
//					System.out.println((int)nextNum);
//					break;
//				case "-":
//					nextNum = num.subtract(nextNum, secondNum);
//					System.out.println((int)nextNum);
//					break;
//				case "*":
//					nextNum = num.multiply(nextNum, secondNum);
//					System.out.println((long)nextNum);
//					break;
//				case "/":
//					nextNum = num.divide(nextNum, secondNum);
//					System.out.println(nextNum);
//					break;
//				case "c":
//					nextNum = 0;
//					break;
//				default:
//					System.out.println("연산종료");
//					running = false;
//					break;
//			}
//		}		
//	}
//}

class Calc{
		//1. 두 개의 int타입 입력받아 두 인자의 합의 결과를  반환하는 인스턴스메서드 
		//  add를 구현 하여라.
		int add(int a, int b){
			int result = a + b;
			return result;
		}

		//2. 두 개의 int타입 입력받아 앞의 인자에서 뒤의 인자를 뺀 결과를 반환하는 
		//   인스턴스메서드 subtract를 구현 하여라.
		int subtract(int a, int b){
			int result = a - b;
			return result;
		}

	  	//3. 두 개의 int타입 입력받아 두 인자의 곱의 결과를 반환하는 인스턴스메서드
	  	//   multiply를 구현 하여라.
	  	//   단. overflow를 고려하여라.
		long multiply(int a, int b){
			long result = a * b;
			return result;
		}


		//4. 두 개의 int타입 입력받아 앞의 인자를 뒤의 인자로 나누기한 결과를 반환하는
	  	//   인스턴스메서드 divide를 구현 하여라.
	  	//   단. 결과는 소수점 두 번째 자리에서 반올림하여 젓 번째 자리까지 표현 하여라.
		float divide(int a, int b){
			float result = (int)(((float)a/ b)*10+0.5)/10f;
			return result;
		}
	
}

//class Calc{
//	//1. 두 개의 int타입 입력받아 두 인자의 합의 결과를  반환하는 인스턴스메서드 
//	//  add를 구현 하여라.
//	int add(float a, int b){
//		int result = (int) a + b;
//		return result;
//	}
//
//	//2. 두 개의 int타입 입력받아 앞의 인자에서 뒤의 인자를 뺀 결과를 반환하는 
//	//   인스턴스메서드 subtract를 구현 하여라.
//	int subtract(float a, int b){
//		int result = (int)a - b;
//		return result;
//	}
//
//  	//3. 두 개의 int타입 입력받아 두 인자의 곱의 결과를 반환하는 인스턴스메서드
//  	//   multiply를 구현 하여라.
//  	//   단. overflow를 고려하여라.
//	long multiply(float a, int b){
//		long result = (long)a * b;
//		return result;
//	}
//
//
//	//4. 두 개의 int타입 입력받아 앞의 인자를 뒤의 인자로 나누기한 결과를 반환하는
//  	//   인스턴스메서드 divide를 구현 하여라.
//  	//   단. 결과는 소수점 두 번째 자리에서 반올림하여 젓 번째 자리까지 표현 하여라.
//	float divide(float a, int b){
//		float result = (int)((a/ b)*10+0.5)/10f;
//		return result;
//	}
//
//}
