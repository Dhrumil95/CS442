/*
 * mainpage: This class instantiates the application with various
 *   options for the user. Data is taken from the City of Chicago
 *   database (https://data.cityofchicago.org) and shown onto maps
 *   and lists within this application.
 *
 * --> Be mindful of absolute paths used within this class
 *
 * Partial Code comes directly from TeamDev, creators of JxBrowser,
 *   for its functionality:
 * Copyright (c) 2000-2017 TeamDev Ltd. All rights reserved.
 * TeamDev PROPRIETARY and CONFIDENTIAL.
 * Use is subject to license terms.
 */

package test;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;

public class mainpage
{
	private String imagePath = null;
	private JFrame frmNeighborhoodInformant;
	
	private class TimerListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			// reading from the data file
			JSON js = new JSON();
			js.makeJSON("data/2016.csv");
			//js.printAll();
			
			ArrayList<Data> data = js.getDataObject();
			
			// uploading to the database
			int i = 0;
			for(Data d : data){
				//Database.getDatabase().addNewData(d, d.id);
				i++;
			}
		}
	}
	
	public void fetchEveryTwoMinutes(){
		Timer t = new Timer(10000, new TimerListener());
		t.start();
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainpage window = new mainpage();
					window.frmNeighborhoodInformant.setVisible(true);
					
					window.fetchEveryTwoMinutes();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public mainpage() throws FileNotFoundException, IOException {
		initialize();
	}


	private void initialize() {
		imagePath = new Utilities().getFilePathWithoutFile("chitown.jpg");
		frmNeighborhoodInformant = new JFrame("Neighborhood Informant");
		frmNeighborhoodInformant.getContentPane().setBackground(Color.BLACK);
		frmNeighborhoodInformant.setTitle("Neighborhood Informant");
		frmNeighborhoodInformant.setBounds(100, 100, 906, 446);
		frmNeighborhoodInformant.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmNeighborhoodInformant.getContentPane().setLayout(null);
		frmNeighborhoodInformant.setLocationRelativeTo(null);

		//crime data button
		JButton btnCrime = new JButton("Crime Rates");
		btnCrime.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		btnCrime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				//instantiate the class to show the crime data
				new CrimeMap(frmNeighborhoodInformant);
				frmNeighborhoodInformant.setVisible(false);
			}
		});
		btnCrime.setBounds(31, 59, 218, 40);
		frmNeighborhoodInformant.getContentPane().add(btnCrime);

		//avg income capita data button
		JButton btnHomes = new JButton("Avg Income/Capita");
		btnHomes.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		btnHomes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnHomes.setBounds(31, 111, 218, 40);
		frmNeighborhoodInformant.getContentPane().add(btnHomes);

		JButton btnExit = new JButton("Exit");
		btnExit.setBackground(Color.YELLOW);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(31, 338, 218, 40);
		frmNeighborhoodInformant.getContentPane().add(btnExit);

		//tax increment financing info button
		JButton btnTaxIncrementFinancing = new JButton("Tax Increment Financing");
		btnTaxIncrementFinancing.setBackground(Color.DARK_GRAY);
		btnTaxIncrementFinancing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTaxIncrementFinancing.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		btnTaxIncrementFinancing.setBounds(31, 163, 218, 53);
		frmNeighborhoodInformant.getContentPane().add(btnTaxIncrementFinancing);

		JButton btnUpdateMap = new JButton("Problematic Landlords");
		btnUpdateMap.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		btnUpdateMap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//instantiate the class to show the landlord data
				new LandLord(frmNeighborhoodInformant);
				frmNeighborhoodInformant.setVisible(false);
			}
		});
		btnUpdateMap.setBounds(31, 228, 218, 40);
		frmNeighborhoodInformant.getContentPane().add(btnUpdateMap);

		JButton btnSchools = new JButton("City of Chicago Homepage");
		btnSchools.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		btnSchools.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//instantiate the class to show the browser to allow access to City of Chicago website
				new CityWeb(frmNeighborhoodInformant);
				frmNeighborhoodInformant.setVisible(false);
			}
		});
		btnSchools.setBounds(31, 280, 218, 40);
		frmNeighborhoodInformant.getContentPane().add(btnSchools);

		//divider between option buttons and exit button
		JLabel lblNewLabel = new JLabel("______________________________________");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(6, 313, 292, 16);
		frmNeighborhoodInformant.getContentPane().add(lblNewLabel);

		//titles
		JLabel lblNeighboorhoodInformant = new JLabel("Neighboorhood Informant ");
		lblNeighboorhoodInformant.setHorizontalAlignment(SwingConstants.CENTER);
		lblNeighboorhoodInformant.setForeground(Color.CYAN);
		lblNeighboorhoodInformant.setFont(new Font("Arial", Font.BOLD, 25));
		lblNeighboorhoodInformant.setBounds(16, 0, 894, 67);
		frmNeighborhoodInformant.getContentPane().add(lblNeighboorhoodInformant);

		JLabel lblYourstopApplication = new JLabel("Your 1-stop application for Chicagoland data!");
		lblYourstopApplication.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblYourstopApplication.setForeground(Color.RED);
		lblYourstopApplication.setHorizontalAlignment(SwingConstants.CENTER);
		lblYourstopApplication.setBounds(16, 45, 894, 33);
		frmNeighborhoodInformant.getContentPane().add(lblYourstopApplication);

		//show chicago picture on GUI
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(imagePath));
		lblNewLabel_1.setBounds(274, 22, 612, 413);
		frmNeighborhoodInformant.getContentPane().add(lblNewLabel_1);

		//add menu + items to menu
		JMenuBar menuBar = new JMenuBar();
		frmNeighborhoodInformant.setJMenuBar(menuBar);

		JMenu mnOptions = new JMenu("Options");
		menuBar.add(mnOptions);

		JMenuItem mntmExit = new JMenuItem("Exit ");
		mnOptions.add(mntmExit);
	}
}
