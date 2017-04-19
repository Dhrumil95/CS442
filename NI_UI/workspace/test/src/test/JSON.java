package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class JSON {
	
	private ArrayList<Data> dataObject;
	
	JSON(){
		dataObject = new ArrayList<Data>();
	}
	
	// prints the entire dataObject
	public void printAll(){
		for(Data d : dataObject ){
			System.out.println(d);
		}
		
		System.out.println("total length: " + dataObject.size());
	}
	
	// checks to see if a given string is of type integer
	private boolean isInteger(String s){
		try{
			Integer.parseInt(s);
		} catch (Exception e){
			return false;
		}
		return true;
	}
	
	// checks to see if a given string is of type double
	private boolean isDouble(String s){
		try{
			Double.parseDouble(s);
		} catch (Exception e){
			return false;
		}
		
		return true;
	}
	
	private boolean _isLatLonValid(double min, double max, String comp){
		try{
			double d = Double.parseDouble(comp);
			if(d < min && d > max){
				return true;
			}
		} catch (Exception e){
			return false;
		}
		
		return false;
	}
	
	private boolean isLatitudeValid(String s){
		return _isLatLonValid(41.875, 41.850, s);
	}
	
	private boolean isLongitudeValid(String s){
		return _isLatLonValid(-87.627, -87.656, s);
	}
	
	/*
	 * Open the file name of type parameter
	 * reads line by line and splits it by comma (,)
	 * performs a check if the year is integer and co-ordinates (longitude, latitude) are or type double
	 * adds to dataObject of type ArrayList
	 */
	public void makeJSON(String fName){
	
		String line = "";
		String fileName = new Utilities().getFilePathWithoutFile(fName);
		try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
			while((line = br.readLine()) != null){
				String[] data = line.split(",");
				
				// checks to see if there are data will empty values or missing parameters
				if(data.length <= 20) continue;
				if(data[3] == null || data[17] == null || data[19] == null || data[20] == null) continue;
				
				// address
				String address = data[3];
				
				// year
				String year = data[17];
				
				// latitude
				String lat = data[19];
				
				// longitude
				String lon = data[20];
				
				// checking if all the variables are valid integer and doubles
				if(isInteger(year) && isDouble(lat) && isDouble(lon)){
					if(isLongitudeValid(lon) && isLatitudeValid(lat)){
						dataObject.add(new Data(year, lon, lat, address));
					} else {
						System.out.println("lon: " + lon + " lat: " + lat);
					}
				}
			}
		} catch (IOException e){
			e.printStackTrace();
		}
	}

}
