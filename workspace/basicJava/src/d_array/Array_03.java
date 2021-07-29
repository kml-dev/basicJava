package d_array;

import java.util.Arrays;

public class Array_03 {
	public static void main(String[] args) {
		/*
		 1. 정렬(sort)
		   - 여러 데이터를 빠르고 쉽게 찾기 위해 일정한 순서대로 데이터를 가지런히 나열하는 작업이다.
		   - 버블정렬, 삽입정렬, 선택정렬
		   
		 2. 버블정렬(bubble sort)
		   - 인접한 데이터 간에 교환이 계속해서 일어나면서 정렬이 이루어 진다.
		   - 가장 큰 값이 맨 뒤에 위치한다.
		 
		 */
		// 1. 5개의 정수 5,2,3,1,4 변수 sortNum에 저장해주세요.
//		int[] sortNum = {5,2,3,1,4};
		// 2. 버블정렬을 이용하여 정렬해주세요.
		// 2.1 sortNum의 0번방이 sortNum의 1번방보다 크면 자리를 바꿔라 
//		if(sortNum[0] > sortNum[1]){
//		int temp = sortNum[0];
//		sortNum[0] = sortNum[1];
//		sortNum[1] = temp;
//		}
		// 2.2 sortNum의 값을 출력하여라 => 2,5,3,1,4
//		System.out.println(Arrays.toString(sortNum));
//		if(sortNum[1] > sortNum[2]){
//			int temp = sortNum[1];
//			sortNum[1] = sortNum[2];
//			sortNum[2] = temp;
//		}
//		if(sortNum[2] > sortNum[3]){
//			int temp = sortNum[2];
//			sortNum[2] = sortNum[3];
//			sortNum[3] = temp;
//		}
//		if(sortNum[3] > sortNum[4]){
//			int temp = sortNum[3];
//			sortNum[3] = sortNum[4];
//			sortNum[4] = temp;
//		}
		// 버블정렬 완성
//		for(int i = 0; i < sortNum.length-1; i++){
//			System.out.println(i+1 + "회전 :");
//			for(int j = 0; j < sortNum.length-1-i; j++){
//				if(sortNum[j] > sortNum[j+1]){
//					int temp = sortNum[j];
//					sortNum[j] = sortNum[j+1];
//					sortNum[j+1] = temp;
//				}
//			System.out.println(Arrays.toString(sortNum));
//			}
//		}
	
		
		/*
		 3. 선택정렬(select sort)
		   - 
		 */
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
