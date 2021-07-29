package c_sentence;

import java.util.Scanner;

public class Sentence_02 {
	public static void main(String[] args) {
		/*
		 1. 반복문(for, while, do-while)
		   - 어떤 작업을 반복적으로 수행되도록 할 때 사용된다.
		   - 반복문을 주어진 조건을 만족하는 동안 주어진 문장을 반복적으로 수행함으로 조건식을 포함한다
		   - for문은 반복 횟수를 알 때 , while문은 반복 횟수를 모를 때 사용한다. 
		   
		 2. for문
		   - 기본구조
		   	 for(초기화; 조건식; 증감식){
		   	 	 	조건식이 만족할 때 수행될 문장
		   	 }
		   	 
		   	 초기화 -> (조건식 -> 수행 -> 증감식)
		 */
		// 시작 : 0, 끝 : 10, 증가량1,
		// 수행문장 : System.out.println(??);
		
//		for(int cnt = 0; cnt < 11; cnt++){
//			System.out.println(cnt);
//			
//		}
		// "Hello Java"를 3번 출력해주세요
//		for(int i = 0; i < 3; i++){
//			System.out.println("Hello Java");
//		}
		
		// 1. 5~17까지의 합을 구하여라.
//		int result = 0;
//		for(int i =5; i < 18; i++){
//			result += i;
//		}
//		System.out.println(result);
		//1. 0이상 5이하에서 정수를 결과와 같이 출력 하여라.
//		for(int i = 0; i < 6; i++){
//			System.out.print(i+"\t");
//		}
	    
		//2. 0이상 5이하에서 정수를 결과와 같이 출력 하여라.
//		for(int i = 5; 0 <= i; i--){
//			System.out.print(i+"\t");
//		}

	    //3. 2이상 10이하에서 정수를 합계를 구하여라.
//		int sum = 0;
//		for(int i = 2; i < 11; i++){
//			sum += i;
//		}
//		System.out.println(sum);

	    //4. 5이상 15미만에서 정수의 곱을 구하여라. ( overflow를 고려하여라.)
//		long mul = 1L;
//		for(int i = 5; i < 15; i++){
//			mul *= i;
//		}
//		System.out.println(mul);

	    //5. 3이상 4462이하에서 짝수인 정수의 합을 구하여라.
//		int sum = 0;
//		for(int i = 3; i < 4463; i++){
//			if(i % 2 == 0){
//				sum += i;
//			}
//		}
//		System.out.println(sum);
		//6. 7초과 57미만에서 2또는 3의 배수인 정수의 합을 구하여라.
//		int sum = 0;
//		for(int i = 8; i < 57; i++){
//			if(i % 2 == 0 || i % 3 == 0){
//				sum += i;
//			} 
//		}
//		System.out.println(sum);
		// 구구단 출력
//		System.out.println(2 +" * "+ 1 +" = " + 2*1);
//		System.out.println(2 +" * "+ 2 +" = " + 2*2);
//		System.out.println(2 +" * "+ 3 +" = " + 2*3);
//		System.out.println(2 +" * "+ 4 +" = " + 2*4);
//		System.out.println(2 +" * "+ 5 +" = " + 2*5);
//		System.out.println(2 +" * "+ 6 +" = " + 2*6);
//		System.out.println(2 +" * "+ 7 +" = " + 2*7);
//		System.out.println(2 +" * "+ 8 +" = " + 2*8);
//		System.out.println(2 +" * "+ 9 +" = " + 2*9);
		
//		for(int i = 2; i < 10; i++){
//			for(int j = 1; j < 10; j++){
//					if(j % 2 == 1 && i % 2 == 0){
//						System.out.println(i +" * "+ j +" = " + i*j);
//					}
//				}			
//		}
		/*
		 3. while문
		   - 조건식과 수행해야할 블럭{}만으로 구성되어 있다.
		   - 기본구조
		     while(조건식){
		     	조건식이 true일 때 수행될 문장
		     }
		 */
		// 1. 0~10까지 출력하여라.
//		for(int i = 0; i < 11; i++){
//			System.out.println(i);
//		}
		//초기화
//		int i = 0;
//		while(i < 11){
//			System.out.println(i);
//			i++;
//		}
		// 1. 5~15까지의 합을 구해주세요. while 
//		int sum = 0;
//		int i = 5;
//		while(i < 16){
//			sum += i;
//			i++;
//		}
//		System.out.println(sum);
		
		// 2. 구구단 while문으로만 만들어주세요.
//		int i = 2;
//		int j = 0;
//		while(i < 10){
//			j++;
//			System.out.println(i + " * " + j + " = "+ i*j);
//			if(j==9){
//				j = 0;
//				i++;
//			}
//		}
//		int i = 2;
//		while(i < 10){
//			int j = 1;
//			while(j < 10){
//				if(i%2==0 && j % 2 ==1)
//				System.out.println(i + " * " + j + " = "+ i*j);
//				j++;
//			}
//			i++;
//		}
		// 1. 7~? 합이 200이상이 될 때 ? 값을 구하시오.
//		int sum = 0;
//		int i = 6;
//		
//		while(sum < 200){
//			i++;
//			sum += i;
//		}
//		System.out.println(i);
//		int sum = 0;
//		int i = 7;
//		while(true){
//			sum += i;			
//			if(sum>=200){
//				break;
//			}
//			i++;
//		}
//		System.out.println(i);
		
		/*
		 4. do-while
		   - 최초 1회는 무조건 반복문을 수행한다.
		   - 구조
		     do{
		     	실행문장
		     }while(조건문);
		 */
		
		// 1. 사용자로부터 문자를 입력받는다.
//		Scanner sc = new Scanner(System.in);
//		String input = null;
////		System.out.println("문자를 입력해주세요. 단 exit를 입력시 종료됩니다.");
////		String input = sc.next();
//		// 2. 입력받은 문자를 출력한다.		
//		do{
//			System.out.println("문자를 입력해주세요. 단 exit를 입력시 종료됩니다.");
//			input = sc.next();
//			System.out.println(input);			
//		}while(!"exit".equals(input));
		
		// 3. 단. 입력받은 문자가 "exit"이면 반복을 멈춘다.
		
//		for(int i = 0; i < 100; i++){
//			if(i % 2 == 0){
//				System.out.println(i);
//			}
//		}
//		
//		for(int i = 0; i < 100; i++){
//			if(i % 2 != 0){
//				continue;
//			}
//			System.out.println(i);
//		}
	}
}
