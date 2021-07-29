package f_oop2;

public class TimeTest {
	public static void main(String[] args) {
		TimeVO t = new TimeVO();
		
		// 시간 6
		t.setHour(6);
		// 분 356  => 11:56
		t.setMinute(356);
		// 초 7200 + 60 + 53 => 7313 => 13 : 57 : 53
		t.setSeconds(7313);
		
		int hour = t.getHour();
		int minute = t.getMinute();
		int seconds = t.getSeconds();
		
		System.out.println(hour + " : " + minute + " : " + seconds);
		
		TimeVO t2 = new TimeVO();
		// 시간 22
		t2.setHour(22);
		// 분 1434 => 21 : 54
		t2.setMinute(1434);
		// 초 10800 + 600 + 23 => 11423 => 1 : 4 : 23
		t2.setSeconds(11423);
	
		int hour2 = t2.getHour();
		int minute2 = t2.getMinute();
		int seconds2 = t2.getSeconds();
		
		System.out.println(hour2 + " : " + minute2 + " : " + seconds2);
		
	}
}

class TimeVO{
	private int hour;
	private int minute;
	private int seconds;
	
	void setHour(int hour){            
		setSeconds(hour * 3600);	   
	}
	
	int getHour(){					   
		return hour;
	}
	
	void setMinute(int minute){       
		setSeconds(minute * 60);     
	}
	
	int getMinute(){
		return minute;
	}
	
	void setSeconds(int seconds){      	   
		this.seconds += seconds;		   
		this.hour = this.seconds / 3600 % 24;   
		this.minute = this.seconds / 60 % 60; 
	}
	
	int getSeconds(){
		return seconds % 60;
	}
}