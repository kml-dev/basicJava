package a_variable;

public class Variable_02 {
	public static void main(String[] args) {
		/*
		 변수의 타입
		 
		 1. 기본형 타입(primitive type)
		   - boolean, char, byte, short, int, long, float, double
		 
		 2. 참조형 타입(reference type)
		   - 주소를 저장한다.
		   
		 3. 기본형 변수의 종류 
		   - 논리형 : 참, 거짓, boolean
		   - 문자형 : 문자, char
		   - 정수형 : 정수, byte, short, int, long 
		   - 실수형 : 실수, float, double <- 기본형
		   
		 4. 기본형 변수의 크기
		   - 1byte : boolean, byte
		   - 2byte : char, short
		   - 4byte : int, float
		   - 8byte : long, double
		 5. 논리형 - boolean : 기본값 false
		   - boolean형 변수에는 true or false의 값만 저장할 수 있다.
		   - boolean형 변수는 대답(yes/no), 스위치(on/off)등의 논리구조에 주로 사용된다.
		   
		 */
		
		//1. 변수 power를 선언하고 true의 값으로 초기화 하여라.
		// 변수 타입 변수명 = 값;
		boolean power = true;
		
		/*
		 6. 문자형 - char
		   - 문자 하나를 저장하는 용도로 사용한다.
		   - java는 unicode문자 체계를 이용한다.
		 */
		// 2. 자신의 성을 변수 sung에 저장해주세요
		
		char sung = 'A';
		
		char sung1 = 65;
		
		char sung2 = '\u0041';
		
		System.out.println(sung);
		System.out.println(sung1);
		System.out.println(sung2);
		
		/*
		 7. 정수형 - byte, short, int, long
		   - 기본 자료형은 int이다
		   - 저장하려는 정수값의 크기에 따라 4개의 정수형 중 하나를 선택하면 된다.
		 */
		// 1. 변수 b2에 50의 값을 저장해주세요
		byte b2 = 50;
		// 2. 변수 s2에 32000의 값을 저장해주세요
		short s2 = 32000;
		// 3. 변수 i2에 40만의 값을 저장해주세요
		int i2 = 400000;
		// 4. 변수 l2에 100억의 값을 저장해주세요
		long l2 = 10000000000L;
		
		/*
		 8. 실수형 - float, double
		   - 기본 자료형은 double입니다.
		   - 자료형을 선택할 때 크기도 중요하지만 정밀도가 더 중요하다.
		   - float -> 1:8:23 = 32bit <잘리는 소수점 반 올림
		   - double -> 1:11:52 = 64bit <보다 정밀함
		 */
//		1./ float 타입형 변수 f1에 3.14241232132131232313212의 값을 저장해 주세요.
		float f1 = 3.14241232132131232313212F;
//		2. double 타입형 변수 d1에 3.14241232132131232313212의 값을 저장해 주세요.
		double d1 = 3.14241232132131232313212;
		
		System.out.println(f1);
		
		/*
		 9. String 
		   - 문자열을 다루기 위해 만들어진 클래스이다.
		   - 참조형(주소 저장)
		 */
		String name = "===============\n-------------";
		
		System.out.println(name);
		
		int i3 = 20;
		String str = "3";
		
		String result = i3 + str;
		// int + String => String + String => String
		// 20 + "3" => "20" + "3" => "203"
		System.out.println(result);
		
		true + "나가"
		
		
		
		/*
		 10. overflow
		   - 변수가 자신이 저장할 수 있는 범위를 넘었을 때 최솟값부터 다시 표현하는 현상
		 */
		
		byte b3 = 126;
		
		System.out.println(b3);
		
		b3++;
		
		System.out.println(b3);
		
		b3++;
		
		System.out.println(b3);
		
		/*
		 11. 캐스팅(casting)
		   - 변수 또는 리터럴(값을 의미)의 타입을 다른 타입으로 변환하는 것이다.
		   - 작성 방법
		     (타입)피연산자
		   - overflow가 발생하지 않는다면 캐스팅 연산자를 생략해도 됨
		 */
		char c = 'a';
		int ii = c;
		
		System.out.println(ii);
		
		byte bb = (byte)ii;
		
		
	}
}
