
package xfire;

import java.net.MalformedURLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Vector;

import javax.xml.namespace.QName;
import org.codehaus.xfire.XFireRuntimeException;
import org.codehaus.xfire.aegis.AegisBindingProvider;
import org.codehaus.xfire.annotations.AnnotationServiceFactory;
import org.codehaus.xfire.annotations.jsr181.Jsr181WebAnnotations;
import org.codehaus.xfire.client.XFireProxyFactory;
import org.codehaus.xfire.jaxb2.JaxbTypeRegistry;
import org.codehaus.xfire.service.Endpoint;
import org.codehaus.xfire.service.Service;
import org.codehaus.xfire.soap.AbstractSoapBinding;
import org.codehaus.xfire.transport.TransportManager;

public class XfireAPIClient {

    private static XFireProxyFactory proxyFactory = new XFireProxyFactory();
    private HashMap endpoints = new HashMap();
    private Service service0;

    public XfireAPIClient() {
        create0();
        Endpoint XfireAPIHttpPortEP = service0 .addEndpoint(new QName("http://xfire", "XfireAPIHttpPort"), new QName("http://xfire", "XfireAPIHttpBinding"), "http://localhost:9090/TeachingDemo-XFire/services/XfireAPI");
        endpoints.put(new QName("http://xfire", "XfireAPIHttpPort"), XfireAPIHttpPortEP);
        Endpoint XfireAPIPortTypeLocalEndpointEP = service0 .addEndpoint(new QName("http://xfire", "XfireAPIPortTypeLocalEndpoint"), new QName("http://xfire", "XfireAPIPortTypeLocalBinding"), "xfire.local://XfireAPI");
        endpoints.put(new QName("http://xfire", "XfireAPIPortTypeLocalEndpoint"), XfireAPIPortTypeLocalEndpointEP);
    }

    public Object getEndpoint(Endpoint endpoint) {
        try {
            return proxyFactory.create((endpoint).getBinding(), (endpoint).getUrl());
        } catch (MalformedURLException e) {
            throw new XFireRuntimeException("Invalid URL", e);
        }
    }

    public Object getEndpoint(QName name) {
        Endpoint endpoint = ((Endpoint) endpoints.get((name)));
        if ((endpoint) == null) {
            throw new IllegalStateException("No such endpoint!");
        }
        return getEndpoint((endpoint));
    }

    public Collection getEndpoints() {
        return endpoints.values();
    }

    private void create0() {
        TransportManager tm = (org.codehaus.xfire.XFireFactory.newInstance().getXFire().getTransportManager());
        HashMap props = new HashMap();
        props.put("annotations.allow.interface", true);
        AnnotationServiceFactory asf = new AnnotationServiceFactory(new Jsr181WebAnnotations(), tm, new AegisBindingProvider(new JaxbTypeRegistry()));
        asf.setBindingCreationEnabled(false);
        service0 = asf.create((xfire.XfireAPIPortType.class), props);
        {
            AbstractSoapBinding soapBinding = asf.createSoap11Binding(service0, new QName("http://xfire", "XfireAPIPortTypeLocalBinding"), "urn:xfire:transport:local");
        }
        {
            AbstractSoapBinding soapBinding = asf.createSoap11Binding(service0, new QName("http://xfire", "XfireAPIHttpBinding"), "http://schemas.xmlsoap.org/soap/http");
        }
    }

    public XfireAPIPortType getXfireAPIHttpPort() {
        return ((XfireAPIPortType)(this).getEndpoint(new QName("http://xfire", "XfireAPIHttpPort")));
    }

    public XfireAPIPortType getXfireAPIHttpPort(String url) {
        XfireAPIPortType var = getXfireAPIHttpPort();
        org.codehaus.xfire.client.Client.getInstance(var).setUrl(url);
        return var;
    }

    public XfireAPIPortType getXfireAPIPortTypeLocalEndpoint() {
        return ((XfireAPIPortType)(this).getEndpoint(new QName("http://xfire", "XfireAPIPortTypeLocalEndpoint")));
    }

    public XfireAPIPortType getXfireAPIPortTypeLocalEndpoint(String url) {
        XfireAPIPortType var = getXfireAPIPortTypeLocalEndpoint();
        org.codehaus.xfire.client.Client.getInstance(var).setUrl(url);
        return var;
    }
    
    public void profile(XfireAPIPortType service) {
    	System.out.println("Please input the id:");
		Scanner scan = new Scanner(System.in);
	    int id = scan.nextInt();
    	String lis[]=service.userProfile(id);
    	System.out.println("Name\t"+"Sex\t"+"Unit\t"+"Email\t\t"+"IDcard\t"+"Phone");
		for(int i=0;i<lis.length;i++)
			System.out.print(lis[i]+"\t");
		System.out.println();
    }
    
