package test;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseCredentials;
import com.google.firebase.database.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class Database {
	private final String DATABASE_URL = "https://cs442-61428.firebaseio.com";
	private DatabaseReference database;
	
	Database(){
		initialize();
	}
	
	private void initialize(){
		try{
			FileInputStream serviceAccount = new FileInputStream("filestring.json");
			FirebaseOptions options = new FirebaseOptions.Builder()
					.setCredential(FirebaseCredentials.fromCertificate(serviceAccount))
					.setDatabaseUrl(DATABASE_URL)
					.build();
			
		} catch (FileNotFoundException e){
			System.out.println("File not found: " + e);
		}
		
		database = FirebaseDatabase.getInstance().getReference();
	}
	
}
