package d_array;

public class Array_02 {
	public static void main(String[] args) {
		//1. 정수 7개를 저장할 수 있는 변수 score를 선언 및 생성하여라.
		int[] score = new int[7];
	    
		//2. 변수 score의 각 요소를 0이상 100이하인 임의의 정수를 저장하여라.
		for(int i = 0; i < score.length; i++){
			score[i] = (int)(Math.random()*101);
		}
	   
		//3. 변수 score에 저장된 요소들의 합계를 구하여라.
		int sum = 0;
		for(int i = 0; i < score.length; i++){
			sum += score[i];
		}
//		System.out.println(sum);

		//4. 변수 score에 저장된 요소들의 평균을 구하여라. 
	    //  단 소수점 세 번째 자리에서 반올림하여 두 번째 자리까지 표현하여라.
		float avg = (int)(((float)sum/score.length)*100+0.5)/100f;

//		System.out.println(avg);	

	    //5. 변수 score에 저장된 요소에서 최댓값을 구하여라.
		int maxNum = score[0];
		for(int i = 1; i < score.length; i++){
//			System.out.println(score[i]);
			if(maxNum < score[i]){
				maxNum = score[i];
			}
		}	
//		System.out.println(maxNum);

	    //6. 변수 score에 저장된 요소에서 최솟값을 구하여라.
		int minNum = score[0];
		for(int i = 1; i < score.length; i++){
//			System.out.println(score[i]);
			if(minNum > score[i]){
				minNum = score[i];
			}
		}
//		System.out.println(minNum);

	    //7. 1~6번의 결과를 이용하여 결과와 같이 출력하여라.
		System.out.print("score값 : {");
		for(int i = 0; i < score.length; i++){
			if(i != score.length-1){
			System.out.print(score[i]+",");
			}else{
				System.out.print(score[i]);
			}
		}
		System.out.println("}");
		
		System.out.println("합계 : " + sum);
		System.out.println("평균 : " + avg);
		System.out.println("최댓값 : " + maxNum);
		System.out.println("최솟값 : " + minNum);
		
	    //  단. 임의의 정수값들의 연산임으로 결과는 다를 수 있음.
	}

}
