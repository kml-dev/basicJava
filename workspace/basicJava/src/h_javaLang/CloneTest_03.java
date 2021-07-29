package h_javaLang;

public class CloneTest_03 {
	public static void main(String[] args) {
		Point p1 = new Point(100, 100);
		
		Circle c = new Circle(p1, 50);
		
		System.out.println(c);
		
		Circle cCopy = c.deepCopy();
		System.out.println(cCopy);
		
		c.r = 300;
		c.p.x = 1000;
		
		System.out.println(c);
		System.out.println(cCopy);
	}
}

class Circle implements Cloneable{
	Point p;
	int r;
	
	Circle(Point p, int r){
		this.p = p;
		this.r = r;
	}

	@Override
	public String toString() {
		return "Circle [p = " + p + ", r = " + r + "]";
	}

	protected Circle shallowCopy(){
		Circle c = null;
		
		try {
			c = (Circle)super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		return c;
	}
	
	protected Circle deepCopy(){
		Circle c = null;
		try {
			c = (Circle)super.clone();			
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		Point p = new Point(c.p.x, c.p.y);
		c.p = p;
		
		return c;
	}
	
}