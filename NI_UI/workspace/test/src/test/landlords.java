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
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.teamdev.jxbrowser.chromium.*;
import com.teamdev.jxbrowser.chromium.swing.*;

@SuppressWarnings("serial")
public class landlords
{
	private String landlordMapPath = null;
	
	// initializes everything
	private void initialize(){
		try{
			landlordMapPath = new Utilities().getFilePath("landlordmap.html");
		} catch(FileNotFoundException e){
			System.out.println("File not found: " + e.toString());
		}
	}
	
	public landlords(JFrame mainMenu) 
	{
		// initializes everything
		initialize();
		
		final Browser browser = new Browser();
        BrowserView view = new BrowserView(browser);

        JFrame frame = new JFrame("Chicago Problematic Lanlords Data");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(1100, 600);
        frame.setLocationRelativeTo(null); 
        
        String loadmap = "file://" + landlordMapPath;
        browser.loadURL(loadmap);
		
        
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

        frame.add(view, BorderLayout.CENTER);
        frame.add(toolBar, BorderLayout.SOUTH);		
        frame.setVisible(true);       
	}

}
