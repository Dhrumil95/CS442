package test;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;

public class ProjectBrowser {
	
	private Browser browser;
	private BrowserView browserView;
	private JFrame frame, mainMenu;
	
	public ProjectBrowser(String windowTitle, String fileName, JFrame mainMenu){
		// create generic browser
		this.mainMenu = mainMenu;
		browser = new Browser();
        browserView = new BrowserView(browser);
        
        frame = new JFrame(windowTitle);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(1100, 600);
        frame.setLocationRelativeTo(null); 
        
        browser.loadURL(fileName);
        
        addBrowserToFrame();
        addBackButton();
	}
	
	private void addBackButton(){
		JButton backButton = new JButton("Back to Main Menu");
        backButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				frame.setVisible(false);
                mainMenu.setVisible(true);
			}
        });
             
        JPanel toolBar = new JPanel();
        toolBar.add(backButton);
        
        frame.add(toolBar, BorderLayout.SOUTH);		
        frame.setVisible(true);
	}
	
	private void addBrowserToFrame(){
		frame.add(browserView, BorderLayout.CENTER);
	}
}
