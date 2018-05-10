
package xfire;

import java.util.Vector;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;


@WebService(name = "XfireAPIPortType", targetNamespace = "http://xfire")
@SOAPBinding(use = SOAPBinding.Use.LITERAL, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public interface XfireAPIPortType {

	@WebMethod(operationName = "getUsers", action = "")
	@WebResult(name = "out", targetNamespace = "http://xfire")
	public String getUsers(
			@WebParam(name = "in0", targetNamespace = "http://xfire") String in0,
			@WebParam(name = "in1", targetNamespace = "http://xfire") String in1);
	/*@WebMethod(operationName = "Number", action = "")
	@WebResult(name = "out", targetNamespace = "http://xfire")
	public int Number();*/
	public int Number();
	public String userUnit(int id);
	public String[] userProfile(int id);
	public String[] userSelectThingFuzzy(String name);
	public String userSelectThingAccurate(int id);
	public void userDeleteThing(int id);
	public int userAdd(String[] lis);
	public void userAddEquipment(String[] lis);
	public void userUpdate(int id,String[] changList);
}
