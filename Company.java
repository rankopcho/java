import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;

public class Company {
	
	public static ArrayList<ElectricScooter> eScooters = new ArrayList<ElectricScooter>();
	public static ArrayList<QuickElectricScooter> qScooters = new ArrayList<QuickElectricScooter>();
	public static ArrayList<SalesEmployee> sEmployees = new ArrayList<SalesEmployee>();
	public static ArrayList<TechnicalEmployee> tEmployees = new ArrayList<TechnicalEmployee>();
	public static ArrayList<Customer> customers = new ArrayList<Customer>();
	public static ArrayList<ServiceCall> sCalls = new ArrayList<ServiceCall>();


	public Company (String ES, String Customers, String Employees, String SC){

		String str = readFromFile(ES); // מאתחל את מערך הסקוטרים
		String[]  esTemp = str.split("[\\r\\n]+"); 
		String[] line;
		for(int i=1; i<esTemp.length; i++){
			line = esTemp[i].split("\\t");
			if(line.length==4){
				ElectricScooter es = new ElectricScooter(Integer.parseInt(line[0]), Integer.parseInt(line[1]),line[2], Integer.parseInt(line[3]));
				eScooters.add(0, es);;
			}
			else{
				QuickElectricScooter qes= new QuickElectricScooter(Integer.parseInt(line[0]), Integer.parseInt(line[1]), line[2], Integer.parseInt(line[3]), Double.parseDouble(line[4]));
				qScooters.add(0, qes);
			}
		}
		str = readFromFile(Employees); // מאתחל את מערך העובדים
		String[] EmployeesTemp = str.split("[\\r\\n]+");
		for(int i=1; i<EmployeesTemp.length; i++){
			try{
				line = EmployeesTemp[i].split("\\t");
				if(line[1].equals("Sales")){
					SalesEmployee se = new SalesEmployee(Integer.parseInt(line[0]),line[2], Integer.parseInt(line[3]),line[4].charAt(0),line[6].charAt(0),Double.parseDouble(line[5]));
					sEmployees.add(se);
				}
				else if(line[1].equals("Technical")){
					TechnicalEmployee se = new TechnicalEmployee(Integer.parseInt(line[0]),line[2], Integer.parseInt(line[3])    ,line[4].charAt(0),line[6].charAt(0));
					tEmployees.add(se);
				}
				System.out.println(tEmployees.get(i-1).getCommRate());
			}
			
			catch(ImpossibleShirtSizeExeption e){
				System.out.println("Ilegal Shirt Size!!");
			}
			catch(ImpossibleGenderException e){
				System.out.println(e.getMessage());
			}
			catch(IOException e){
				System.out.println(e.getMessage());
			}
		}
		str = readFromFile(Customers); // מאתחל את מערך העובדים
		String[] CustomersTemp = str.split("[\\r\\n]+");
		for(int i=1; i<CustomersTemp.length; i++){
			ElectricScooter Es ;	
			try{
				line = CustomersTemp[i].split("\\t");
				if(line[6] ==null){
					Customer c = new Customer(Integer.parseInt(line[0]), line[1], Integer.parseInt(line[2]),line[3].charAt(0),(Integer.parseInt(line[4])==1) ,(Integer.parseInt(line[5])==1));
					c.setRegister(true);
					customers.add(c);
				}
				
				else{
					Es = new ElectricScooter(Integer.parseInt(line[6]));
					Customer c = new Customer(Integer.parseInt(line[0]), line[1], Integer.parseInt(line[2]),line[3].charAt(0),(Integer.parseInt(line[4])==1) ,(Integer.parseInt(line[5])==1),Es);
					c.setRegister(true);
					customers.add(c);
				}	
			}
			catch(IOException e){
				System.out.println("Gender is Ilegal!");
			}
		}
		
		
		str = readFromFile(SC); // מאתחל את מערך השיחות שירות
		String[] SCTemp = str.split("[\\r\\n]+");
		for(int i=1; i<SCTemp.length; i++){	
			try{
				line = SCTemp[i].split("\\t");
				
					ServiceCall sc = new ServiceCall(findCustomerById(Integer.parseInt(line[0])), findEmployeeByID(Integer.parseInt(line[1])),line[2], findCustomerById(Integer.parseInt(line[0])).getScooter());
					sCalls.add(sc);		
				}
			
				catch (IOException e){
					System.out.println("Couldn't read file"); 
				}
		
			}

		}

		@SuppressWarnings("resource")
		public static String readFromFile(String File){
			BufferedReader br;
			try{
				br = new BufferedReader(new FileReader(File + ".txt"));
				StringBuilder sb = new StringBuilder();
				String line = br.readLine();
				while(line != null){
					sb.append(line);
					sb.append(System.lineSeparator());
					line = br.readLine();
				}
				String everything = sb.toString();
				return everything;
			}
			catch (IOException e){
				System.out.println("Couldn't read file");
				return null;
			}

		}
	
	public static getPopular(){
		
	}

}