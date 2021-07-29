package b_operation;

public class Operation_01 {
	public static void main(String[] args){
		/*
		 1. 연산자 기본
		   - 단항연산자(*,-x)
		     : ++,--,+,-,~,!,(타입)
		   - 이항연산자(x+y)
		     : 산술연산자 => +, -, *, /, %, <<, >>, >>>
		     : 비교연산자 => <, >, <=, >=, ==,!=, instanceof
		     : 논리연산자 => &(AND), |(OR), ^(XOR), &&(AND결합), ||(OR결합)
		   - 삼항연산자(X? Y or Z)
		     : 1? 2:3
		   - 대입연산자
		     : =, op=
		     
		  2. 연산 우선순위
		    - 단항 > 이항  > 삼항
		    - 산술 > 비교 > 논리 > 대입	    
		 */
		int x = 2;
		int y = 5;
		System.out.println(1+ x<<33);
		
//		//nested : 중첩된 연산
//		if(num==0){
//			System.out.println("0");
//		}else{
////			System.out.println("0이아님");
//			if(num>0){
//				System.out.println("양수");
//			}else{
//				System.out.println("음수");
//			}
//		}
//		
////		System.out.println(result);
//		//-------------------------------------
//		
//		String a = "사과";
//		
//		//문자열 비교 .equals
//		if(a.equals("사과")){
//			System.out.println("맞다.");
//		}else{
//			System.out.println("틀리다.");
//		}
	}
}
