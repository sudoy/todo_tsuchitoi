package todo.beans;


public class EntryForm {
	private String id;
	private String title;
	private String detail;
	private int importance;
	private String limitDate;
	public EntryForm(String id, String title, String detail, int importance, String limitDate) {
		super();
		this.id = id;
		this.title = title;
		this.detail = detail;
		this.importance = importance;
		this.limitDate = limitDate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public int getImportance() {
		return importance;
	}
	public void setImportance(int importance) {
		this.importance = importance;
	}
	public String getLimitDate() {
		return limitDate;
	}
	public void setLimitDate(String limitDate) {
		this.limitDate = limitDate;
	}



}
