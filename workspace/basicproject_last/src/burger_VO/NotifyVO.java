package burger_VO;

public class NotifyVO {
	private int seq;
	private String title;
	private String contents;
	private String date;
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	// 정보 출력용 toString()
	@Override
	public String toString() {
		return  "[제목] " + title + "\n"
				+ "──────────────────────────\n"
			    + "[날짜] " + date +"\n"
			    + "──────────────────────────\n"
			    + "[내용]\n" + contents +"\n"
		        + "──────────────────────────\n";
		
	}
	
	
}
