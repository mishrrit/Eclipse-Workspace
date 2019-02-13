package restApi;

import java.util.Date;

public class Activities {
	
	public int Id;
	public String Title;
	public Date DueDate;
	public boolean Completed;
	
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public Date getDueDate() {
		return DueDate;
	}
	public void setDueDate(Date dueDate) {
		DueDate = dueDate;
	}
	public boolean isCompleted() {
		return Completed;
	}
	public void setCompleted(boolean completed) {
		Completed = completed;
	}
	

}
