package test;

public class Data {
	
	public String year;
	public String longitude;
	public String latitude;
	public String address;
	public String id;
	
	// empty constructor
	Data(){}
	
	Data(String y, String lo, String la, String addr, String i){
		year = y;
		longitude = lo;
		latitude = la;
		address = addr;
		id = i;
	}
	
	// only un-comment the rest for testing only
	
//	private String getYear(){
//		return year;
//	}
//	
//	private String getLongitude(){
//		return longitude;
//	}
//	
//	private String getLatitude(){
//		return latitude;
//	}
//	
//	private String getAddress(){
//		return address;
//	}
//	
//	// over writing the toString for System.out.println
//	public String toString(){
//		return "{" + 
//					"\"year\" : " + "\"" + getYear() + "\"," +
//					"\"longitude\" : " + "\"" + getLongitude() + "\"," +
//					"\"latitude\" : " + "\"" + getLatitude() + "\"," +
//					"\"address\" : " + "\"" + getAddress() + "\"," +
//				"},";
//	}

}
