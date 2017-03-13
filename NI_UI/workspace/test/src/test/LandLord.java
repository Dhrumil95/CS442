package test;

import javax.swing.JFrame;

public class LandLord{
	private ProjectBrowser browser;
	public LandLord(JFrame mainMenu) {
		browser = new ProjectBrowser("Chicago Problematic Lanlords Data", "landlordmap.html", mainMenu);
	}
}

