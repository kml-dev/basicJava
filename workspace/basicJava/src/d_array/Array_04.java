package d_array;

import java.util.Arrays;

public class Array_04 {
	public static void main(String[] args) {
		/*
		 1. 다차원 배열
		   - 자바에서는 1차원 배열뿐만 아니라 2차원 이상의 다차원 배열도 허용한다.
		   - 2차원 배열의 선언방법
		   	  선언방법                           선언예
		  변수타입[][] 변수명;     int[][] arr;
		  변수타입[] 변수명[];     int[] arr[];
		  변수타입 변수명[][];     int arr[][];
		  
		  	  
		 */
//		int[][] arr = new int[2][3];
//		
////		System.out.println(arr[0][0]);
////		System.out.println(arr[0][1]);
////		System.out.println(arr[0][2]);
////		System.out.println(arr[1][0]);
////		System.out.println(arr[1][1]);
////		System.out.println(arr[1][2]);
//		
//		for(int i = 0; i < arr.length; i++){
//			for(int j = 0; j < arr[i].length; j++){
//				System.out.println(arr[i][j]);
//			}
//		}
		
//		int[][] apt = new int[3][];
//		/*
//		 {
//		 	null,
//		 	null,
//		 	null,
//		 }
//		 */
//		apt[0] = new int[3];
//		apt[1] = new int[4];
//		apt[2] = new int[2];
//		System.out.println(Arrays.toString(apt[2]));
		// 3. 우리반에서 아는 6명의 친구이름을 저장해주세요.
		String[] names = {"신민경", "구나은", "성원제", "길민선", "박상빈", "하윤주"};
				
		// 4. 7과목 추가.
		String[] subjects = {"국어","영어","수학","사회","과학","음악","체육"};
		
		// 1. 6명의 7과목을의 점수(정수)를 저장할 수 있는 변수 score를 선언 및 생성하여라.
		int[][] score = new int[names.length][subjects.length]; 
				
		// 2. score의 각방의 값을 0~100사이의 임의의 값으로 초기화 하여라.
		for(int i = 0; i < score.length; i++){
			for(int j = 0; j < score[i].length; j++){
				score[i][j] += (int)(Math.random()*101);
			}
		}
		// 5. 사람 별 합계를 구하시오.
		
		int[] sum = new int[names.length];
		for(int i = 0; i < score.length; i++){
			for(int j = 0; j < score[i].length; j++){
				sum[i] += score[i][j];				
			}
		}
		
		// 6. 사람 별 평균 구하기
		float[] avg = new float[names.length];
		for(int i = 0; i < names.length; i++){
			avg[i] = (int)(((float)sum[i]/subjects.length)*100+0.5)/100f;
		}
		
		// 7. 과목 별 합계
		int[] subSum = new int[subjects.length];
				
		for(int i = 0; i < subjects.length; i++){
			for(int j = 0; j < names.length; j++){
				subSum[i] += score[j][i];
			}
		}
		
		// 8. 과목 별 평균
		float[] subAvg = new float[subjects.length];
		for(int i = 0; i < subjects.length; i++){
			subAvg[i] += (int)(((float)subSum[i]/names.length)*100+0.5)/100f;
		}
		
		// 9. 사람 별 석차.
		int[] ranks = new int[names.length];
		
		for(int i = 0; i < sum.length; i++){
			for(int j = 0; j < sum.length; j++){
				if(sum[i] < sum[j]){
					ranks[i]++;
				}
			}
			ranks[i]++;
		}
		
		
		// 0. 출력
				
		for(int k = 0; k < subjects.length; k++){
			System.out.print("\t" + subjects[k]);
		}
		System.out.print("\t합계\t평균\t석차");
		System.out.println();
		for(int i = 0; i < score.length; i++){
			System.out.print(names[i] + " : ");
			for(int j = 0; j < score[i].length; j++){
				System.out.print(score[i][j] + "\t");
			}
			System.out.print(sum[i]+"\t"+avg[i]+"\t"+ranks[i]);
			System.out.println();
		}
		System.out.print("합계 :");
		for(int l = 0; l < subjects.length; l++){
			System.out.print("\t" + subSum[l]);
		}
		System.out.println();
		System.out.print("평균 :");
		for(int m = 0; m < subjects.length; m++){
			System.out.print("\t" + subAvg[m]);
		}
		System.out.println();
		

		int[] kor = new int[names.length];
		int[] eng = new int[names.length];
		int[] mat = new int[names.length];
		int[] soc = new int[names.length];
		int[] sci = new int[names.length];
		int[] mus = new int[names.length];
		int[] phy = new int[names.length];
		
		for(int i = 0; i < subjects.length; i++){
			for(int j = 0; j < names.length; j++){
				switch(i){
					case 0:
						kor[j] = score[j][i];
						break;
					case 1:
						eng[j] = score[j][i];
						break;
					case 2:
						mat[j] = score[j][i];
						break;
					case 3:
						soc[j] = score[j][i];
						break;
					case 4:
						sci[j] = score[j][i];
						break;
					case 5:
						mus[j] = score[j][i];
						break;
					case 6:
						phy[j] = score[j][i];
						break;
				}
			}
		}		
		
		for(int i = 0; i < ranks.length-1; i++){
			for(int j = 0; j < ranks.length-1; j++){
				if(ranks[j] > ranks[j+1]){
					int temp = ranks[j];
					ranks[j] = ranks[j+1];
					ranks[j+1] = temp;
					
					temp = sum[j];
					sum[j] = sum[j+1];
					sum[j+1] = temp;
					
					String temp2 = names[j];
					names[j] = names[j+1];
					names[j+1] = temp2;
							
					float temp3 = avg[j];
					avg[j] = avg[j+1];
					avg[j+1] = temp3;
					
					temp = kor[j];
					kor[j] = kor[j+1];
					kor[j+1] = temp;
					
					temp = eng[j];
					eng[j] = eng[j+1];
					eng[j+1] = temp;
					
					temp = mat[j];
					mat[j] = mat[j+1];
					mat[j+1] = temp;
					
					temp = soc[j];
					soc[j] = soc[j+1];
					soc[j+1] = temp;
					
					temp = sci[j];
					sci[j] = sci[j+1];
					sci[j+1] = temp;
					
					temp = mus[j];
					mus[j] = mus[j+1];
					mus[j+1] = temp;
					
					temp = phy[j];
					phy[j] = phy[j+1];
					phy[j+1] = temp;
					
				}
			}
		}
		
		for(int i = 0; i < subjects.length; i++){
			for(int j = 0; j < names.length; j++){
				switch(i){
					case 0:
						score[j][i] = kor[j];
						break;
					case 1:
						score[j][i] = eng[j];
						break;
					case 2:
						score[j][i] = mat[j];
						break;
					case 3:
						score[j][i] = soc[j];
						break;
					case 4:
						score[j][i] = sci[j];
						break;
					case 5:
						score[j][i] = mus[j];
						break;
					case 6:
						score[j][i] = phy[j];
						break;
				}
			}
		}
		

		
		
		
		System.out.println("====================================== sort 후 ===================================");
		for(int k = 0; k < subjects.length; k++){
			System.out.print("\t" + subjects[k]);
		}
		System.out.print("\t합계\t평균\t석차");
		System.out.println();
		for(int i = 0; i < score.length; i++){
			System.out.print(names[i] + " : ");
			for(int j = 0; j < score[i].length; j++){
				System.out.print(score[i][j] + "\t");
			}
			System.out.print(sum[i]+"\t"+avg[i]+"\t"+ranks[i]);
			System.out.println();
		}
		System.out.print("합계 :");
		for(int l = 0; l < subjects.length; l++){
			System.out.print("\t" + subSum[l]);
		}
		System.out.println();
		System.out.print("평균 :");
		for(int m = 0; m < subjects.length; m++){
			System.out.print("\t" + subAvg[m]);
		}
		System.out.println();
		
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
