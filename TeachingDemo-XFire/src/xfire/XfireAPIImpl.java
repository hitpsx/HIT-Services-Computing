package xfire;

import java.sql.SQLException;
import java.util.Vector;

import db.DbHandler;
//Generated by MyEclipse
import com.sql.MySQL;

public class XfireAPIImpl implements IXfireAPI {
	
	public String getUsers(String name, String cardNum) {
		DbHandler db = new DbHandler();
		String result = "";
		try {
			result = db.getUsers(name, cardNum);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public int Number() {
		MySQL sql=new MySQL();
		int a=0;
		a = sql.Number();
		return a;
	}
	
	public String userUnit(int id) {
		MySQL sql=new MySQL();
		String result="";
		result = sql.userUnit(id);
		return result;
	}
	
	public String[] userProfile(int id) {
		MySQL sql=new MySQL();
		String [] returnList=null;
		returnList=sql.userProfile(id);
		return returnList;
	}
	 public String[] userSelectThingFuzzy(String name) {
		 MySQL sql=new MySQL();
		 String[] returnList = sql.userSelectThing(name);
		 return returnList;
	 }
	 
	 public String userSelectThingAccurate(int id){
		 MySQL sql=new MySQL();
		 String returnList = sql.userSelectThingById(id);
		 return returnList;
	 }
	 
	 public void userDeleteThing(int id) {
		 MySQL sql=new MySQL();
		 sql.userDeleteThing(id);
	 }
	 public int userAdd(String[] lis) {
		 MySQL sql=new MySQL();
		 int id=sql.Number();
		 sql.addUser(id,lis);
		 return id;
	 }
	 public void userAddEquipment(String[] lis) {
		 MySQL sql=new MySQL();
		 int equNumber=sql.equNumber();
		 sql.addEquipment(equNumber,lis);
	 }
	 public void userUpdate(int id,String[] lis) {
		 MySQL sql=new MySQL();
		 sql.updateEquipment(id,lis);
	 }
}