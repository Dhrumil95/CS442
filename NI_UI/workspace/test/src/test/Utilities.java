package test;

import java.io.File;
import java.io.FileNotFoundException;

public class Utilities {
	
	public Utilities(){}
	
	// returns the whole path of given filename
	private String _getFilePath(String fName) throws FileNotFoundException{
		java.net.URL url = getClass().getResource(fName);
		File file = new File(url.getPath());
		return file.toString();
	}
	
	private String getFilePathHelper(String fileName){
		try{
			fileName = _getFilePath(fileName);
		} catch(FileNotFoundException e){
			System.out.println("File not found: " + e.toString());
		}	
		return fileName;
	}
	
	public String getFilePathWithoutFile(String fileName){
		System.out.println("inside getFilePathWihtoutFile");
		return getFilePathHelper(fileName);
	}
	
	public String getFilePath(String fileName){
		System.out.println("inside getFilePath");
		return "file//" + getFilePathHelper(fileName);
	}

}
