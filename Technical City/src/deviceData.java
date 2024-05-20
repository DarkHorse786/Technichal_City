
public class deviceData {
	
	 	public  String deviceName;
	 	public int ramSize;
	 	public int storageSize;
	 	public String Processor;
	 	public String Availability;
	 	public String companyName;
	    public String picture;
	   

	    public deviceData(String deviceName,String companyName,int ramSize,int storageSize,String Processor,String Availability,String picture) 
	    {
	        this.deviceName = deviceName;
	        this.companyName=companyName;
	        this.ramSize = ramSize;
	        this.storageSize = storageSize;
	        this.Processor = Processor;
	        this.Availability = Availability;
	        this.picture= picture;
	    }
	    public String getcompanyName() {
	        return companyName;
	    }
	    
	    public String getdeviceName() {
	        return deviceName;
	    }

	    public int getstorageSize() {
	        return storageSize;
	    }
	    public int getramSize() {
	        return ramSize;
	    }
	    public String getAvailability() {
	        return Availability;
	    }
	    public String getProcessor() {
	        return Processor;
	    }
	    public String getpicture() {
	        return picture;
	    }

}
