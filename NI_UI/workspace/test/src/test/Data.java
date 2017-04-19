package test;

public class Data {
	
	private String year;
	private String longitude;
	private String latitude;
	private String address;
	
	Data(String y, String lo, String la, String addr){
		year = y;
		longitude = lo;
		latitude = la;
		address = addr;
	}
	
	private String getYear(){
		return year;
	}
	
	private String getLongitude(){
		return longitude;
	}
	
	private String getLatitude(){
		return latitude;
	}
	
	private String getAddress(){
		return address;
	}
	
	// over writing the toString for System.out.println
	public String toString(){
		return "{" + 
					"\"year\" : " + "\"" + getYear() + "\"," +
					"\"longitude\" : " + "\"" + getLongitude() + "\"," +
					"\"latitude\" : " + "\"" + getLatitude() + "\"," +
					"\"address\" : " + "\"" + getAddress() + "\"," +
				"},";
	}

}
