package h_javaLang;

public class EqualsTest_02 {
	public static void main(String[] args) {
		Person p1 = new Person(9409271392318L);
		Person p2 = new Person(9409271392318L);
		Value v1 = new Value(3);
		
		System.out.println(v1);
		System.out.println(v1.hashCode());
		System.out.println(p1 == p2);
		System.out.println(p1.equals(p2));
	}
}

class Person{
	long id;
	
	public Person(long id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		// 1. 인자값 null
		// 2. 인자값이  Person의 객체인지 확인
		if(obj != null && obj instanceof Person){
			Person p = (Person)obj;
			result = id == p.id;				
		}
		return result;
		
	}
	
}