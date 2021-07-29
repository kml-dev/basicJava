package z_exam;

public class Exam_03 {
	public static void main(String[] args) {
		// [3-3] num값에 따라 "양수", "음수", "0"을 출력하는 코드
//		 int num = 10;
//		 String result = num==0? "0": num>0? "양수":"음수";
//		 System.out.println(result);
		// [3-4] 필요한 바구니 수 구하기.
//		int apples = 123;         // 사과의 개수
//		int bucket = 10;          // 바구니의 크기(바구니에 담을 수 있는 사과의 개수)
//		int numOfBucket = (apples/bucket) + (apples%bucket > 0? 1:0);
//		System.out.println("필요한 바구니의 수 :"+numOfBucket);

		// [3-5] 아래의 코드는 변수 num의 값 중에서 백의 자리 이하를 버리는 코드이다.
		//만일 변수 num의 값이 '456'이라면 '400'이 되고, '111'이라면 '100'이 된다.
//		int num = 456;
//		int result = num/100*100;
//		System.out.println( result );
		
		// [3-7] 아래는 변수 num의 값보다 크면서도 가장 가까운 10의 배수에서 변수 num의 값을 뺀 나머지를 구하는 코드이다.
		//       예를 들어, 24의 크면서도 가장 가까운 10의 배수는 30이다. 19의 경우 20이고, 81의 경우 90이 된다.
		//       30에서 24를 뺀 나머지는 6이기 때문에 변수 num의 값이 24라면 6을 결과로 얻어야 한다. 
//		int num = 24;
//	    int result = (num/10*10+10)-num;
//	    System.out.println( "result : "+ result );
		
		// [3-8] 아래는 화씨(Fahrenheit)를 섭씨(Celcius)로 변환하는 코드이다.
		//       변환공식이 'C =5/9 ×(F - 32)'라고 할 때 변환 결과값은 소수점 셋째자리에서 반올림해야한다.
//		int fahrenheit = 100;
//		float formula = 5/9F * (fahrenheit-32);	
//		float celcius =  (int)(formula*100+0.5)/100f;
//		
//		System.out.println(celcius);
//		
//		int result = 0;
//		
//		for(int i = 1;i<=20;i++){
//			if(i%2!=0){
//				if(i%3!=0){
//					result += i;
//				}
//			}
//		}

	}
}
