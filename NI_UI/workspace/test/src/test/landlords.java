/*
 * landlords: This class instantiates a Google Map with information
 *   about problematic landlords. Data from from the City of Chicago
 *   database (https://data.cityofchicago.org).
 * 
 * --> Be mindful of absolute path used within this class
 * 
 * Partial Code comes directly from TeamDev, creators of JxBrowser, 
 *   for its functionality:
 * Copyright (c) 2000-2017 TeamDev Ltd. All rights reserved.
 * TeamDev PROPRIETARY and CONFIDENTIAL.
 * Use is subject to license terms.
 * 
 */

package test;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;

@SuppressWarnings("serial")
public class landlords extends JFrame 
{
	String landlordMapPath = "/Users/aiwanhazari/Desktop/NI_UI/workspace/test/src/test/landlordmap.html";
	public landlords(JFrame mainMenu) 
	{
		final Browser browser = new Browser();
        BrowserView view = new BrowserView(browser);

        JFrame frame = new JFrame("Chicago Problematic Lanlords Data");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(1100, 600);
		setBounds(100, 100, 636, 441);
        frame.setLocationRelativeTo(null); 
        
        File checkfile = new File(landlordMapPath); 
        if(checkfile.exists() == true)
        {
        	System.out.println("Loading Map...");
        	frame.setVisible(true); 
        	//load the map HTML file
        	String loadmap = "file://" + landlordMapPath;
            browser.loadURL(loadmap);
        }
        else
        {
         	JOptionPane.showMessageDialog(null, "Unable to load map!");
         	frame.setVisible(false); 
        }
		
        
        JButton backButton = new JButton("Back to Main Menu");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                mainMenu.setVisible(true);
            }
        });
             
        JPanel toolBar = new JPanel();
        toolBar.add(backButton);

        frame.add(view, BorderLayout.CENTER);
        frame.add(toolBar, BorderLayout.SOUTH);		
        frame.setVisible(true);       
	}

}
