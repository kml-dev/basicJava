package j_collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayList_01 {
	public static void main(String[] args) {
//		List<Integer> list1 = new ArrayList<>();
//		list1.add(new Integer(5));
//		list1.add(new Integer(2));
//		list1.add(new Integer(3));
//		list1.add(1);
//		list1.add(4);
//		
//		List<Integer> list2 = new ArrayList<>(list1.subList(1, 3));
//		
//		System.out.println(list1);
//		System.out.println(list2);
//		
//		System.out.println(list1.containsAll(list2));
//		
//		list1.add(1, 50);
//		System.out.println(list1);
//		list1.add(6, 90);
//		System.out.println(list1);
//		
//		Integer i1 = list1.remove(2);
//		System.out.println(i1);
//		System.out.println(list1);
//		
//		System.out.println(list1.set(2, 900));
//		System.out.println(list1);
//		
//		// collection에서는 정렬을 지원해준다.
//		Collections.sort(list1);
//		System.out.println(list1);
		
		List<Integer> list1 = new ArrayList<>();
		// boolean list1.add(e) : generic타입의 요소를 리스트에 추가하고 true를 리턴
		list1.add(1);
		list1.add(2);
		list1.add(3);
		System.out.println(list1);
		System.out.println("==========================");
		
		list1.add(1, 3);           // .add(index, e) : index위치에 요소를 추가
		System.out.println(list1);
		System.out.println("==========================");
		
		
		List<Integer> list2 = new ArrayList<>();
		list2.add(1);
		list2.add(2);
		list2.add(3);
		System.out.println(list1.contains(list2));     // 이 객체를 포함하고 있으면 true 리턴
		System.out.println("==========================");
		System.out.println(list1.containsAll(list2));  // 객체의 요소를 포함하고 있으면 true 리턴
		System.out.println("==========================");
		System.out.println(list1.remove(0));           // 인데스 위치의 값을 삭제후 요소를 리턴
		System.out.println(list1);
		System.out.println("==========================");
		
		
		// Integer list1.get(0) : index에 해당하는 요소를 리턴
		System.out.println(list1.get(0));
		System.out.println("==========================");
		
		Collections.sort(list1);
		System.out.println(list1);
		
		
		
	}
}
