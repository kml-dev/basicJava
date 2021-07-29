package z_exam;

import java.util.Arrays;

public class Qu_05 {
	public static void main(String[] args) {
		// [2-25] 
//		int[] score = new int[5]; 
//	
//		int num = 10;
//		for(int i = 0; i < score.length; i++){
//			score[i] = num*i;
//			System.out.println("score[" + i + "] : " + score[i]);
//		}
		
		// [2-26]
		//1. 정수 7개를 저장할 수 있는 변수 score를 선언 및 생성하여라.
//		int[] score = new int[7];
//
//	    //2. 변수 score의 각 요소를 0이상 100이하인 임의의 정수를 저장하여라.
//		for(int i = 0; i < score.length; i++){
//			score[i] = (int)(Math.random()*101);
//		}
//
//	    //3. 변수 score에 저장된 요소들의 합계를 구하여라.
//		int sum = 0;
//		for(int i = 0; i < score.length; i++){
//			sum += score[i];
//		}
//
//	    //4. 변수 score에 저장된 요소들의 평균을 구하여라. 
//	    //  단 소수점 세 번째 자리에서 반올림하여 두 번째 자리까지 표현하여라.
//		float avg = (int)(((float)sum/score.length)*100+0.5)/100f;
//
//	    //5. 변수 score에 저장된 요소에서 최댓값을 구하여라.
//		int max = score[0];
//		for(int i = 0; i < score.length; i++){
//			if(score[i] > max){
//				max = score[i];
//			}
//		}
//
//	    //6. 변수 socre에 저장된 요소에서 최솟값을 구하여라.
//		int min = score[0];
//		for(int i = 0; i < score.length; i++){
//			if(score[i] < min){
//				min = score[i];
//			}
//		}
//	
//	    //7. 1~6번의 결과를 이용하여 결과와 같이 출력하여라.
//	    //  단. 임의의 정수값들의 연산임으로 결과는 다를 수 있음.
//		
//		System.out.print("score 값 : {"	);
//		for(int i = 0; i < score.length; i++){
//			if(i != score.length-1){
//				System.out.print(score[i]+",");
//			}else{
//				System.out.print(score[i]+"}");
//			}
//		}
//		System.out.println();
//		System.out.println("합계 : " + sum);
//		System.out.println("평균 : "+ avg);
//		System.out.println("최댓값 : " + max);
//		System.out.println("최솟값 : " + min);
	
		// [2-27]
		// 1. 5개의 정수 5,2,3,1,4 변수 sortNum에 저장해주세요.
//		int[] sortNum = {5,2,3,1,4};
//		
//		for(int i = 0; i < sortNum.length-1; i++){
//			System.out.println(i+1 + "회전 :");
//			for(int j = 0; j < sortNum.length-1-i; j++){
//				if(sortNum[j] > sortNum[j+1]){
//					int temp = sortNum[j];
//					sortNum[j] = sortNum[j+1];
//					sortNum[j+1] = temp;
//				}
//				System.out.println(Arrays.toString(sortNum));
//			}
//		}
		
		// [2-28]
		//1. 5개의 숫자 5,2,3,1,4를 오름차순으로 정렬하는 코드를 작성하여라.
//		int[] sortNum = {5,2,3,1,4};
	    // 단. 선택정렬을 이용하여라.
//		for(int i = 0; i < sortNum.length; i++){
//			int min = sortNum[i];
//			int minIndex = i;
//			for(int j = i; j < sortNum.length; j++){
//				if(sortNum[j] < min){
//					min = sortNum[j];
//					minIndex = j;
//				}
//			}
//			int temp = sortNum[i];
//			sortNum[i] =sortNum[minIndex];
//			sortNum[minIndex] = temp;
//
//			System.out.println(Arrays.toString(sortNum));
//		}
	}
}
