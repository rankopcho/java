
public class ElectricScooter implements Comparable {
	
	int serialNumber;
	int price;
	String model;
	int maxSpeed;

	public ElectricScooter (int serialNumber, int price, String model, int maxSpeed){
		this.serialNumber = serialNumber;
		this.price = price;
		this.model = model;
		this.maxSpeed = maxSpeed;
	}
	
	public int getPrice(){
		return this.price;
	}
	
	public int compareTo(Object other){
		if (this.price == ((ElectricScooter)other).getPrice())
			return 0;
		if (this.price < ((ElectricScooter)other).getPrice())
			return -1;
		return 1;
		}
}
