public class TechnicalEmployee extends Employee {//AAA

	public TechnicalEmployee (int ID, String fName, int age, char gender, char shirtSize){
		super(ID,fName,age,gender,shirtSize);
	}
	
	public void technicalService (ElectricScooter es){
		if (es instanceof QuickElectricScooter){
			System.out.println("Thank you for coming to us");
			System.out.println(es.model);
			System.out.println(es.maxSpeed);
			System.out.println("Hope not to see you again");
		}
		else{
			System.out.println(es.model);
			System.out.println(es.maxSpeed);
		}
	}
	
	public int getBonus(){
		if(this.shirtSize == 's'){
			return 30;
		}
		if(this.shirtSize == 'm'){
			return 35;
		}
		if(this.shirtSize == 'l'){
			return 35;
		}
		if(this.shirtSize == 'x'){
			return 40;
		}
	}
	
	public boolean update(){
		
	}
	
}