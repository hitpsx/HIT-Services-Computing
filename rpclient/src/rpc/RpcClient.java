package rpc;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;
import org.apache.xmlrpc.*;


public class RpcClient {
	
	
	public void hello() {
		try {
			XmlRpc.setDriver("org.apache.xerces.parsers.SAXParser");
			XmlRpcClient client = new XmlRpcClient("http://localhost:9090/rpctest/user");
			Vector params = new Vector();
			params.addElement("zheng".getBytes());
			byte[] result = (byte[]) client.execute("user.hello",params);
			System.out.println(new String(result));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	public void getNumber() {
		try {
			XmlRpc.setDriver("org.apache.xerces.parsers.SAXParser");
			XmlRpcClient client = new XmlRpcClient("http://localhost:9090/rpctest/user");
			
			Vector<Integer> params = new Vector<Integer>();
			params.addElement(13);
			
			String temp = String.valueOf(client.execute("user.Number",params));
			System.out.println(temp);
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	 public void profile() {
	    	System.out.println("Please input the id:");
			Scanner scan = new Scanner(System.in);
		    int id = scan.nextInt();
		    
		    try {
				XmlRpc.setDriver("org.apache.xerces.parsers.SAXParser");
				XmlRpcClient client = new XmlRpcClient("http://localhost:9090/rpctest/user");
				
				Vector<Integer> params=new Vector<Integer>();
				params.add(id);
				
				Vector<String> a=(Vector<String>)client.execute("user.userProfile",params);
				
				System.out.println("Name\t"+"Sex\t"+"Unit\t"+"Email\t\t"+"IDcard\t"+"Phone");
				
				for(int i=0;i<a.size();i++) {
					System.out.print(a.get(i)+"\t");
				}
				System.out.println();
				} catch (Exception e) {
					e.printStackTrace();
			}

	    	
	}
	
   public void queryThingFuzzy() {
	    Scanner scan = new Scanner(System.in);
	    String name = scan.nextLine();
	    try {
			XmlRpc.setDriver("org.apache.xerces.parsers.SAXParser");
			XmlRpcClient client = new XmlRpcClient("http://localhost:9090/rpctest/user");
			
	        //String[] returnList=service.userSelectThingFuzzy(name);
			Vector<String> params=new Vector<String>();
			params.addElement(name);
			
			Vector<String> a=(Vector<String>)client.execute("user.userSelectThingFuzzy",params);
		    System.out.println("Number\t\t"+"Name\t\t"+"Date\t\t\t"+"Sta\t\t"+"Class\t\t"+"EquUnit\t\t"+"Position\t\t"+"Supplier\t\t"+"Maintainer\t"
	                +"UnitPrice\t"+"Extra");

			for(int i=0;i<a.size();i++) {
				System.out.println(a.get(i)+"\t");
			 }
			 System.out.println();
			 
			 } catch (Exception e) {
					e.printStackTrace();
		     }
    }
   
   public void queryThingAccurate() {
		Scanner scan = new Scanner(System.in);
	    int id = scan.nextInt();
	    try {
			XmlRpc.setDriver("org.apache.xerces.parsers.SAXParser");
			XmlRpcClient client = new XmlRpcClient("http://localhost:9090/rpctest/user");
			
	        //String[] returnList=service.userSelectThingFuzzy(name);
			Vector<Integer> params = new Vector<Integer>();
			params.addElement(id);
			
			String a=(String)client.execute("user.userSelectThingAccurate",params);
		    System.out.println("Number\t\t"+"Name\t\t"+"Date\t\t\t"+"Sta\t\t"+"Class\t\t\t"+"EquUnit\t\t"+"Position\t\t"+"Supplier\t\t"+"Maintainer\t"
	                +"UnitPrice\t"+"Extra");
		    
			 System.out.println(a);
			 
			 } catch (Exception e) {
					e.printStackTrace();
		 }
   }
   public void deleteThing() {
		System.out.println("Please input the id:");
		Scanner scan = new Scanner(System.in);
	    int choice = scan.nextInt();
	    try {
			XmlRpc.setDriver("org.apache.xerces.parsers.SAXParser");
			XmlRpcClient client = new XmlRpcClient("http://localhost:9090/rpctest/user");
			
	        //String[] returnList=service.userSelectThingFuzzy(name);
			Vector<Integer> params = new Vector<Integer>();
			params.addElement(choice);
			
			 String type=(String)client.execute("user.userDeleteThing",params);
			
			 System.out.println("ok");
			 
			 } catch (Exception e) {
					e.printStackTrace();
		 }
	}
	public void addUser() {
			System.out.println("Please input the order by uername,sex,email,idcard,unit,phone");
			
			try {
				XmlRpc.setDriver("org.apache.xerces.parsers.SAXParser");
				XmlRpcClient client = new XmlRpcClient("http://localhost:9090/rpctest/user");
				
				Vector<String> params = new Vector<String>();
				String temp="";
				for(int i=0;i<6;i++)
				{
					Scanner scan = new Scanner(System.in);
					temp+=scan.nextLine()+"\t";
				}
				params.add(temp);
				 int type=(Integer)client.execute("user.userAdd",params);
				
				 System.out.println(type);
				 
				 } catch (Exception e) {
						e.printStackTrace();
			 }
				 
	}
public void updateThing(RpcClient myClient) {
		
		Scanner scan = new Scanner(System.in);
	    int id = scan.nextInt();
	    
	    try {
			XmlRpc.setDriver("org.apache.xerces.parsers.SAXParser");
			XmlRpcClient client = new XmlRpcClient("http://localhost:9090/rpctest/user");
			
	        //String[] returnList=service.userSelectThingFuzzy(name);
			Vector<Integer> params = new Vector<Integer>();
			params.addElement(id);
			
			String returnList=(String)client.execute("user.userSelectThingAccurate",params);
		    System.out.println("Number\t\t"+"Name\t\t"+"Date\t\t\t"+"Sta\t\t"+"Class\t\t\t"+"EquUnit\t\t"+"Position\t\t"+"Supplier\t\t"+"Maintainer\t"
	                +"UnitPrice\t"+"Extra");
		    
			System.out.println(returnList);
			 
			String[] name={"Number","Name","Date","Sta","Class","EquUnit","Position","Supplier","Maintainer","UnitPrice","Extra"};
				String[] changList=returnList.split("\t\t");
				for(int i=1;i<=10;i++) {
					System.out.println("Would you chang it? "+name[i]+" = "+changList[i]);
					Scanner tmp = new Scanner(System.in);
				    String choice = tmp.nextLine();
				    if(choice.equals("Yes")) {
				    	Scanner tmp2 = new Scanner(System.in);
					    String change = tmp2.nextLine();
					    changList[i]=change;
				    }
				}
			String lis="";
			for(int i=0;i<=10;i++) {
				lis+=changList[i]+"\t";
			}
			
			Vector<String> params2 = new Vector<String>();
			params2.add(lis);
			
			String returnLis=(String)client.execute("user.userUpdate",params2);

			System.out.println("Update over"+"\n");
			
		    returnList=(String)client.execute("user.userSelectThingAccurate",params);
		    System.out.println("Number\t\t"+"Name\t\t"+"Date\t\t\t"+"Sta\t\t"+"Class\t\t\t"+"EquUnit\t\t"+"Position\t\t"+"Supplier\t\t"+"Maintainer\t"
	                +"UnitPrice\t"+"Extra");
		    
			System.out.println(returnList);
				
			 } catch (Exception e) {
					e.printStackTrace();
		 }
	    

		
	}

	public void addEquipment() {
		System.out.println("Please input the order by EquName,Date,Sta,EquClass,EquUnit,supplier,Position,Maintainer,UnitPrice,extra");
		
		try {
			XmlRpc.setDriver("org.apache.xerces.parsers.SAXParser");
			XmlRpcClient client = new XmlRpcClient("http://localhost:9090/rpctest/user");
			
			Vector<String> params = new Vector<String>();
			String temp="";
			for(int i=0;i<10;i++)
			{
				Scanner scan = new Scanner(System.in);
				temp+=scan.nextLine()+"\t";
			}
			params.add(temp);
			String type=(String)client.execute("user.userAddEquipment",params);
			
			System.out.println(type);
			 
			 } catch (Exception e) {
					e.printStackTrace();
		 }
	}
	
	public static void mean( RpcClient myClient) {
		 System.out.println("Welcome to the scientific research equipment management interface");
	        while(true)
	        {
	        	System.out.println("Please choice the function:");
	        	System.out.println("1.Inquire of personal information");
	        	System.out.println("2.Query equipment fuzzylly");
	        	System.out.println("3.Query equipment accuratelly");
	        	System.out.println("4.Delete the equipment by id");
	        	System.out.println("5.Add the user");
	        	System.out.println("6.Update the information");
	        	System.out.println("7.Add the equipment");
	        	Scanner scan = new Scanner(System.in);
	    	    int choice = scan.nextInt();
	    	    switch (choice)
	    	    {
	    	    	case 1:myClient.profile();break;
	    	    	case 2:myClient.queryThingFuzzy();break;
	    	    	case 3:myClient.queryThingAccurate();break;
	    	    	case 4:myClient.deleteThing();break;
	    	    	case 5:myClient.addUser();break;
	    	    	case 6:myClient.updateThing(myClient);break;
	    	        case 7:myClient.addEquipment();break;
	    	    	default:break;
	    	    
	    	    }
	        }
	}
	
	public static void main(String[] args) {
	    RpcClient myClient=new RpcClient();
	    mean(myClient);
	}
}