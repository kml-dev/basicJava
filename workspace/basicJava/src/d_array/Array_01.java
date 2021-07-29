package d_array;

public class Array_01 {
	public static void main(String[] args) {
		/*
		 1. 배열(Array)
		   - 같은 타입의 여러 변수를 하나의 묶음으로 다루는 것
		     int math;
		     int eng;
		     int soc;
		     
		 2. 배열의 선언 
		   - 원하는 타입의 변수를 선언하고 변수 또는 타입에 배열임을 의미하는 대괄호[]를 붙이면  된다.
		   - 구조
		          변수 타입[] 변수명; int[] score;
		          변수타입 변수명[];  int score[];
		 
		 3. 배열의 생성
		   - 배열을 생성하기 위해서는 연산자 'new'와 함께 배열의 타입과 크기를 지정해 주어야 한다.
		     ex) score = new int[3];
		   - 배열을 한번 생성되면 크기를 변경할 수 없다.
		   
		 */
//		int[] score = new int[5];  // {0,0,0,0,0}
//		for(int i = 0; i < 5; i++){
//			System.out.println(score[i]);
//		}
		
//		score[0] = 10;
//		score[1] = 20;
//		score[2] = 30;
//		score[3] = 40;
//		score[4] = 50;
		// 시작 : 0 끝 : 4 증가량 : 1  // 시작 : 10 끝 : 50 증가량 : 10
//		for(int i = 0; i < score.length; i++){
//			score[i] += (i+1)*10;
//			System.out.println(score[i]);
//		}
		// 2. 배열의 선언 및 초기화를 원하는 값으로 하기
//		int[] score = new int[]{10,20,30,40,50};
//		int[] score2 = {1,2,3,4,5};
//		
//		for(int i = 0; i < score.length; i++){
//			System.out.println(score[i]);
//		}
//		 
		
//		int[] ss;
//		ss = new int[2];
//		
//		int[] ss2;
//		ss2 = new int[]{1,2,3};
		
//		int[] ss3;
//		ss3 = {5,6,7};  // 이렇게는 할 수 없음
		
		//1. 변수 names에 같은 팀원들의 이름을 저장해주세요.
		String[] names = {"신민경","구나은","이경민"};
//		System.out.println(names[2].length());
		// 1단계
		for(int i = 0; i < names.length; i++){
			for(int j = 0;j < names[i].length(); j++){
				System.out.println(names[i].charAt(j));	
			}			
			System.out.println("-----");
		}
//		String[] names = new String[3];   // null값이 저장 됨
//		System.out.println(names[2]);
		// 2
	}
}
