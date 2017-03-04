/*
 * crimeMap: This class instantiates a Google Map window with 
 *   crime information plotted onto it. Data from from the City of Chicago
 *   database (https://data.cityofchicago.org).
 * 
 * --> Be mindful of absolute path used within this class
 * 
 * Partial Code comes directly from TeamDev, creators of JxBrowser, 
 *   for its functionality:
 * Copyright (c) 2000-2017 TeamDev Ltd. All rights reserved.
 * TeamDev PROPRIETARY and CONFIDENTIAL.
 * Use is subject to license terms.
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
public class crimeMap extends JFrame 
{
	String mapPath = "/Users/aiwanhazari/Desktop/NI_UI/workspace/test/src/test/crimemap.html";
	
	public crimeMap(JFrame mainMenu) 
	{
		final Browser browser = new Browser();
        BrowserView view = new BrowserView(browser);

        JFrame frame = new JFrame("Chicago Crime Data");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(1100, 600);
		setBounds(100, 100, 636, 441);
        frame.setLocationRelativeTo(null); 
        
        File checkfile = new File(mapPath); 
        if(checkfile.exists() == true)
        {
        	System.out.println("Loading Map...");
        	frame.setVisible(true); 
        	//load the crime map via JxBrowser
        	String loadmap = "file://" + mapPath;
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
