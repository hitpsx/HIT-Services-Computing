package dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Device {
	private int EquNumber;
    private String EquName;
    private String EquDate;
    private String EquSta;
    private String EquClass;
    private String EquUnit;
    private String Supplier;
    private String Maintainer;
    private String PresentPosition;
    private String UnitPrice;
    private String extra;
    
    
    public Device(int EquNumber, String EquName, String EquDate, String EquSta, String EquClass,
            String EquUnit, String Supplier,String Maintainer, String PresentPosition, String UnitPrice,String extra) {
		super();
		 	this.EquNumber = EquNumber;
	        this.EquName = EquName;
	        this.EquDate = EquDate;
	        this.EquSta = EquSta;
	        this.EquClass = EquClass;
	        this.EquUnit = EquUnit;
	        this.Supplier = Supplier;
	        this.Maintainer = Maintainer;
	        this.PresentPosition = PresentPosition;
	        this.UnitPrice=UnitPrice;
	        this.extra=extra;
	}
    public Device() {
	}
    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public String getEquSta() {
        return EquSta;
    }

    public void setEquSta(String EquSta) {
        this.EquSta = EquSta;
    }

    public String getEquClass() {
        return EquClass;
    }

    public void setEquClass(String EquClass) {
        this.EquClass = EquClass;
    }

    public String getEquUnit() {
        return EquUnit;
    }

    public void setEquUnit(String EquUnit) {
        this.EquUnit = EquUnit;
    }

    public int getEquNumber() {
        return EquNumber;
    }

    public void setEquNumber(int EquNumber) {
        this.EquNumber = EquNumber;
    }

    public String getEquName() {
        return EquName;
    }

    public void setEquName(String EquName) {
        this.EquName = EquName;
    }

    public String getEquDate() {
        return EquDate;
    }

    public void setEquDate(String EquDate) {
        this.EquDate = EquDate;
    }


    public String getSupplier() {
        return Supplier;
    }

    public void setSupplier(String Supplier) {
        this.Supplier = Supplier;
    }

    public String getMaintainer() {
        return Maintainer;
    }

    public void setMaintainer(String Maintainer) {
        this.Maintainer = Maintainer;
    }
    public String getPresentPosition() {
        return PresentPosition;
    }

    public void setPresentPosition(String PresentPosition) {
        this.PresentPosition = PresentPosition;
    }

    public String getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(String UnitPrice) {
        this.UnitPrice = UnitPrice;
    }


	
}