	public void queryThingFuzzy(XfireAPIPortType service) {
		Scanner scan = new Scanner(System.in);
	    String name = scan.nextLine();
	    String[] returnList=service.userSelectThingFuzzy(name);
	    
	    System.out.println("Number\t\t"+"Name\t\t"+"Date\t\t\t"+"Sta\t\t"+"Class\t\t\t"+"EquUnit\t\t"+"Position\t\t"+"Supplier\t\t"+"Maintainer\t"
                +"UnitPrice\t"+"Extra");
	    for(int j=0;j<returnList.length && returnList[j]!=null;j++)
		 {
			 System.out.println(returnList[j]);
		 }
	}
	public void queryThingAccurate(XfireAPIPortType service) {
		Scanner scan = new Scanner(System.in);
	    int id = scan.nextInt();
	    String returnList=service.userSelectThingAccurate(id);
	    
	    System.out.println("Number\t\t"+"Name\t\t"+"Date\t\t\t"+"Sta\t\t"+"Class\t\t\t"+"EquUnit\t\t"+"Position\t\t"+"Supplier\t\t"+"Maintainer\t"
                +"UnitPrice\t"+"Extra");

		System.out.println(returnList);
	}
	public void deleteThing(XfireAPIPortType service) {
		System.out.println("Please input the id:");
		Scanner scan = new Scanner(System.in);
	    int choice = scan.nextInt();
		service.userDeleteThing(choice);
		System.out.println("ojbk");
	}
	public void addUser(XfireAPIPortType service) {
		System.out.println("Please input the order by uername,sex,email,idcard,unit,phone");
		String[] lis=new String[6];
		for(int i=0;i<6;i++)
		{
			Scanner scan = new Scanner(System.in);
			lis[i]=scan.nextLine();;
		}
		System.out.println("your id is "+service.userAdd(lis));
	}
	public void updateThing(XfireAPIClient client,XfireAPIPortType service) {
		
		Scanner scan = new Scanner(System.in);
	    int id = scan.nextInt();
	    String returnList=service.userSelectThingAccurate(id);
	    
	    System.out.println("Number\t\t"+"Name\t\t"+"Date\t\t\t"+"Sta\t\t"+"Class\t\t\t"+"EquUnit\t\t"+"Position\t\t"+"Supplier\t\t"+"Maintainer\t"
                +"UnitPrice\t"+"Extra");

		System.out.println(returnList);
		String[] name={"Number","Name","Date","Sta","Class","EquUnit","Position","Supplier","Maintainer","UnitPrice","Extra"};
		String[] changList=returnList.split("\t\t");
		for(int i=1;i<10;i++) {
			System.out.println("Would you chang it? "+name[i]+" = "+changList[i]);
			Scanner tmp = new Scanner(System.in);
		    String choice = tmp.nextLine();
		    if(choice.equals("Yes")) {
		    	Scanner tmp2 = new Scanner(System.in);
			    String change = tmp2.nextLine();
			    changList[i]=change;
		    }
		}
		service.userUpdate(id,changList);
		System.out.println("Update over"+"\n");
		System.out.println(service.userSelectThingAccurate(id));
	}
	public void addEquipment(XfireAPIPortType service) {
		System.out.println("Please input the order by EquName,Date,Sta,EquClass,EquUnit,supplier,Position,Maintainer,UnitPrice,extra");
		String[] lis=new String[10];
		for(int i=0;i<10;i++)
		{
			Scanner scan = new Scanner(System.in);
			lis[i]=scan.nextLine();;
		}
		service.userAddEquipment(lis);
	}
	
	public void mean(XfireAPIClient client,XfireAPIPortType service) {
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
	    	    	case 1:client.profile(service);break;
	    	    	case 2:client.queryThingFuzzy(service);break;
	    	    	case 3:client.queryThingAccurate(service);break;
	    	    	case 4:client.deleteThing(service);break;
	    	    	case 5:client.addUser(service);break;
	    	    	case 6:client.updateThing(client,service);break;
	    	    	case 7:client.addEquipment(service);break;
	    	    	default:break;
	    	    
	    	    }
	        }
	}
    public static void main(String[] args) {
        

        XfireAPIClient client = new XfireAPIClient();
        
		//create a default service endpoint
        XfireAPIPortType service = client.getXfireAPIHttpPort();
        
       
        client.mean(client,service);
    }

}
