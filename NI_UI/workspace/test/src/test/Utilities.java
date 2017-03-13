package test;

import java.io.File;
import java.io.FileNotFoundException;

public class Utilities {
	
	public Utilities(){}
	
	public String getFilePath(String fileName){
		try{
			fileName = _getFilePath(fileName);
			fileName = "file://"+fileName;
		} catch(FileNotFoundException e){
			System.out.println("File not found: " + e.toString());
		}	
		return fileName;
	}
	
	// returns the whole path of given filename
	private String _getFilePath(String fName) throws FileNotFoundException{
		java.net.URL url = getClass().getResource(fName);
		File file = new File(url.getPath());
		return file.toString();
	}
}
