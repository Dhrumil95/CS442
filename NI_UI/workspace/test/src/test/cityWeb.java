
/*
 * cityWeb: This class instantiates the City of Chicago data 
 *   website (https://data.cityofchicago.org) for the user.
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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;

@SuppressWarnings("serial")
public class cityWeb extends JFrame {
	
	public cityWeb(JFrame mainMenu)
	{
		final Browser browser = new Browser();
	    BrowserView view = new BrowserView(browser);

	    JFrame frame = new JFrame("City of Chicago Official Site");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(1100, 700);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
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

        browser.loadURL("https://data.cityofchicago.org");
   	    frame.setVisible(true); 
	}
}
