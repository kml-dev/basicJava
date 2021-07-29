package $_programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;

public class Programmers {
	public static void main(String[] args) {
//			int[] arr = {1,3,2,4,2};
//			
//			int[] a = {1,2,3,4,5};
//			int[] b = {2,1,2,3,2,4,2,5};
//			int[] c = {3,3,1,1,2,2,4,4,5,5};
//			
//			int[] cnt = new int[3];
//			
//			for(int i = 0; i < arr.length; i++){
//				if(arr[i]==a[i%a.length]){
//					cnt[0]++;
//				}
//				if(arr[i]==b[i%b.length]){
//					cnt[1]++;
//				}
//				if(arr[i]==c[i%c.length]){
//					cnt[2]++;
//				}
//			}
//			
//			int cnt2 = 0;
//			for(int j = 0; j < cnt.length; j++){
//				int max = cnt[0];
//				if(cnt[j] > cnt[(j+1)%cnt.length]){
//					max = cnt[j];
//				}
//				if(cnt[j] == max){
//					cnt2++;
//				}
//			}
//				    
//			int[] cnt3 = new int[cnt2];
//		     		
//		    for(int k = 0; k < cnt.length; k++){
//					int max = cnt[0];
//					if(cnt[k] > cnt[(k+1)%cnt.length]){
//						max = cnt[k];
//					}
//					if(cnt[k] == max){
//						cnt3[k] = k+1;
//					}
//			}
//		   
//		int n = 6;
//		String[] ans = new String[n];
//		String[] answer = new String[n];
//		
//		int[] arr1 = {46, 33, 33, 22, 31, 50};
//		int[] arr2 = {27, 56, 19, 14, 14, 10};
//        
//        for(int i = 0; i < arr1.length; i++){
//        	if(Integer.toBinaryString(arr1[i] | arr2[i]).length() == n){
//        		ans[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
//        	}else{
//        		ans[i] = String.format("%0"+n+"d", Integer.parseInt(Integer.toBinaryString(arr1[i] | arr2[i])));
//        	}
//        }
//        
//        System.out.println(Arrays.toString(ans));
//        
//        for(int j = 0; j < ans.length; j++){
//        	String temp = "";
//            if(ans[j].length() != 6){
//        	   temp += " ";
//            }
//        	for(int k = 0; k < ans[j].length(); k++){
//        		if(ans[j].charAt(k) == '1'){
//        			temp += '#';
//        		}else{
//        			temp += ' ';
//        		}
//        	}
//        	answer[j] = temp;	
//        }
//
//        System.out.println(Arrays.toString(answer));
//		String a = "1234";
//		boolean answer = true;
//        for(int i = 0; i < a.length(); i++){
//            if('0' <= a.charAt(i) && a.charAt(i) <= '9'){
//                answer = true;
//            }else{
//            	answer = false;
//            	break;
//            }
//        }
//        System.out.println(answer);		
		
		
//		Scanner sc = new Scanner(System.in);
//		System.out.println("첫번째 수 :");
//		int num1 = sc.nextInt();
//		System.out.println("부호 :");
//		String buho = sc.next();
//		System.out.println("두번째 수 :");
//		int num2 = sc.nextInt();
//		
//		String result = buho.equals("+")? ""+(num1 + num2):
//						buho.equals("-")? ""+(num1-num2) :
//						buho.equals("/")? ""+(float)num1 / num2 :
//						buho.equals("*")? ""+(long)num1 * num2 : "아무것도아님";
//		System.out.println(result);
//		long num = 626331;
//		int answer = 0;
//		int cnt = 0;
//        while(cnt <= 500){
//            if(num % 2 == 0){
//                num /= 2;       
//            }else if(num % 2 != 0){
//                num = num*3 + 1;
//            }
//            if(num == 1){
//            	System.out.println(cnt);
//            }
//            cnt++;
//        }
//        System.out.println(answer);
//        System.out.println(cnt);
//		boolean answer = true;
//		int x = 10;
//		String str = x + "";
//		String[] str2 = new String[str.length()];
//		int result = 0;
//		for(int i = 0; i < str.length(); i++){
//			str2[i] = str.charAt(i) + "";
//		}
//		for(int j = 0; j < str2.length; j++){
//			result += Integer.parseInt(str2[j]);
//		}
//		System.out.println(Arrays.toString(str2));
//		System.out.println(result);
//		int n = 5;
//		int[] lost = {2,4};
//		int[] reserve = {1,3,5};
//		int[] get = new int[n];
//		int answer = 0;
//		
//		for(int i = 0; i < get.length; i++){
//			get[i] = 1;
//		}
//		
//		System.out.println(Arrays.toString(get));
//		
//		for(int j = 0; j < lost.length; j++){
//			get[lost[j]-1]--;
//		}
//		
//		System.out.println(Arrays.toString(get));
//		
//		for(int k = 0; k < reserve.length; k++){
//			get[reserve[k]-1]++;
//		}
//		
//		for(int l = 0; l < get.length-2; l++){
//			if(get[l] > 1){
//				if(l == 0 && get[1] == 0){
//					get[l]--;
//					get[1]++;
//				}else if(l == get.length-1 && get[l-1] == 0){
//					get[l]--;
//					get[l-1]++;
//				}else if(get[l-1] == 0){
//					get[l]--;
//					get[l-1]++;
//				}else if(get[l+1] == 0){
//					get[l]--;
//					get[l+1]++;
//				}
//			}
//		}
//		
//		for(int m = 0; m < get.length; m++){
//			if(get[m] > 0){
//				answer++;
//			}
//		}
//		
//		
//		
//		System.out.println(Arrays.toString(get));
//		int[] array = {1,5,2,6,3,7,4};
//		int[][] commands = {
//							{2,5,3},
//							{4,4,1},
//							{1,7,3}
//							};
//		for()
//		int a = 12;
//		int b = 31;
//		String[] day = {"FRI","SAT","SUN","MON","TUE","WED","THU"};
//        int[] month = {31,29,31,30,31,30,31,31,30,31,30,31};
//        String answer = "";
//        
//        month[a-1] = b;
//        int result = 0;
//        for(int i = 0; i < a; i++){
//            result += month[i];
//        }
//        
//        System.out.println(day[(result-1)%7]);
//		
//		String s = "qwer";
//		String answer = "";
//		if(s.length() % 2 != 0){
//			answer = s.charAt(s.length()/2)+"";
//		}else{
//			answer = s.charAt(s.length()/2-1)+"" + s.charAt(s.length()/2);
//		}
//		System.out.println(answer);
//		int[] arr = {1,1,3,3,0,1,1};
//		int cnt = 0;
//		for(int i = 0; i < arr.length; i++){
//			int pivot = arr[i];
//			for(int j = 0; j < arr.length; j++){
//				if(arr[j] == pivot){
//					arr[j] = -1;
//				}
//			}
//		}
//		
//		System.out.println(Arrays.toString(arr));
//		int a = 5;
//		int b = 3;
//		if(b < a){
//			int temp = a;
//			a = b;
//			b = temp;
//		}
//		System.out.println(a);
//		System.out.println(b);
//		int n = 5;
//		int answer = 0;
//		
//		for(int i = 1; i <= n; i++){
//			int cnt = 0;
//			for(int j = 1; j <= n; j++){
//				if(i % j == 0){
//					cnt++;
//				}
//			}
//			if(cnt == 2){
//				answer++;
//			}
//		}
//		System.out.println(answer);
//		int n = 1000;
//		int answer = 0;
//		
//		for(int i = 1; i <= n; i++){
//			if(i == 1){
//				continue;
//			}else if(i == 2 || i == 3){
//				continue;
//			}else if(i % 2 == 0 || i % 3 == 0){
//				continue;
//			}
//			
//		}
//		int[] a = {1,2,3,4};
//		int[] b = {-3,-1,0,2};
//		long answer = 0;
//		for(int i = 0; i < a.length; i++){
//			answer += a[i]*b[i];
//		}
//		System.out.println(answer);
//		String s = "AB";
//		String str = "abcdefghijklmnopqrstuvwxyz";
//		int n = 1;
//		String answer = "";
//		
//		for(int i = 0; i < s.length(); i++){
//			for(int j = 0; j < str.length(); j++){
//				if(s.charAt(i) == str.charAt(j)){
//					answer += (char)str.charAt((j+n)%26) + "";
//				}
//			}
//		}
////		System.out.println(answer);
//		int n = 5;
//		int answer = 0;
//		
//		for(int i = 0; i <= n; i++){
//			if(i == 0){
//				continue;
//			}
//			if(n % i == 0){
//				answer += i;
//			}
//		}
//		System.out.println(answer);
//		int n = 987;
//		int answer = 0;
//		String a = n+"";
//		
//		for(int i = 0; i < a.length(); i++){
//			answer += Integer.parseInt(a.charAt(i)+"");
//		}
//		System.out.println(answer);
//		int n = 4;
//		long answer = 0;
//		
//		long a = (long)Math.pow(n,0.5);
//		long b = (long)Math.pow(a, 2);
//		
//		System.out.println(a);
//		System.out.println(b == n);
//		int[] arr = new int[10];
//		for(int i = 0; i < arr.length; i++){
//			arr[i] = (int)(Math.random() * 5 +1);
//		}
//		System.out.println(Arrays.toString(arr));
//		
//		int[]temp = new int[10];
//		int cnt = 0;
//		for(int i = 0; i < arr.length; i++){
//			boolean flag = false;
//			for(int j = 0; j < temp.length; j++){
//				if(arr[i] == temp[j]){
//					flag = true;
//				}
//			}
//			if(!flag){
//				temp[cnt++] = arr[i];
//			}
//		}
//		
//		int[] result = new int[cnt];
//		for(int i = 0; i < result.length; i++){
//			result[i] = temp[i];
//		}
//		
//		System.out.println(Arrays.toString(result));
//		
//		int[] numbers = {2,0,3,4,0};
//		int[] arr = new int[numbers.length * (numbers.length-1)];
//	
//		int k = 0;
//		
//		for(int i = 0; i < numbers.length; i++){
//			for(int j = 0; j < numbers.length; j++){
//				if(i != j){
//					arr[k++] = numbers[i] + numbers[j];
//				}
//			}
//		}
//					
//		
//		int[] temp = new int[arr.length];
//		int cnt = 0;
//		for(int m = 0; m < arr.length; m++){
//			boolean flag = false;
//			for(int n = 0; n < temp.length; n++){
//				if(arr[m] == temp[n]){
//					flag = true;
//				}
//			}
//			if(!flag){
//				temp[cnt++] = arr[m];
//			}
//		}
//		
//		
//		int[] answer = new int[cnt];
//		for(int n = 0; n < answer.length; n++){
//			answer[n] = temp[n];
//		}
//		Arrays.sort(answer);
//		System.out.println(Arrays.toString(arr));
//		System.out.println(Arrays.toString(temp));
//		System.out.println(Arrays.toString(answer));
//		int[] arr = {1,1,3,3,0,1,1};
//		int[] nArr = new int[arr.length];
//
//		for(int i = 0; i < arr.length-1; i++){
//			if(i == 0){
//				nArr[i] = arr[i];
//			}else if(arr[i] != arr[i+1]){
//				nArr[]
//			}
//		}
//		
////		System.out.println(v);
//		List<String> arr = new ArrayList<>();
//		arr.add("1");
//		arr.add("2");
//		Map<String, Object> map = new HashMap<>();
//		map.put("user", "1");
//		System.out.println(map.get("name"));
//		int[] arr = {4,3,2,1}; 
//		int[] answer = new int[arr.length == 1? 1: arr.length-1];
//		
//		int min = arr[0];
//		for (int i = 0; i < arr.length; i++) {
//			if(min > arr[i]){
//				min = arr[i];
//			}
//		}
//		
//		int cnt = 0;
//		for (int i = 0; i < arr.length; i++) {
//			if(arr[i] != min){
//				answer[cnt++] = arr[i];
//			}
//		}
//		System.out.println(min);
//		
//		System.out.println(Arrays.toString(answer));
//		String[] participant = {"leo", "kiki", "eden"};
//		String[] completion = {"eden","kiki"};
//		
//		Arrays.sort(participant);
//		Arrays.sort(completion);
//		
//		System.out.println(Arrays.toString(participant));
//		System.out.println(Arrays.toString(completion));
//		
//		String answer = "";
//		for (int i = 0; i < completion.length; i++) {
//			if(participant[i] != completion[i]){
//				answer = participant[i];
//			}
//		}
//		if("".equals(answer)){
//			answer = participant[participant.length-1];
//		}
//		System.out.println(answer);
//		
//		int[] answers = {1,2,3,4,5};
//        int[] a = {1,2,3,4,5};
//		int[] b = {2,1,2,3,2,4,2,5};
//		int[] c = {3,3,1,1,2,2,4,4,5,5};
//        ArrayList<Integer> answer = new ArrayList<>();
//		
//        int[] cnt = new int[3];
//        
//        for(int i = 0; i < answers.length; i++){
//				if(answers[i]==a[i%a.length]){
//					cnt[0]++;
//				}
//				if(answers[i]==b[i%b.length]){
//					cnt[1]++;
//				}
//				if(answers[i]==c[i%c.length]){
//					cnt[2]++;
//				}
//		}
//        int max = cnt[0];
//        for (int j = 0; j < cnt.length; j++) {
//			if(max < cnt[j]){
//				max = cnt[j];
//			}
//		}
//        for (int i = 0; i < cnt.length; i++) {
//			if(cnt[i] == max){
//				answer.add(i+1);
//			}
//		}
//        
//        System.out.println(Arrays.toString(cnt));
//        System.out.println(answer);
//		
//		int n = 10;
//		int answer = 0;
//		int[] lost = {3,9,10};
//		int[] reserve = {3,8,9};
//		
//		int[] arr = new int[n];
//		for (int i = 0; i < arr.length; i++) {
//			arr[i] = 1;
//		}
//		for (int i = 0; i < reserve.length; i++) {
//			arr[reserve[i]-1] = 2;
//		}
//		for (int i = 0; i < lost.length; i++) {
//			arr[lost[i]-1] -= 1;
//		}
//
//		System.out.println(Arrays.toString(arr));
//		for (int i = 0; i < arr.length-1; i++) {
//			if(arr[i] == 0){
//				if(i > 0){
//					if(arr[i-1] > 1){
//						arr[i] += 1;
//						arr[i-1] -= 1;
//					}else if(arr[i+1] > 1){
//						arr[i] += 1;
//						arr[i-1] -= 1;
//					}
//				}else{
//					if(arr[i+1] > 1){
//						arr[i] += 1;
//						arr[i-1] -= 1;
//					}
//				}
//			}
//		}
//		
//		for (int i = 0; i < arr.length; i++) {
//			if(arr[i] > 0){
//				answer += 1;
//			}
//		}
//		System.out.println(answer);
//		System.out.println(Arrays.toString(arr));
//		int[] arr = {1, 5, 2, 6, 3, 7, 4};
//		int[][] commands = {{2,5,3},{4,4,1},{1,7,3}};
//		int[] answer = new int[commands.length];
//		
//		for (int i = 0; i < commands.length; i++) {
//			ArrayList<Integer> arr2 = new ArrayList<>();	
//			for (int j = 0; j < arr.length; j++) {
//				arr2.add(arr[j]);
//			}
//			List<Integer> arr3 = new ArrayList<>();
//			arr3 = arr2.subList(commands[i][0]-1, commands[i][1]);
//			Collections.sort(arr3);
//			answer[i] = arr3.get(commands[i][2]-1);
//		}
//
//		System.out.println(Arrays.toString(answer));
//	int n = 125;
//	String re = "";
//	while(true){
//		if(n == 0){
//			break;
//		}
//		re += n % 3;
//		n /= 3;
//	}
//	int result = 0;
//	int r = 1;
//	for (int i = re.length()-1; i >= 0; i--) {
//		result += Integer.parseInt(re.charAt(i)+"") * r; 
//		r *= 3;	
//	}
//	System.out.println(result);
//	int[] a = {1,1,3,3,0,1,1};
//	List<Integer> arrL = new ArrayList<>();
//	for (int i = 0; i < a.length-1; i++) {
//		if(i == 0){
//			arrL.add(a[i]);
//		}else if(a[i] != a[i+1]){
//			arrL.add(a[i]);
//		}
//	}
//	System.out.println(arrL);

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
}
