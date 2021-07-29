package c_sentence;

public class Sentence_01 {
	public static void main(String[] args){
		/*
		 1. 조건문(if, switch)
		   - 조건식과 문장을 포함하는 블럭{}으로 구성되어 있다.
		   - 조건식의 결과에 따라서 프로그램의 실행 흐름을 변경할 수 있다.
		 
		 2. if문
		   - 구조
		     (1) 기본
		     	 if(조건식){
		     	 	조건식의 결과가 true일 때 수행될 문장.
		     	 }
		     (2) 1단 변형
		     	 if(조건식){
		     	 	조건식의 결과가 true일 때 수행될 문장.
		     	 }else{
		     	 	조건식의 결과가 false일 때 수행될 문장.
		     	 }
		     (3) 2단 변형
		     	 if(조건식){
		     	 	조건식1의 결과가 true일 때 수행될 문장.
		     	 }else if(조건식2){
		     	 	조건식1의 결과가 false이고 조건식2 의 결과가 true일 때 수행될 문장.
		     	 }else{
		     	 	조건1과 조건2가 모두 false일 때 수행될 문장.
		     	 }
		 
		 */
//		int num = -10;
//		if(num>0){
//			System.out.println("양수이다.");
//		}else if(num==0){
//			System.out.println("0이다.");
//		}else{
//			System.out.println("음수이다.");
//		}
		// 0이상 100이하 => 0<= n < 101 => 정수 : 101 시작: 0
//		int score = (int)(Math.random()*101);
//		System.out.println(score);
//		String grade = "";
//		if(score>=90){
//			grade += "A";
//		}else if(score>=80){
//			grade += "B";
//		}else if(score>=70){
//			grade += "C";
//		}else if(score>=60){
//			grade += "D";
//		}else{
//			grade += "F";
//		}
//		if(score%10>=5){
//			grade += "+";
//		}else{
//			grade += "-";
//		}
//		System.out.println(grade);
			
//		if(score>=90){
//			System.out.print("A");
//			if(score>=95){
//				System.out.println("+");
//			}else{
//				System.out.println("-");
//			}	
//		}else if(80<=score){
//			System.out.print("B");
//			if(score>=85){
//				System.out.println("+");
//			}else{
//				System.out.println("-");
//			}
//		}else if(70<=score){
//			System.out.print("C");
//			if(score>=75){
//				System.out.println("+");
//			}else{
//				System.out.println("-");
//			}
//		}else if(60<=score){
//			System.out.print("D");
//			if(score>=65){
//				System.out.println("+");
//			}else{
//				System.out.println("-");
//			}
//		}else{
//			System.out.println("F");
//		}
		/*
		 3. switch문
		   - 조건의 경우의 수가 많을 때는 if문 보다는 switch문을 사용한다.
		   - 간결해서 알아보기가 쉽다.
		   - 조건의 결괏값으로 int형 범위의 정수값을 허용한다.
		   - 구조
		     switch(조건식(값이 들어와야함)){
		     	case 값1:
		     		조건식과 값1이 같을 때 수행될 문장
		     		break;
		     	case 값2:
		     		조건식과 값2이 같을 때 수행될 문장
		     		break;
		     	case 값3:
		     		조건식과 값3이 같을 때 수행될 문장
		     		break;
		     	default : 
		     		조건식과 만족하는 case가 없을 때 수행될 문장
		     		break; // default인 경우에만 생략 가능
		     }
		 */
		
		int random = (int)(Math.random()*101);
		System.out.println(random);
		switch(random/10){
			case 9: case 10:
				System.out.print("A");
				break;
			case 8:
				System.out.print("B");
				break;
			case 7:
				System.out.print("C");
				break;
			case 6:
				System.out.print("D");
				break;
			default:
				System.out.print("F");
		}
		if(random/10<6){
			System.out.println("");
		}else if(random%10>=5){
			System.out.println("+");
		}else if(random==100){
			System.out.println("+");
		}else{
			System.out.println("-");
		}
//		//1. season변수를 선언하고 1~12사이의 임의의 정수값으로 초기화 하여라.
//		int season = (int)(Math.random()*12+1);
//		System.out.println(season);
//		//2. season의 값이 12,1,2의 경우에는 "겨울을 출력, 3,4,5의 경우에는 "봄"을 출력
//		// 6,7,8일 경우 "여름"을 출력, 9,10,11의 경우 "가을"을 출력
//		switch(season){
//			case 12: case 1: case 2:
//				System.out.println("겨울");
//				break;
//			case 3: case 4: case 5:
//				System.out.println("봄");
//				break;
//			case 6: case 7: case 8:
//				System.out.println("여름");
//				break;
//			case 9: case 10: case 11:
//				System.out.println("가을");
//				break;

		
	}
}
