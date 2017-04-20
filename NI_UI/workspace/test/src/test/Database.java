package test;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseCredentials;
import com.google.firebase.database.*;
import com.google.firebase.database.Transaction.Result;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class Database {
	private final String DATABASE_URL = "https://cs442-61428.firebaseio.com";
	private static DatabaseReference database;
	
	private static Database d = new Database();
	
	private Database(){
		initialize();
	}
	
	public static Database getDatabase(){
		return d;
	}
	
	private void initialize(){
		try{
			FileInputStream serviceAccount = new FileInputStream(new Utilities().getFilePathWithoutFile("service_account.json"));
			FirebaseOptions options = new FirebaseOptions.Builder()
					.setCredential(FirebaseCredentials.fromCertificate(serviceAccount))
					.setDatabaseUrl(DATABASE_URL)
					.build();
			FirebaseApp.initializeApp(options);
			
		} catch (FileNotFoundException e){
			System.out.println("File not found: " + e);
		}
		
		database = FirebaseDatabase.getInstance().getReference();
	}
	
	public void addNewData(Data d, String node){
		
		System.out.println("node: " + node);
		
		database.child("year").child(node).runTransaction(new Transaction.Handler() {
			
			@Override
			public void onComplete(DatabaseError arg0, boolean arg1, DataSnapshot arg2) {
				System.out.println("succesfully added data: " + arg2);
				
			}
			
			@Override
			public Result doTransaction(MutableData mutableData) {
				mutableData.setValue(d);
				return Transaction.success(mutableData);
			}
		});
	}
	
}
