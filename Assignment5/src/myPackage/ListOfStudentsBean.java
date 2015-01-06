package myPackage;


public class ListOfStudentsBean {
	
	private String[] listOfStudents;
	private int numberofstudents;

	
	public ListOfStudentsBean(String[] list, int numberofstudents){
		this.listOfStudents = new String[50];
		for (int i=0;i<numberofstudents; i++){
		   this.listOfStudents[i] = list[i];
		}
		this.numberofstudents = numberofstudents;
	}
	
	public int getNumberofstudents() {
		return numberofstudents;
	}

	public void setNumberofstudents(int numberofstudents) {
		this.numberofstudents = numberofstudents;
	}

	
	public String[] getListOfStudents() {
		return listOfStudents;
	}

	public void setListOfStudents(String[] listOfStudents) {
		this.listOfStudents = listOfStudents;
	}

}
