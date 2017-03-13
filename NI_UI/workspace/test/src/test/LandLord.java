package test;

import javax.swing.JFrame;

public class LandLord{
	
	public LandLord(JFrame mainMenu) {
		String fileName = new Utilities().getFilePath("landlordmap.html");
		new ProjectBrowser("Chicago Problematic Lanlords Data", fileName, mainMenu);
	}
}

