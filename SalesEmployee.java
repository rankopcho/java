public class SalesEmployee extends Employee {//akbu
	
	double commRate;
	
	public SalesEmployee (int ID, String fName,int age, char gender, char shirtSize, double commRate){
		super(ID,fName,age,gender,shirtSize);
		this.commRate = commRate;
	}
	
	public static ElectricScooter sellScooter(ElectricScooter es){
		int min = Integer.MAX_VALUE;
		int index=0;
		if (es instanceof QuickElectricScooter){
			if(!Company.qScooters.isEmpty()){
				for(int i=0;i<Company.qScooters.size();i++){
					if(Company.qScooters.get(i).price<min){
						min = Company.qScooters.get(i).price;
						index = i;
					}
				}
				return Company.qScooters.get(index);
			}
			return null;
		}
		else{
			if(!Company.eScooters.isEmpty()){
				for(int i=0;i<Company.eScooters.size();i++){
					if(Company.eScooters.get(i).price<min){
						min = Company.eScooters.get(i).price;
						index = i;
					}
				}
				return Company.eScooters.get(index);
			}
			return null;
		}
	}
	
	public static ElectricScooter sellScooter(){
		int minimunQuickElectricScooter = Integer.MAX_VALUE;
		int minimunElectricScooter = Integer.MAX_VALUE;
		int quickIndex=0;
		int regularIndex=0;
		if(!Company.qScooters.isEmpty()){
			for(int i=0;i<Company.qScooters.size();i++){
				if(Company.qScooters.get(i).price<minimunQuickElectricScooter){
					minimunQuickElectricScooter = Company.qScooters.get(i).price;
					quickIndex=i;
				}
			}
		}
		if(!Company.eScooters.isEmpty()){
			for(int i=0;i<Company.eScooters.size();i++){
				if(Company.eScooters.get(i).price<minimunElectricScooter){
					minimunElectricScooter = Company.eScooters.get(i).price;
					regularIndex=i;
				}
			}
		}
		if(minimunQuickElectricScooter>=minimunElectricScooter){
			return Company.qScooters.get(quickIndex);
		}
		else{
			return Company.eScooters.get(regularIndex);
		}
	}
	
	public int getBonus(){
		if(this.shirtSize == 's'){
			return 10;
		}
		else if(this.shirtSize == 'm'){
			return 15;
		}
		else if(this.shirtSize == 'l'){
			return 20;
		}
		else{
			return 25;
		}
	}
	
	public boolean update(){
	}
	
}