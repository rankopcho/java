abstract public class Employee implements Updateable{
	
	int ID;
	String fName;
	int age;
	char gender;
	char shirtSize;
	
	public Employee (int ID, String fName, int age, char gender, char shirtSize) throws ImpossibleGenderException{
		this.ID = ID;
		this.fName = fName;
		this.age = age;
		if(gender =='m' || gender=='f' || gender=='u' ){
			this.gender = gender;
		}
		else{
			throw new ImpossibleGenderException();
		}
		this.shirtSize = shirtSize;
	}
	
	abstract public boolean update();
	abstract public int getBonus();

}