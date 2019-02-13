package testData;

import java.util.Date;

public class BodyActivities {

	int ID;
	String Title;
	Date Duedate;
	Boolean Completed;

	public BodyActivities(int ID, String Title, Date DueDate, Boolean Completed) {
		this.ID = ID;
		this.Title = Title;
		this.Duedate = DueDate;
		this.Completed = Completed;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public Date getDuedate() {
		return Duedate;
	}

	public void setDuedate(Date duedate) {
		Duedate = duedate;
	}

	public Boolean getCompleted() {
		return Completed;
	}

	public void setCompleted(Boolean completed) {
		Completed = completed;
	}

}
