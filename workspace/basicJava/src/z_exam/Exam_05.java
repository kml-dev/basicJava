package z_exam;

import java.util.Arrays;

public class Exam_05 {
	public static void main(String[] args) {
//		int[] nums = {5,2,3,1,4};
//		System.out.println(Arrays.toString(nums));
	
		// [5-2] 
		// (1) 2 (2) 4 (3) 오류
		
		// [5-3] 배열 arr에 담긴 모든 값을 더하는 프로그램
//		int[] arr = {10,20,30,40,50};
//		int sum = 0;
//		for(int i = 0; i < arr.length; i++){
//			sum += arr[i];
//		}
//		System.out.println("Sum = "+ sum);
		
		// [5-4] 2차원 배열 arr에 담긴 모든 값의 합과 평균 구하는 프로그램.
//		 int[][] arr = {
//                 		{ 5, 8, 13, 5, 2 },
//                 		{ 22, 13, 28 },
//                 		{ 2, 18, 23, 62}
//                 		};
//		 int total = 0;
//		 int arrLen = 0;
//		 for(int i = 0; i < arr.length; i++){
//			 arrLen += arr[i].length;
//			 for(int j = 0; j < arr[i].length; j++){
//				 total += arr[i][j];
//			 }
//		 }
//		 System.out.println("total = " + total);
//		 float avg = (float)total/arrLen;
//		 System.out.println("Average = " + avg);
		
		 // [5-5] 거스름돈 프로그램
//		 int[] coinUnit = { 500, 100, 50, 10 };
//		 int money = 2790;
//		 for(int i = 0; i < coinUnit.length; i++){
//			 System.out.println(coinUnit[i]+"원 : "+ money/coinUnit[i]+"개");	
//			 money -= coinUnit[i]*(money/coinUnit[i]);
//		 }
		 
		// [5-6] 1과 9사이의 중복되지 않은 숫자로 이루어진 3자리 숫자 만들기.
//		int[] ballArr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
//	    int[] ball3 = new int[3];
	   	
//	    for(int i = 0; i < ballArr.length; i++){
//	    	ballArr[i] = (int)(Math.random()*9+1);
//	    	for(int j = 0; j < i;j++){
//	    		if(ballArr[i]==ballArr[j]){
//	    			i--;
//	    		}
//	    	}
//	    }	
//	    System.out.println(Arrays.toString(ballArr));
	    
	    //ballArr 앞에서 3개를 ball3로 복사 및 출력
//	    for(int k = 0; k < ball3.length; k++){
//	    	ball3[k] = ballArr[k];
//	    	System.out.println(ball3[k]);
//	    }
		
//		 int[] ballArr = {1,2,3,4,5,6,7,8,9};
//		 for(int i = 0; i < ballArr.length; i++){
//		 		int temp = ballArr[i];
//		 		int rand = (int)(Math.random()*9);
//		 		ballArr[i]  = ballArr[rand];
//		 		ballArr[rand] = temp;
//		 }
//		 
//		 System.out.println(Arrays.toString(ballArr));
	    // [5-7] answer에 담긴 데이터를 읽어 숫자를 세어 "*"출력.
//		int[] answer = { 1, 4, 3, 2, 1, 2, 3, 2, 1, 4 };
//	    int[] counter = new int[4];
//		
//	    for(int i = 0; i < answer.length; i++){
//	    	counter[answer[i]-1] += 1;
//	    }
//		
//	    for(int j = 0; j < counter.length; j++){
//	    	System.out.print(j+1 + " : " + counter[j]+"개" + " ");
//	    	for(int k = 0; k < counter[j]; k++){
//	    		System.out.print("*");
//	    	}
//	    	System.out.println();
//	    } 
	    
	    /* hide 문제 몇부터 시작 몇이 끝인지 모름, 길이도 모름, 최댓값-최솟값, 범위 5등분(다섯개 통계), 영역에 들어 있는지, 
		*/
	    
		// [5-8] 5-5 동전개수 추가 문제
//		if(args.length!=1){
//		      System.out.println("한개의 숫자만 입력해 주세요.");
//		      System.exit(0);
//		    }
//		     문자열을 숫자로 변환한다. 입력한 값이 숫자가 아닐 경우 예외가 발생한다.
//		    int money = Integer.parseInt(args[0]);
	    
//	    int money = 3000;
//		System.out.println("money= "+money);
//		int[] coinUnit =  { 500, 100, 50, 10 } ; // 동전의 단위
//		int[] coin = { 5, 5, 5, 5 } ; // 단위별 동전의 개수
//
//		for(int i=0; i < coinUnit.length; i++) {
//			int coinNum = 0;
//		
//			//1. 금액(money)을 동전단위로 나눠서 필요한 동전의 개수(coinNum)를 구한다.
//			coinNum = money/coinUnit[i];
//		     	      
//			//2. 배열 coin에서 coinNum만큼의 동전을 뺀다.
//			//(만일 충분한 동전이 없다면 배열 coin에 있는 만큼만 뺀다.)
//			coin[i] -= coinNum;
//			if(coin[i] - coinNum < 0){
//				coin[i] = 0;
//				coinNum = 5;
//			}
//		
//			//3. 금액에서 동전의 개수(coinNum)와 동전단위를 곱한 값을 뺀다.
//			money -= coinNum*coinUnit[i];
//			System.out.println(coinUnit[i]+"원: "+coinNum);
//		}
//		System.out.println(money);
//		
//		if(money > 0) {
//			System.out.println("거스름돈이 부족합니다.");
//		    System.exit(0); // 프로그램을 종료한다.
//		}
//
//		System.out.println("=남은 동전의 개수 =");
//		for(int i=0;i<coinUnit.length;i++) {
//		      System.out.println(coinUnit[i]+"원:"+coin[i]);
//		}
		
		// [5-9] 주어진 배열을 시계 방향으로 90회전 시켜 출력하는 프로그램.
//		char[][] star = {
//			    {'*','*',' ',' ',' '},
//			    {'*','*',' ',' ',' '},
//			    {'*','*','*','*','*'},
//			    {'*','*','*','*','*'}
//			  };
//	    char[][] result = new char[star[0].length][star.length]; //[5][4]
//j
//	    for(int i=0; i < star.length;i++) {
//	      for(int j=0; j < star[i].length;j++) {
//	        System.out.print(star[i][j]);
//	      }
//	      System.out.println();
//	    }
//	    System.out.println();
//	    
//
//	    for(int i=0; i < star.length;i++) {
//	      for(int j=0; j < star[i].length;j++) {
//	    	  result[j][i] += star[star.length-(i+1)][j];
//	      }
//	    }
//
//	    for(int i=0; i < result.length;i++) {
//	      for(int j=0; j < result[i].length;j++) {
//	        System.out.print(result[i][j]);                                                                               
//	      }
//	      System.out.println();
//	    }
		
		
		
	}
}
