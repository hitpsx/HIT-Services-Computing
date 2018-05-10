package db;

import java.sql.*;
import java.util.*;

import dto.*;
import java.util.ArrayList;
import java.util.List;

public class MySQL {
	 private final String driver = "com.mysql.jdbc.Driver";
		private final String url = "jdbc:mysql://localhost:3306/project";
		private final String user = "root";
		private final String password = "woaini123";
		
		/*private final String url = "jdbc:mysql://w.rdc.sae.sina.com.cn:3306/app_hitpsx";
		private final String user = "mxllm0zj55";
		private final String password = "z3im552ylhzxxkix3khyxiw5i125wlzk512ij4lm";
		*/
		private Connection con = null;
		private Statement stm = null;
		private ResultSet res = null;
		
		public MySQL() {
			try {
				Class.forName(driver).newInstance();
				con = DriverManager.getConnection(url, user, password);
			} catch(SQLException e) {
				e.printStackTrace();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		public int Number() {
			int p=0;
			try {
				stm = con.createStatement();
				String sql = String.format("SELECT count(*) number FROM user");
				res = stm.executeQuery(sql);
				if(res.next()) {
					p=res.getInt("number");
				}
				stm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return p;
		}
		
		public int equNumber() {
			int p=0;
			try {
				stm = con.createStatement();
				String sql = String.format("SELECT count(*) number FROM test3");
				res = stm.executeQuery(sql);
				if(res.next()) {
					p=res.getInt("number");
				}
				stm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return p+2;
		}
		
		public String userUnit(int userid) {
			String unit="";
			try {
				stm = con.createStatement();
				String sql = String.format("SELECT unit FROM user where userid = %d",userid);
				res = stm.executeQuery(sql);
				if(res.next()) {
					unit=res.getString("Unit");
				}
				stm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return unit;
		}
		
	public User userProfile(int id) {
			   User p=null;
			   try {
					stm = con.createStatement();
					String sql = String.format("SELECT * FROM user where userid = %d",id);
					res = stm.executeQuery(sql);
					if(res.next()) {
						p=new User();
						p.setUserid(res.getInt("userid"));
						p.setUsername(res.getString("Username"));
						p.setEmail(res.getString("Email"));
						p.setIDcard(res.getString("IDcard"));
						p.setPhone(res.getString("Phone"));
						p.setSex(res.getString("Sex"));
						p.setUnit(res.getString("Unit"));
					}
					stm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return p;
	  }
	public User userInformation(int id) {
		User user = null;
		try {
			stm = con.createStatement();
			String sql = String.format("SELECT * FROM user WHERE userid = %d;", id);
			res = stm.executeQuery(sql);
			if (res.next()) {
				user = new User();
				user.setUsername(res.getString("Username"));
				user.setUserid(res.getInt("Userid"));
				user.setSex(res.getString("Sex"));
				user.setUnit(res.getString("Unit"));
				user.setEmail(res.getString("Email"));
				user.setIDcard(res.getString("IDcard"));
				user.setPhone(res.getString("phone"));
			}
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	   public void userDeleteThing(int id) {
			try {
				stm = con.createStatement();						
				String sql= String.format("delete from test3 where EquNumber=%d",id);
				stm.executeUpdate(sql);
			  }catch (SQLException e) {
					e.printStackTrace();
				}

	   }
	   public List<Device> userSelectThing(String name) {
		   List<Device> returnList =new ArrayList<Device>();
		   try {
				stm = con.createStatement();
				String sql=String.format("SELECT * FROM test3 where concat(EquNumber,EquName,EquDate, EquSta, EquClass, "
						+ "EquUnit,  Supplier,"
						+ "Maintainer, PresentPosition, UnitPrice,"
						+ "extra) like  \"%%%s%%\"",name);
				res = stm.executeQuery(sql);
				while(res.next()) {
					Device Cp=new Device();					
					Cp.setEquNumber(res.getInt("EquNumber"));					
					Cp.setEquName(res.getString("EquName"));
					Cp.setEquDate(res.getString("EquDate"));					
					Cp.setEquSta(res.getString("EquSta"));
					Cp.setEquClass(res.getString("EquClass"));
					Cp.setEquUnit(res.getString("EquUnit"));
					Cp.setSupplier(res.getString("Supplier"));					
					Cp.setMaintainer(res.getString("Maintainer"));
					Cp.setPresentPosition(res.getString("PresentPosition"));
					Cp.setUnitPrice(res.getString("UnitPrice"));
					Cp.setExtra(res.getString("extra"));
					
					returnList.add(Cp);
				}
			stm.close();
		   }catch (SQLException e) {
				e.printStackTrace();
			}
			return returnList;
	   }
	   public Device userGetThing(int id) {
		   Device Cp=null;
			try {
				stm = con.createStatement();
				String sql = String.format("SELECT * FROM test3 WHERE EquNumber = %d ", id);
				res = stm.executeQuery(sql);
				if(res.next()) {
					Cp=new Device();
					
					
					Cp.setEquNumber(res.getInt("EquNumber"));
					Cp.setEquName(res.getString("EquName"));
					Cp.setEquDate(res.getString("EquDate"));
					
					Cp.setEquSta(res.getString("EquSta"));
					Cp.setEquClass(res.getString("EquClass"));
					Cp.setEquUnit(res.getString("EquUnit"));
					Cp.setSupplier(res.getString("Supplier"));
					Cp.setMaintainer(res.getString("Maintainer"));
					Cp.setPresentPosition(res.getString("PresentPosition"));
					Cp.setUnitPrice(res.getString("UnitPrice"));
					Cp.setExtra(res.getString("extra"));
					

				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return Cp;
	   }
	   public String userSelectThingById(int id) {
		   String returnList="";
		   String a="";
		   try {
				stm = con.createStatement();
				String sql=String.format("SELECT * FROM test3 where EquNumber = %d",id);
				res = stm.executeQuery(sql);
				if(res.next()) {
					a=String.valueOf(res.getInt("EquNumber"));
					returnList =a+"\t\t"+res.getString("EquName")+"\t\t"+res.getString("EquDate")+"\t\t"+res.getString("EquSta")+"\t\t"+res.getString("EquClass")+"\t\t"+
							       res.getString("EquUnit")+"\t\t"+res.getString("Supplier")+"\t\t"+res.getString("PresentPosition")+"\t\t"+
							       res.getString("Maintainer")+"\t\t"+res.getString("UnitPrice")+"\t\t"+res.getString("extra");
				}
				stm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return returnList;
	   }

	   public void addUser(User user) {
		   try {
				stm = con.createStatement();
				String sql = "INSERT INTO user (username,sex, email, userid,IDcard, unit,phone) VALUES " +
						String.format("(\"%s\",\"%s\",\"%s\",%d,\"%s\",\"%s\",\"%s\");"
								       ,user.getUsername(),user.getSex(),user.getEmail(),user.getUserid(),user.getIDcard(),user.getUnit(),user.getPhone());
				stm.executeUpdate(sql);
				stm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	   }
	   public void addEquipment(Device device) {
		   try {
				stm = con.createStatement();
				String sql = "INSERT INTO test3 (EquNumber,EquName,EquDate,EquSta,EquClass,EquUnit,supplier,PresentPosition,Maintainer,UnitPrice,extra) VALUES " +
						String.format("(%d,\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\");"
								       ,device.getEquNumber(),device.getEquName(),device.getEquDate(),device.getEquSta(),device.getEquClass()
								       ,device.getEquUnit(),device.getSupplier(),device.getPresentPosition(),device.getMaintainer(),device.getUnitPrice()
								       ,device.getExtra());
				stm.executeUpdate(sql);
				stm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	   }
//	   public void addEquipment(int id,String[] lis) {
//		   try {
//				stm = con.createStatement();
//				String sql = "INSERT INTO test3 (EquNumber,EquName,EquDate,EquSta,EquClass,EquUnit,supplier,PresentPosition,Maintainer,UnitPrice,extra) VALUES " +
//						String.format("(%d,\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\");"
//								       ,id,lis[0],lis[1],lis[2],id,lis[3],lis[4],lis[5],lis[6],lis[7],lis[8],lis[9]);
//				stm.executeUpdate(sql);
//				stm.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//	   }
	   public void userUpdateDevice(Device device) {
		   try {
				stm=con.createStatement();
				String sql=String.format("update test3 set EquName='%s',EquDate='%s',EquSta='%s',EquClass='%s',EquUnit='%s',supplier='%s',PresentPosition='%s',Maintainer='%s',UnitPrice='%s',extra='%s' where EquNumber=%d"
										,device.getEquName(),device.getEquDate(),device.getEquSta(),device.getEquClass()
										,device.getEquUnit(),device.getSupplier(),device.getPresentPosition(),device.getMaintainer()
										,device.getUnitPrice(),device.getExtra(),device.getEquNumber());
				stm.executeUpdate(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
	   }
	   public void close() {
			try {
				if (con != null) con.close();
				if (stm != null) stm.close();
				if (res != null) res.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
}
