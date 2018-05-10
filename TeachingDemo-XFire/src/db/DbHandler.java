package db;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

/**
 *
 * @author hit
 */
public class DbHandler {
    
    public Connection getConnection() throws SQLException{
        try{
            //����Class.forName()����������������
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("�ɹ�����MySQL������");
        }catch(ClassNotFoundException e1){
            System.out.println("�Ҳ���MySQL����!");
            e1.printStackTrace();
        }
        
        String url="jdbc:mysql://localhost:3306/project";    //JDBC��URL    
        //����DriverManager�����getConnection()���������һ��Connection����
        Connection conn = null;
        try {
            conn = (Connection) DriverManager.getConnection(url, "root","woaini123");
            
            System.out.print("�ɹ����ӵ����ݿ⣡");
         } catch (SQLException e){
            e.printStackTrace();
            conn.close();
        }
        return conn;
    }
    
    public String getUsers(String name, String cardNum) throws SQLException{
        Connection conn = getConnection();
        String result = "";
        //����һ��Statement����
        try{
            java.sql.Statement stmt = conn.createStatement(); //����Statement����
            String sql = "select * from patient where 1=1 ";
            if(!name.trim().equals(""))
                sql += "and name like '%" + name + "%'";
                        
            if(!cardNum.trim().equals(""))
                sql += "and card_num like '%" + cardNum + "%'";
            
            System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);//�������ݶ���
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            while(rs.next()){
                String temp = rs.getString(2) + "@" + (rs.getInt(3)==1?"��":"Ů") + "@" + String.valueOf(rs.getInt(4)) 
                	+ "@" + rs.getString(8);
                result += temp + "#";
            }
            stmt.close();
            conn.close();
        } catch (SQLException e){
            e.printStackTrace();
            conn.close();
        }
        return result;        
    }
    public int Number() {
		int p=0;
		try {
			Connection conn = getConnection();
			java.sql.Statement stmt = conn.createStatement(); 
			String sql = String.format("SELECT count(*) number FROM user");
			ResultSet res = stmt.executeQuery(sql);
			if(res.next()) {
				p=res.getInt("number");
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return p;
	}
    
    public String userUnit(int userid) throws SQLException {
		String unit="";
		Connection conn = getConnection();
		try {
			java.sql.Statement stm = conn.createStatement();
			String sql = String.format("SELECT unit FROM user where userid = %d",userid);
			ResultSet res = stm.executeQuery(sql);
			if(res.next()) {
				unit=res.getString("Unit");
			}
			stm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return unit;
	}
    
 
    
    public Vector<String[]> getUserList(String name, String cardNum) throws SQLException{
        Connection conn = getConnection();
        Vector<String[]> returnList = new Vector<String[]>();
        //����һ��Statement����
        try{
            java.sql.Statement stmt = conn.createStatement(); //����Statement����
            String sql = "select * from patient where 1=1 ";
            if(!name.trim().equals(""))
                sql += "and name like '%" + name + "%'";
                        
            if(!cardNum.trim().equals(""))
                sql += "and card_num like '%" + cardNum + "%'";
            
            System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);//�������ݶ���
            while(rs.next()){
                String[] args = {rs.getString(2), rs.getInt(3)==1?"��":"Ů", String.valueOf(rs.getInt(4)), rs.getString(8)};
                returnList.addElement(args);
            }
            stmt.close();
            conn.close();
        } catch (SQLException e){
            e.printStackTrace();
            conn.close();
        }
        return returnList;        
    }
}

