package burger_VO;

public class UserVO {
	private String id;
	private String pw;
	private String name;
	private int point;
	private int cash;
	private boolean isActivate = true;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public int getCash() {
		return cash;
	}
	public void setCash(int cash) {
		this.cash = cash;
	}
	public boolean isActivate() {
		return isActivate;
	}
	public void setActivate(boolean isActivate) {
		this.isActivate = isActivate;
	}
	@Override
	public String toString() {
		String status = "탈퇴";
		if(isActivate() == true){
			status = "활성화";
		}
		return "[회원 id :" + id + "]\n"
				+ "이름 : " + name + "\n"
				+ "보유 포인트 : " + point + "\n"
				+ "보유 금액 : " + cash + "\n"
				+ "회원 상태 :"+ status;
	}
	
	
}
