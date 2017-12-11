public class QuickElectricScooter extends ElectricScooter {

	double appVersion;
	
	public QuickElectricScooter (int serialNumber, int price, String model, int maxSpeed, double appVersion){
		super(serialNumber, price, model, maxSpeed);
		this.appVersion = appVersion;
		
	}
	public int compareTo(ElectricScooter other){
		if(this.price>other.price){
			return 1;
		}
		if(this.price==other.price){
			return 0;
		}
		else{
			return -1;
		}
	}
	
	public boolean update(){
		if(Company.getPopular instanceof QuickElectricScooter){
			return true;
		}
		return false;
	}
}