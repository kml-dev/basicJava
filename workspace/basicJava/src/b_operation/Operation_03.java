package b_operation;

public class Operation_03 {
	public static void main(String[] arg){
		/*
		 1. 산술연산자
		   - 사칙연산자(+,-,*,/), 나머지 연산자(%), 쉬프트 연산자( <<, >>, >>>)
		   - 피연산자를 두개를 필요로 하기 때문에 이항연산자로 불린다.
		   
		 2. 사칙연산자(+,-,*,/)
		   - 두 개의 피연산자중 자료형의 표현범위가 큰 쪽에 맞춰서 형변환 후 연산을 수행한다.
		    : int + float => float + float => float
		   - 두 개의 피연산자 모두 4byte보다 크기가 작을 때는 둘 다 4byte인(int)으로 형변환 후 연산을 수행한다.
		    : byte + char => int + int => int
		   - 0으로 나누는 것은 금지되어 있다.    
		    
		 */
//		byte b1 = 80;
//		byte b2 = 100;
//		long lo1 = 642;
//		long result1 = b1 + lo1;
//		System.out.println(result1);
//		int result2 = b1 + b2;
//		System.out.println(result2);
//		byte result3 = (byte) result2;
//		System.out.println(result3);
//		long lo2 = (long)60000*80000;
//		System.out.println(lo2);
//		/*
//		 3. 나머지 연산자(%)
//		   - 왼쪽의  피연산자를 오른쪽의 피연산자로 나누고 난 나머지 값을 돌려준다.
//		   - boolean형에는 사용할 수 없다.
//		 */
//		int num1 = 22; 
//		int num2 = 7;
//		// 몫
//		int share = num1 / num2;
//		// 나머지
//		int remain = num1 % num2;
//		// xx을/를  xx로 나눈 몫은 xx이고 나머지는 xx이다.
//		System.out.println(num1+"을 "+num2+"로 나눈 몫은 "+ share + "이고 나머지는 " + remain +"이다.");
		
		/*
		 4. 쉬프트 연산자(<<, >>, >>>)
		   - 정수형 변수에만 사용할 수 있다.
		   - 연산속도가 매우 바르기 때문에 사용한다.
		   ex)
		       10    : 0 0 0 0 1 0 1 0
		     10 << 2 : 0 0 1 0 1 0 0 0 : 10*2의 2승 : 40
		               byte일 경우 10 << 8은 제자리, int일 경우 10 << 32는 제자리
		     x  << n : x*2^n, overflow가 발생할 수 있음
		     10 >> 2 : 0 0 0 0 0 0 1 0 : 10/2의 2승 : 2
		     x  >> n : x/2^n		 
		 */
//		int i4 = 10;
//		int result4 = i4 << 4;
//		System.out.println("10 << 2: " + result4);
//		System.out.println("10 >> 2: " + (i4 >> 2));
		/*
		 5. 비교연산자 
		   - 두 개의 변수 또는 리터럴을 비교하는데 사용된다.
		   - 주로 조건문과 반복문의 조건식에 사용되며 연산 결과로는 true,false의 값을 가진다.
		   - 이항 연산자이다.
		   
		 6. 대소비교연산자(<, >, <=, >=)
		   - 기본형중에서 boolean을 제외한 나머지 자료형에 사용가능한다.
		 
		 7. 등가비교연산자(==, !=)
		   - 모든 자료형에 사용이 가능하다.
		   
		              수식        |     연산결과   
		      x >  y  |  x가 y보다 클 때만 true, 그 외에는 false
		      x <  y  |  x가 y보다 작을 때만 true, 그 외에는 false
		      x >= y  |  x가 y보다 크거나 같을  때만 true, 그 외에는 false
		      x <= y  |  x가 y보다 작거나 같을  때만 true, 그 외에는 false
		      x == y  |  x와 y가 같을 때만 true, 그 외에는 false
		      x != y  |  x와 y가 다를 때만 true, 그 외에는 false     
		 */
//		boolean result6 = 5 < 10;
//		System.out.println(result6);
//		System.out.println(10 == 10.0f);
//		System.out.println('0'== 0);
//		System.out.println(0.1 == 0.1f); // double은 2^n으로 표현하기 때문에 명확한 값보다는 근사치라 볼 수 있음
//		System.out.println(0.5 == 0.5f); // 0.5는 2-^n으로 명확하게 표현할 수 있기 때문에 같음
		
		/*
		 8. 비트 연산자(&, |, ^)
		   - 이진 비트연산을 수행한다.
		   - 실수형을 제외한 모든 기본형에 사용할 수 있다.
		   
		   |(OR연산)  : 피연산자 중 어느 한쪽의 값이 1이면 1의 결과를 가져온다.
		   &(AND연산) : 피연산자가 둘 다 1이면 1의 결과를 가져온다.
		   ^(XOR연산) : 피연산자가 서로 다르면 1의 결과를 가져온다.
		  
		   ex)  3 -> 0 0 0 0 0 0 1 1
		        5 -> 0 0 0 0 0 1 0 1
		   	3 & 5 -> 0 0 0 0 0 0 0 1
		   	3 | 5 -> 0 0 0 0 0 1 1 1
		   	3 ^ 5 -> 0 0 0 0 0 1 1 0
		  
		  9. 논리 연산자(&&, ||)
		    - 피연산자로 boolean형 값 또는 boolean형을 결과로 하는 조건식만을 허용한다.
		    - ||연산이 &&보다 연산 우선순위가 낮다.
		    
		    || (OR결합) : 피연산자 중 어느 한 쪽만 true이면 true의 결과를 얻는다.
		    && (AND결합): 피여산자 양쪽 모두 true일 때 true의 결과를 가져온다.
		 
		 */
//		int input = 17;
//		
//		// 3 < input <= 15
//		// 3 < input && input <= 15
//		boolean result = 3 < input && input <= 15;
//		System.out.println(result);
		
//		char ch01 = '5';
//		System.out.println('A' <= ch01 && ch01 <= 'Z');
//		System.out.println('a' <= ch01 && ch01 <= 'z');
//		System.out.println('A' <= ch01 && ch01 <= 'Z'||'a' <= ch01 && ch01 <= 'z');
//		System.out.println('0'<=ch01 && ch01 <= '9');
		
		//6. 변수 ch01의 값이 영문자 또는 숫자일 때 true인 조건식을 작성하여라.
		boolean result = 'A' <= ch01 && ch01 <= 'Z' || 'a' <= ch01 && ch01 <= 'z' || '0'<= ch01 && ch01 <= '9';
		System.out.println(result);
		
		
	}
}
