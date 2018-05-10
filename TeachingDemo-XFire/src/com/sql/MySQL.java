package com.sql;

import java.sql.*;
import java.util.*;


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
			return p;
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
		
	   public String[] userProfile(int id) {
		   String[] returnList =new String[6];
		   int i=0;
		   try {
				stm = con.createStatement();
				String sql = String.format("SELECT * FROM user where userid = %d",id);
				res = stm.executeQuery(sql);
				if(res.next()) {
					returnList[i++]=res.getString("username");
					returnList[i++]=res.getString("Sex");
					returnList[i++]=res.getString("Unit");
					returnList[i++]=res.getString("Email");
					returnList[i++]=res.getString("IDcard");
					returnList[i++]=res.getString("phone");
				}
				stm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return returnList;
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
	   public String[] userSelectThing(String name) {
		   String[] returnList = new String[10];
		   String a="";
		   int i=0;
		   try {
				stm = con.createStatement();
				String sql=String.format("SELECT * FROM test3 where concat(EquNumber,EquName,EquDate, EquSta, EquClass, "
						+ "EquUnit,  Supplier,"
						+ "Maintainer, PresentPosition, UnitPrice,"
						+ "extra) like  \"%%%s%%\"",name);
				res = stm.executeQuery(sql);
				while(res.next()) {
					a=String.valueOf(res.getInt("EquNumber"));
					returnList[i++] =a+"\t\t"+res.getString("EquName")+"\t\t"+res.getString("EquDate")+"\t\t"+res.getString("EquSta")+"\t\t"+res.getString("EquClass")+"\t\t"+
							       res.getString("EquUnit")+"\t\t"+res.getString("Supplier")+"\t\t"+res.getString("PresentPosition")+"\t\t"+
							       res.getString("Maintainer")+"\t\t"+res.getString("UnitPrice")+"\t\t"+res.getString("extra");
				}
				stm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return returnList;
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
	   
	   public void addUser(int id,String[] lis) {
		   try {
				stm = con.createStatement();
				String sql = "INSERT INTO user (username,sex, email, userid,IDcard, unit,phone) VALUES " +
						String.format("(\"%s\",\"%s\",\"%s\",%d,\"%s\",\"%s\",\"%s\");"
								       ,lis[0],lis[1],lis[2],id,lis[3],lis[4],lis[5]);
				stm.executeUpdate(sql);
				stm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	   }
	   public void addEquipment(int id,String[] lis) {
		   try {
				stm = con.createStatement();
				String sql = "INSERT INTO test3 (EquNumber,EquName,EquDate,EquSta,EquClass,EquUnit,supplier,PresentPosition,Maintainer,UnitPrice,extra) VALUES " +
						String.format("(%d,\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\",\"%s\");"
								       ,id,lis[0],lis[1],lis[2],id,lis[3],lis[4],lis[5],lis[6],lis[7],lis[8],lis[9]);
				stm.executeUpdate(sql);
				stm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	   }
	   
	   public void updateEquipment(int id,String[] lis) {
			try {
				stm=con.createStatement();
				String sql=String.format("update test3 set EquName='%s',EquDate='%s',EquSta='%s',EquClass='%s',EquUnit='%s',supplier='%s',PresentPosition='%s',Maintainer='%s',UnitPrice='%s',extra='%s' where EquNumber=%d"
										,lis[1],lis[2],lis[3],lis[4],lis[5],lis[6],lis[6],lis[7],lis[8],lis[9],id);
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
