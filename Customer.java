public class Customer implements Comparable<Customer> {
	
	int ID;
	String fname;
	int age;
	char gender;
	boolean helmet;
	boolean lock;
	ElectricScooter scooter;
	private int benefit = 30;
	
	public Customer (int ID, String fname,int age,char gender, boolean helmet, boolean lock) throws ImpossibleGenderException{
		this.ID = ID;
		this.fname = fname;
		this.age = age;
		if(gender =='m' || gender=='f' || gender=='u' ){
			this.gender = gender;
		}
		else{
			throw new ImpossibleGenderException();
		}
		this.helmet = helmet;
		this.lock = lock;
	}
	
	public Customer (int ID, String fname, int age, boolean helmet, boolean lock, ElectricScooter scooter){
		this.ID = ID;
		this.fname = fname;
		this.age = age;
		this.helmet = helmet;
		this.lock = lock;
		this.scooter = scooter;
		//if(scooter==null){
			//ServiceCall newES = new ServiceCall (this.Cutomer,e,serviceType,es);
			//this.scooter = SalesEmployee.sellScooter();
		//}
	}
	
	public void updateBenefit(ServiceCall sc){
		if(sc.e instanceof SalesEmployee){
			benefit = benefit+this.scooter.price;
		}
		if(sc.e instanceof TechnicalEmployee){
			double random = Math.random();
			if(random<0.3){
				benefit = benefit+10;
			}
			if(random>=0.3 && random<0.5){
				benefit = benefit+30;
			}
			if(random>=0.5 && random<0.9){
				benefit = benefit+80;
			}
			if(random>=0.9){
				benefit = benefit+120;
			}
		}
	}
	
	public int getBenefit(){
		return benefit;
	}
	
	public int compareTo(Customer other){
		if(this.benefit>other.benefit){
			return 1;
		}
		if(this.benefit==other.benefit){
			return 0;
		}
		else{
			return -1;
		}
	}
	
	public int compareByMaxSpeed(Customer other){
		if(this.scooter.maxSpeed>other.scooter.maxSpeed){
			return 1;
		}
		else if(this.scooter.maxSpeed==other.scooter.maxSpeed){
			return 0;
		}
		else{
			return -1;
		}
	}
}