package servicedemos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.sun.jersey.spi.resource.Singleton;
import dto.*;
import db.MySQL;

@Path("user")
@Singleton
public class UserServices {

	@GET
	@Path("getProfile/{num}")
	@Produces("application/json")
	@Consumes("application/json")
	public User getProfile(@PathParam("num") int num) {
		MySQL sql=new MySQL();
		User user=sql.userProfile(num);
		System.out.println(user.getEmail());
		return user;
	}
	
	
	@GET
	@Path("getThingFuzzly/{num}")
	@Produces("application/json")
	@Consumes("application/json")
	public List<Device> getThingFuzzly(@PathParam("num") String num) {
		MySQL sql=new MySQL();
		List<Device> ctl = new ArrayList<Device>();
		ctl=sql.userSelectThing(num);
		System.out.println(ctl.size());
		return ctl;
	}
	
	@GET
	@Path("getThing/{id}")
	@Produces("application/json")
	@Consumes("application/json")
	public Device getThing(@PathParam("id") int id) {
	  MySQL sql=new MySQL();
	  Device d=sql.userGetThing(id);
	  return d;
	}
	
	@POST
	@Path("addUser")
	@Produces("application/json")
	@Consumes("application/json")
	public User addUser(User user) {
	  MySQL sql=new MySQL();
	  int id=sql.Number();
	  user.setUserid(id+1);
	  sql.addUser(user);
	  User s=sql.userInformation(id+1);
	  return s;
	}
	
	@DELETE
	@Path("deleteDevice/{num}")
	@Produces("application/json")
	@Consumes("application/json")
	public Device deleteDevice(@PathParam("num") int num) {
		MySQL sql=new MySQL();
		Device d=sql.userGetThing(num-1);
		sql.userDeleteThing(num);
		return d;
	}
	

	@POST
	@Path("addDevice")
	@Produces("application/json")
	@Consumes("application/json")
	public Device addDevice(Device device) {
	  MySQL sql=new MySQL();
	  int id=sql.equNumber();
	  System.out.println(id);
	  device.setEquNumber(id);
	  sql.addEquipment(device);
	  Device d=sql.userGetThing(id);
	  return d;
	}
	
	@POST
	@Path("updateDevice")
	@Produces("application/json")
	@Consumes("application/json")
	public Device updateDevice(Device device) {
	  MySQL sql=new MySQL();
	  sql.userUpdateDevice(device);
	  return device;
	}
}

