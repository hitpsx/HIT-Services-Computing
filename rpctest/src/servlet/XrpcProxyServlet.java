package servlet;
import java.io.*;
import java.util.Vector;

import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.xmlrpc.XmlRpcServer;

import com.sql.MySQL;
public class XrpcProxyServlet extends HttpServlet {
	
		private XmlRpcServer xmlrpc = new XmlRpcServer();
		
		public XrpcProxyServlet() {}
		
		public void init() throws ServletException {
			
			xmlrpc.addHandler("user", this);
			xmlrpc.setMaxThreads(30);
			
		}
		
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				byte[] result = xmlrpc.execute(request.getInputStream());
				response.setContentType("text/xml");
				response.setContentLength(result.length);
				OutputStream out = response.getOutputStream();
				out.write(result);
				out.flush();
				out.close();
		}
		
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				doGet(request, response);
		}
		
		public byte[] hello(byte[] paras) {
			String name = new String(paras);
			String result = "hello "+name;
			return result.getBytes();
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
		 
		 public String userDeleteThing(int id) {
			 MySQL sql=new MySQL();
			 sql.userDeleteThing(id);
			 return "successful";
		 }
		 public int userAdd(String lis) {
			 MySQL sql=new MySQL();
			 int id=sql.Number();
			 String []a=new String[6];
			 a=lis.split("\t");
			 sql.addUser(id,a);
			 return id;
		 }
		 public String userAddEquipment(String lis) {
			 MySQL sql=new MySQL();
			 int equNumber=sql.equNumber();
			 String []a=new String[10];
			 a=lis.split("\t");
			 sql.addEquipment(equNumber,a);
			 return "successful";
		 }
		 public String userUpdate(String lis) {
			 MySQL sql=new MySQL();
			 String[] temp=lis.split("\t");
			 int id=Integer.valueOf(temp[0]);
			 sql.updateEquipment(id,temp);
			 return "successful";
		 }
}
