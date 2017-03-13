package test;

import java.io.File;
import java.io.FileNotFoundException;

public class Utilities {
	
	public Utilities(){}
	
	// returns the whole path of given filename
	public String getFilePath(String fName) throws FileNotFoundException{
		java.net.URL url = getClass().getResource(fName);
		File file = new File(url.getPath());
		return file.toString();
	}
}
